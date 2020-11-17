package Books;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * A parser that reads a file to check what books the library has
 * @see Booklist
 */
public class Booklist {
    String filepath = "src\\MasterList";
    public Booklist()  {
        System.out.println("entered Book list constructor ");
        try {
            FilePathTest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    /**
     * FilePathTest purpose is to read the file and output it to terminal
     * @throws FileNotFoundException if file MasterList can not be found
     * @see Booklist#FilePathTest()
     */
   private void FilePathTest() throws FileNotFoundException {
       BufferedReader var = new BufferedReader(new FileReader(filepath));
       String lines;
       String[] str;
       try {
           while ((lines = var.readLine()) != null) {
               if (lines.startsWith("***"))
               {
                   System.out.print("header of the file excluded!\n");
               }
               else {
                   System.out.print(lines);
                   System.out.print("\n");
                   str = lines.split(" , ");
                   System.out.println(str[0]);
                   System.out.println(str[1]);
               }
           }
           var.close();
       }

       catch (Exception e)
       {
           throw new FileNotFoundException("file could not be found please make sure file \"MasterList\"exist");
       }

   }

   }

/*
todo add a method to manage txt file input into an array or array list
 be able to parse two strings one for name of book and one for isbn
*/

