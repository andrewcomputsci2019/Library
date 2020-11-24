/*
 * Copyright (c) 2020 Feel free to edit this project in any way but you must credit me in your works a simple comment or side note will work just fine have fun.
 */

package Books;

import Books_removed.AvaibleBooks;

import java.io.*;

/**
 * A parser that reads a file to check what books the library has
 * @see Booklist
 */
public class Booklist {
    AvaibleBooks avaibleBooks = new AvaibleBooks();
    String filepath = "MasterList";
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
        //  InputStream is = getClass().getResourceAsStream("/MasterList.txt"); if file was in jar
      // InputStream is = getClass().getClassLoader().getResourceAsStream("MasterList.txt"); if file was in jar
           BufferedReader var = new BufferedReader(new FileReader("resources/MasterList.txt"));
           int bookcount=0;
           String lines;
           String[] str;
           try {
               while ((lines = var.readLine()) != null) {
                   if (lines.startsWith("***")) {
                       System.out.print("header of the file excluded!\n");
                   } else {
                       System.out.print(lines);
                       System.out.print("\n");
                       str = lines.split(" , ");
                       System.out.println(str[0]);
                       System.out.println(str[1]);
                       avaibleBooks.AddbookToList(str[0], str[1]);
                       bookcount++;
                   }
               }
               System.out.println("number of books in list is: "+bookcount);
               var.close();
           } catch (Exception e) {
               throw new IOError(e.fillInStackTrace());
           }
       }

    /**
     *
     * @return a hash map containing a set of books
     */
    public AvaibleBooks Returnhashmapobject()
   {
       return avaibleBooks;
   }




   }

/*
todo add a method to manage txt file input into an array or array list
 be able to parse two strings one for name of book and one for isbn
*/

