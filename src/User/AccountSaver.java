package User;
import User.Userdata;
import java.nio.file.Path;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AccountSaver {
    private ArrayList<Userdata> list;

    public AccountSaver() throws IOException // this will be for startup this will
    {
        SavelistofUsers();
    }
    public AccountSaver(ArrayList<Userdata> listpass) // this is used for saving the data
    {
        this.list = listpass;

    }
    private void SavelistofUsers() throws IOException {

        Path currentpath = Paths.get("");
        String string = currentpath.toAbsolutePath().toString();
        System.out.println(string);
        BufferedWriter bw = new BufferedWriter(new FileWriter("resources/UserList"));
        bw.write("***This file will write the user data in the following id , password , fname , pname ***");// don't do this in an actual application hackers would love you a lot actually
        for(Userdata users: this.list)
        {
            bw.write(users.getId()+" , "+users.getPassword()+ " , "+users.getFirstName()+" , "+users.getPassword()+"\n");
        }
    }

}
//todo add file writer and file reader, to save and collect user data
