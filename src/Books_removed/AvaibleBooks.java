/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package Books_removed;

import javax.swing.*;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class AvaibleBooks {
    private HashMap<String, String> hashMap = new HashMap<>();

    public AvaibleBooks()
    {
        System.out.println("empty for now");
    }

    public void AddbookToList(String name , String isbn)
    {
        hashMap.put(name, isbn);
    }

    @Override
    public String toString() {
        return "AvaibleBooks{" +
                "hashMap=" + hashMap +
                '}';
    }
     public void removeBookFromMap(String bookname)
   {
       hashMap.remove(bookname);
       if(hashMap.containsKey(bookname))
       {
           System.out.println("either two instances of the book name "+bookname+" exist or the key has failed to be removed");
       }

   }
   public String getValueFromKey(String bookname) {
       for (Map.Entry<String,String> entry: hashMap.entrySet())
       {
           if (entry.getKey().equals(bookname))
           {
               return entry.getValue();
           }
       }
       return null;
   }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }
    public String[] moveBookFromAvailToNot(String bookname)
    {
        if(hashMap.containsKey(bookname))
        {
            String[] str = new String[2];
            str[0] = bookname;
            str[1]= hashMap.get(bookname);
            hashMap.remove(bookname);
            return str;
        }
        return null;
    }
    public String[] moveBookFromAvailToNotIsbn(String  isbn)
    {
        for (Map.Entry<String,String> entry : hashMap.entrySet())
        {
            if (entry.getValue().equals(isbn))
            {
                String[] str = new String[2];
                str[0] = entry.getKey();
                str[1] = entry.getValue();
                hashMap.remove(entry.getKey());
                return str; // idea of this is that the array is pass to main where it will get transported to checkout class
            }
        }
        return null; //if code doesnt execute this will return null, could also put a throw
    }
}
//todo add hashmap function for searching for book name and isbn

