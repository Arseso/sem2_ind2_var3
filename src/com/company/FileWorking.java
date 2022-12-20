package com.company;

import com.company.models.Book;

import java.io.*;
import java.util.ArrayList;

public class FileWorking {

    private static String FILE_NAME="src/data_book.txt";
    private static String LOG_NAME="src/out.log";

    public static ArrayList<Book> getArrayFromFile() {
        BufferedReader reader = initReader();
        if(reader==null) return null;
        return getArray(reader);
    }

    public static void redirectLogToFile() {
        try{
            PrintStream out = new PrintStream(new FileOutputStream(LOG_NAME));
            System.setOut(out);
        } catch (FileNotFoundException ex){}
    }




    private static ArrayList<Book> getArray(BufferedReader reader) {
        String s;
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            while ((s = reader.readLine()) != null) {
                books.add(new Book(
                        Integer.parseInt(s),
                        reader.readLine(),
                        reader.readLine(),
                        Float.parseFloat(reader.readLine()),
                        reader.readLine(),
                        Long.parseLong(reader.readLine()),
                        reader.readLine(),
                        Integer.parseInt(reader.readLine()),
                        Integer.parseInt(reader.readLine()),
                        Integer.parseInt(reader.readLine())

                ));
            }
        } catch (IOException e){ return null;}
        return books;
    }

    private static BufferedReader initReader() {
        try {
            return new BufferedReader(new FileReader(FILE_NAME));
        } catch (FileNotFoundException ex){
            System.out.println("file no found");
            return null;
        }
    }
}
