package User;

import java.util.ArrayList;

public class Listofusers extends Userdata{
public ArrayList<Userdata> listofusers;
        public Listofusers()
        {
            listofusers = new ArrayList<>();
        }

        public void addUserToList(Userdata userdata)
        {
            listofusers.add(userdata);
        }



}
//todo add a remove from list
