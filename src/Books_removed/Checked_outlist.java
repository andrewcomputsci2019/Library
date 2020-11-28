/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package Books_removed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Checked_outlist {
    public HashMap<String, String> stringHashMap; // could use a 3d array instead for isbn,bookname,user id but i think a hashmap would be better
    public Checked_outlist()
    {
        System.out.println("empty for now");
    }
    public void addBookToCheckout(String userid,String book)
    {
            this.stringHashMap.put(book,userid);
    }
    public ArrayList<String> SearchListid(String id)
    {
        ArrayList<String> arrayList= new ArrayList<>();
        if(stringHashMap.containsValue(id))
        {
            for(Map.Entry<String,String>entry:stringHashMap.entrySet())
            {
                if (entry.getValue().equals(id))
                {
                    arrayList.add(entry.getKey());
                }
            }
        }
        else
        {
            return null;
        }
        return arrayList;
    }
    public String SearchListBook(String book)
    {
            if(this.stringHashMap.containsKey(book))
            {
                return stringHashMap.get(book);
            }
            else return null;
    }



}
//todo add this functionally to program
