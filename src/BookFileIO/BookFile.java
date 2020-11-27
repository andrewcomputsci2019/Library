/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */
package BookFileIO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BookFile {
    private HashMap<String,String> stringStringHashMap;
    public BookFile(HashMap<String, String> hashMap)//shutdown
    {
        this.stringStringHashMap=hashMap;
    }
    public BookFile()//startup
    {

    }
    private void saveBookFile() throws IOException//shutdown file writer
    {
            // we should want to print into the file in a string , string pattern with a new line at the end
            // this would standardize the file reading solution
            // write key than value
        File file = new File("resources/MasterList");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("*** Master List of All books in library and print isbn ***\n");
        bufferedWriter.write("*** book name , isbn***\n");
        for (Map.Entry<String,String>e :stringStringHashMap.entrySet())
        {
            bufferedWriter.write(e.getKey()+" , "+e.getValue()+"\n");

        }
    }
    private void readBookFile() throws IOException {
        File file = new File("resources/MasterList");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int count=0;
        String lines;
        while((lines=reader.readLine())!=null)
        {
            if (lines.startsWith("***"))
            {
                System.out.println("header of file skip");

            }
            else // honestly a lot easier than the arraylist file io and I probably should have used inheritance here but what the hell
            {
                count++;
                String[] strings= lines.split(" , ");
                for (String string: strings)
                {
                    System.out.println(string);
                }
                this.stringStringHashMap.put(strings[0],strings[1]);
                System.out.println(stringStringHashMap);
            }


        }
    }

}
