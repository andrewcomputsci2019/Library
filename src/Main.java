import Books.Booklist;
import Books_removed.*;
import User.*;


/**
 * Main class that drives the program
 * @author Andrew Pegg
 * @version .10
 * @see Main
 */
/*
  java doc is a tool that looks at comments and produces an output and makes html
*/
public class Main {
    public static void main(String[] args) {
	// write your code here
        System.out.print("hello");
        System.out.println(" world");
        boolean exit = false;
        Userdata userdata = new Userdata(); // set up for management
        AvaibleBooks avaibleBooks = new AvaibleBooks();
        Checked_outlist checked_outlist = new Checked_outlist();
        Booklist booklist = new Booklist();
        Listofusers listofusers = new Listofusers();
        while (!exit)
        {
            System.out.println("would you like to view our books");
            userdata.CreateAccount();
            listofusers.addUserToList(userdata); // adds the userdata object to an array list
            System.out.println(listofusers.listofusers);
            System.out.println(listofusers.getListofUsersString());//prints out the list of users
            listofusers.printFristName(0);
            listofusers.printLastName(0);
            listofusers.printPassword(0);
            exit=true;
        }
    }
}
