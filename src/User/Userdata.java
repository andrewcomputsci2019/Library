package User;
import java.util.Scanner;

public class Userdata {
    static int masterid=0;
    private int id;
    private String password;
    private String firstname;
    private String lastname;
    public Userdata()
    {
        this.id = 0;
    }
    @Override
    public String toString()
    {
        return String.format(id+" "+password+" "+firstname+" "+lastname);
    }
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

    }
    private void setPassword(String password)
    {
        this.password= password;
    }
    private void setFirstname(String firstname1)
    {
        this.firstname=firstname1;
    }
    private void setLastname(String lastname1)
    {
        this.lastname=lastname1;
    }
    private void generateId()
    {
        id = masterid;
        masterid++;
    }

}
//todo add librarian boolean
