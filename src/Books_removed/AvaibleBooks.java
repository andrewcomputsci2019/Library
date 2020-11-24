/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package Books_removed;
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
}
//todo add hashmap function for searching for book name and isbn

