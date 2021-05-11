/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package LoginStuff;
import User.Userdata;
import java.util.ArrayList;


public class login {
    public int index;
  public boolean Login(ArrayList<Userdata> userdata,String password,String username)
  {
      index=0;
      for (Userdata userdata1: userdata)
      {
          if (userdata1.getFirstName().equals(username))
          {
              return userdata1.getPassword().equals(password);
          }
          index++;
      }
      return false;
  }
}
