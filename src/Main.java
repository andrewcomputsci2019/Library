/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

import Books.Booklist;
import Books_removed.*;
import User.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.util.function.Predicate;


/**
 * Main class that drives the program
 * @author Andrew Pegg
 * @version .15
 * @see Main
 */
/*
  java doc is a tool that looks at comments and produces an output and makes html
*/
public class Main {
    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.print("hello");
        System.out.println(" world");
        boolean exit = false;
        AccountSaver start = new AccountSaver();

        Userdata userdata = new Userdata(); // set up for management
        Checked_outlist checked_outlist = new Checked_outlist();
        Booklist booklist = new Booklist();
        AvaibleBooks avaibleBooks = new AvaibleBooks();
        avaibleBooks=booklist.Returnhashmapobject();
        Listofusers listofusers = new Listofusers();
        if(start.nullCheck)
        {
            System.out.println("no previous users detected");
        }
        else
        {
            listofusers.listofusers=start.getList();
            String id = listofusers.listofusers.get(listofusers.listofusers.size()-1).getId();
            userdata.setMasterid(id);
        }


        while (!exit)
        {
            System.out.println("would you like to view our books");
            userdata.CreateAccount();
            listofusers.addUserToList(userdata); // adds the userdata object to an array list
            System.out.println(listofusers.listofusers);
            System.out.println(listofusers.getListofUsersString());//prints out the list of users
            listofusers.printFristName(0); //prints out first name of the position of the array
            listofusers.printLastName(0);
            listofusers.printPassword(0);
            System.out.println("Making new account");
            userdata = new Userdata();
            userdata.CreateAccount();
            listofusers.addUserToList(userdata);
           FindUtils var = new FindUtils();
           Scanner input = new Scanner(System.in);
           System.out.println("enter id to search from");
           String str = input.nextLine();
           Userdata account =var.sreachUserData(listofusers.listofusers, str );
           if (account==null)
           {
               System.out.println("sorry we could not find an account matching id " + str);
           }
           else {
               System.out.println(account);
           }
           String[] strings = addBookToList();
           avaibleBooks.AddbookToList(strings[0],strings[1]);
           exit=true;
        }
        AccountSaver var = new AccountSaver(listofusers.getListofUsersArray());

    }

    /**
     * would be used to add books to the file to be read after next startup
     * @return string array
     */
    static String[] addBookToList()
    {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("please enter book name");
            String[] bookdetails = new String[2];
            bookdetails[0] = input.nextLine();
            System.out.println("please enter the isbn now");
            bookdetails[1]=input.nextLine();
            System.out.println("please verify that these are the correct details:\n" +"book name = "+bookdetails[0]+"\n"+
                    "book's isbn = "+bookdetails[1]+ "\nare these correct y/n");
            String check = input.nextLine();
            if (check.equals("y")||check.equals("Y"))
            {
                return bookdetails;
            }
            else
            {
                System.out.println("please follow instruction ahead");
            }
        }

    }

    /**
     * Used to force exit the program
     */
    static void forceQuit()
    {
        Runtime.getRuntime().exit(-1); //force quits the program need to make sure that file writers close
        // going to use this if the program encounter a fatal error and needs to be shut down need to look into what happens when this encours
        // during a file write or read
    }


    /**
     * class to search an array list to find its account
     */
    static class FindUtils
    {
        /**
         * the searching tool that use streams in order to search the given array
         * @param col is a collection of the array ie the array is divided  into sub categories
         * @param filter the flitter is what is used to go through the array and search
         * @param <T> predicate stuff
         * @return returns the userdata object
         */
        public  <T> T findByProperty(Collection<T> col, Predicate<T> filter) {
            return col.stream().filter(filter).findFirst().orElse(null);
        }

        /**
         * This is the data collector and thing that sends the info to  findByProperty
         * @see FindUtils#findByProperty(Collection, Predicate) 
         * @param listuserdata the array list of users that contain the property 
         * @param id this is the id that we want to search for in the array list
         * @return the users data that matches the id given if non matches the id given it will return null
         */
        public Userdata sreachUserData(Collection<Userdata> listuserdata, String id)

        {
            return  findByProperty(listuserdata, userdata -> id.equals(userdata.getId()));
        }
    }

}