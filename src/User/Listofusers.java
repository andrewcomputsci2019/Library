package User;

import java.util.ArrayList;

public class Listofusers {
public ArrayList<Userdata> listofusers;
        public Listofusers()
        {
            listofusers = new ArrayList<>();
        }

        public void addUserToList(Userdata userdata)
        {
            listofusers.add(userdata);
        }

    /**
     * a method desgin to return the arraylist
     * @return listofusers-arrayform
     */
    public ArrayList<Userdata> getListofUsersArray() {
        return listofusers;
    }

    /**
     * a method design to return the arraylist as a string
     * @return String value of listofusers
     */
    public String getListofUsersString() {
        return String.valueOf(listofusers);
    }
    /**
     * method that is design to get the user name of a specific account
     * @param position an integer that represent position in the arraylist
     */
    public void printFristName(int position)
    {
        System.out.println(
        listofusers.get(position).getFirstName());

    }
    public void printLastName(int position)
    {
        System.out.println(
                listofusers.get(position).getLastName()
        );
    }
    public void printPassword(int position)
    {
        System.out.println(
        listofusers.get(position).getPassword()
        );
    }



}
//todo add a remove from list
