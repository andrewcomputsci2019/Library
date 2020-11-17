package User;
import java.util.Scanner;

/**
 * Userdata creates an object that holds an id,password,firstname, and a last name
 *
 */
public class Userdata {
    static int masterid=0;
    private int id;
    private String password;
    private String firstname;
    private String lastname;

    /**
     * Userdata constructor is only here to initialize the id to 0
     */
    public Userdata()
    {
        this.id = 0;
    }

    /**
     * toString override used to format a strign return
     * @return String
     */
    @Override
    public String toString()
    {
        return String.format(id+" "+password+" "+firstname+" "+lastname);
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
        id = masterid;
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




}
//todo add librarian boolean
