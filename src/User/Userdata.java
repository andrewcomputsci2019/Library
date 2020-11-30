/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package User;

import java.util.Scanner;

/**
 * Userdata creates an object that holds an id,password,firstname, and a last name
 *
 */
public class Userdata {
    static int masterid=0;
    private String id;
    private String password;
    private String firstname;
    private String lastname;

    /**
     * Userdata constructor is only here to set values to null
     */
    public Userdata()
    {
        this.password = null;
        this.firstname= null;
        this.lastname=null;
        this.id =null;
    }

    /**
     * toString override used to format a strign return
     * @return String
     */
    @Override
    public String toString()
    {
        return id + " " + password + " " + firstname + " " + lastname;
    }

    /**
     * used for the startup of the program
     * @see AccountSaver
     * @param id just and id passed from AccountSaver
     * @param password a string passed from the AccountSaver
     * @param firstname a string passed from The AccountSaver
     * @param lastname a String passed From the AccountSaver
     */
    public void CreateAccount(String id ,String password, String firstname, String lastname)
    {
        this.lastname=lastname;
        this.firstname=firstname;
        this.id=id;
        this.password=password;
    }

    /**
     * main diver that use sub class to format object fields
     * @see Userdata#setFirstname(String)
     * @see Userdata#setLastname(String)
     * @see Userdata#setPassword(String)
     */
    public void CreateAccount()
    {
        System.out.println("please enter a first name");
        Scanner input = new Scanner(System.in);
        setFirstname(input.nextLine());
        input = new Scanner(System.in);
        System.out.println("please enter a last name");
        setLastname(input.nextLine());
        System.out.print("please enter a password\n");
        input = new Scanner(System.in);
        setPassword(input.nextLine());
        generateId();

    }

    /**
     * setter for password field
     * @param password a string
     */
    private void setPassword(String password)
    {
        this.password= password;
    }

    /**
     * setter for firstname field
     * @param firstname1 a string
     */
    private void setFirstname(String firstname1)
    {
        this.firstname=firstname1;
    }

    /**
     * setter for lastname field
     * @param lastname1 a string
     */
    private void setLastname(String lastname1)
    {
        this.lastname=lastname1;
    }

    /**
     * generates an id for the user
     */
    private void generateId()
    {
        id = String.valueOf(masterid);
        masterid++;
    }

    public String getLastName()
    {
        return this.lastname;
    }

    public String getFirstName()
    {
        return this.firstname;
    }

    public String getPassword() {
        return this.password;
    }
    public String getId()
    {
        return this.id;
    }
    public void setMasterid(String highestid)
    {
        masterid = Integer.parseInt(highestid);
        masterid++;
    }



}
//todo add librarian boolean
