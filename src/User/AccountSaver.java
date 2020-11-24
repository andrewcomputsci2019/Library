/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package User;
import User.Userdata;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AccountSaver {
    private ArrayList<Userdata> list;

    public AccountSaver() throws IOException // this will be for startup this will run
    {
            accountReader();
    }
    public AccountSaver(ArrayList<Userdata> listpass) throws IOException // this is used for saving the data
    {
        this.list = listpass;
        SavelistofUsers();

    }

    /**
     * writes out the arraylist into a file for for feature starts
     * @throws IOException if an error occurs when reading the file
     */
    private void SavelistofUsers() throws IOException {
        Path currentpath = Paths.get("");
        String string = currentpath.toAbsolutePath().toString();
        System.out.println(string);
        BufferedWriter bw = new BufferedWriter(new FileWriter("resources/UserList"));
        bw.write("***This file will write the user data in the following id , password , fname , pname ***\n");// don't do this in an actual application hackers would love you a lot actually
        for(Userdata users: this.list)
        {
            bw.write(users.getId()+" , "+users.getPassword()+ " , "+users.getFirstName()+" , "+users.getPassword()+"\n"); //plain text storage is super dangerous
        }
        bw.close();
    }

    /**
     * Reads the userlist file and sets up an array list to be ready for a return back to the main
     * @throws IOException if an error occurs in the file io operation
     */
    private void accountReader() throws IOException {
        Userdata userdata = new Userdata();
        BufferedReader reader = new BufferedReader(new FileReader("resources/UserList"));
        int count = 0;
        String lines;
        while((lines=reader.readLine())!=null)
        {

            if(lines.startsWith("***"))
            {
                System.out.println("Header of file has been skip");
            }
            else
            System.out.println(lines);
            String[] str = lines.split(" , ");
            for (String s : str) {
                System.out.println(s);
            }
            userdata.CreateAccount(str[0],str[1],str[2],str[3]);
            this.list.add(userdata);

        }

    }

}
//todo add file writer and file reader, to save and collect user data
