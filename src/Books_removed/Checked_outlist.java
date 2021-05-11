/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package Books_removed;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void closeCheckedOutList() throws IOException { //shutdown
        File file = new File("resources/CheckedOutlist.txt");
        if(file.createNewFile())
        {
            System.out.println("file created named:"+file+"\n file path is "+file.getAbsolutePath());
        }
        else
        {
            System.out.println("File already exist at: "+file.getAbsolutePath());
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("*** this file contains information about checked out books ***");
        bufferedWriter.write("*** string format book , user id ***");
        int sum =  this.stringHashMap.size();
        int count = 0 ;
        for (Map.Entry<String, String> e : this.stringHashMap.entrySet())
        {
            bufferedWriter.write(e.getKey()+" , "+e.getValue()+"\n");
            count++;
        }
        System.out.println("Total size of hashmap is: "+sum+"\nnumber of lines written to file is: "+count+"\ndifference between size an lines written is " + (sum - count));

    }
    public void Startup() throws IOException {
        // would be file reader class
        File file = new File("resources/CheckedOutlist.txt");
        if(file.exists())
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String lines;
            int count = 0;
            while ((lines = bufferedReader.readLine())!=null)
            {
                if(lines.startsWith("***")||lines.length()==0)
                {
                    System.out.println("File header skipped or line isnt longer than 0 characters");
                    break;
                }
                else
                {
                    count++;
                    String[] str = lines.split(" , ");
                    for (String string : str)
                    {
                        System.out.println(string);
                    }
                    addBookToCheckout(str[0],str[1]);
                    System.out.println("User: "+str[1]+"\n"+"book: "+str[0]+"\nhave been added to the hashmap");

                }

            }
            System.out.println("total number of entries added to hash map is "+count);
        }
        else
        {
            System.out.println("File does not exist");
        }

    }

    @Override
    public String toString() {
        return "Checked_outlist{" +
                "stringHashMap=" + stringHashMap +
                '}';
    }//going to change it to line by line print by iteration
}
//todo add this functionally to program
