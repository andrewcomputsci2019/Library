import Books.Booklist;
import Books_removed.*;
import User.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print("hello");
        System.out.println(" world");
        boolean exit = false;
        Userdata userdata = new Userdata();
        AvaibleBooks avaibleBooks = new AvaibleBooks();
        Checked_outlist checked_outlist = new Checked_outlist();
        Booklist booklist = new Booklist();
        Listofusers listofusers = new Listofusers();
        while (!exit)
        {
            System.out.println("would you like to view our books");
            userdata.CreateAccount();
            listofusers.addUserToList(userdata);
            System.out.print(listofusers.listofusers);
            exit=true;
        }
    }
}
