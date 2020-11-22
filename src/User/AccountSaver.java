package User;
import User.Userdata;
import java.util.ArrayList;

public class AccountSaver {
    private ArrayList<Userdata> list;

    public AccountSaver()
    {

    }
    public AccountSaver(ArrayList<Userdata> listpass)
    {
        this.list = listpass;
    }
   /* private ArrayList<Userdata> SavelistofUsers()
    {
        not complete
    }
*/
}
//todo add file writer and file reader, to save and collect user data
