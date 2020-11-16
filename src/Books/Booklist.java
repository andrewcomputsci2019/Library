package Books;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Booklist {
    String filepath = "C:\\Users\\sprgg\\IdeaProjects\\Libary project\\src\\MasterList";
    public Booklist()  {
        System.out.println("entered Book list constructor ");
        try {
            FilePathTest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

   private void FilePathTest() throws FileNotFoundException {
       BufferedReader var = new BufferedReader(new FileReader(filepath));
       String lines;
       try {
           while ((lines = var.readLine()) != null) {
               if (lines.startsWith("***"))
               {
                   System.out.print("header of the file excluded!\n");
               }
               else {
                   System.out.print(lines);
                   System.out.print("\n");
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

