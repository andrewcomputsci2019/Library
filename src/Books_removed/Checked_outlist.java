/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package Books_removed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class controls what books are check out and to who
 */
public class Checked_outlist {
    public HashMap<String, String> stringHashMap; // could use a 3d array instead for isbn,bookname,user id but i think a hashmap would be better
    public Checked_outlist()
    {
        System.out.println("empty for now");
    }

    /**
     * this metod manges a hash map that checks what books have been checked out or not
     * @param userid the users id
     * @param book the name of the book
     */
    public void addBookToCheckout(String userid,String book)
    {
            this.stringHashMap.put(book,userid);
    }

    /**
     * this is used to see what books an individual may have check out to him or her
     * @param id used to search through the hashmap to find the books associated with that value
     * @return an array list of book names
     */
    public ArrayList<String> SearchListid(String id) // chose an array list due to expandable memory so i don't have to iterate twice
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

    /**
     *
     * @param book string name of the book
     * @return the id of the users who checked out the book
     */
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
