package com.company;

import com.company.models.Book;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args){

        ArrayList<Book> books = FileWorking.getArrayFromFile();
        if(books == null){
            System.out.println("Файл не найден");
            return;
        }
        NumberAndPartOfBooks(books);
        printBooks(BooksWith3Authors(books));



        String author = "J.K. Rowling"; //input Author name here

        AverageRateByAuthor(books,author);
        FileWorking.redirectLogToFile();
        printBooks(Top3RateBooksByAuthor(books,author));

    }

    private static List<Book> Top3RateBooksByAuthor(ArrayList<Book> books, String author) {
        System.out.println("[Top3RateBooksByAuthor]");

        List<Book> BooksByAuthor = new ArrayList<>();
        for(Book b : books) if(b.getAuthor().contains(author)) BooksByAuthor.add(b);

        BooksByAuthor.sort(Comparator.comparing(Book::getRate));
        Collections.reverse(BooksByAuthor);
        BooksByAuthor = BooksByAuthor.subList(0,3);
        return BooksByAuthor;
    }

    private static void AverageRateByAuthor(ArrayList<Book> books, String author) {
        System.out.println("[AverageRateByAuthor]");
        double sumRate = 0;
        int numberBooks = 0;
        for(Book b : books) if(b.getAuthor().contains(author)) {sumRate+=b.getRate(); numberBooks++;};
        System.out.println("Books: " + numberBooks);
        System.out.println("Average Rate: " + sumRate/numberBooks);
    }

    private static List<Book> BooksWith3Authors(ArrayList<Book> books) {
        System.out.println("[BooksWith3Authors]");
        List<Book> booksWith3Authors = new ArrayList<>();
        for (Book b : books)
            if(b.parseAuthors().length == 3){
                booksWith3Authors.add(b);
            }
        Collections.sort(booksWith3Authors, Comparator.comparing(Book::getNumberPages));
        return booksWith3Authors;
    }

    private static void NumberAndPartOfBooks(ArrayList<Book> books) {
        int booksWithNotOneAuthor = 0;
        for (Book b : books){
            if(b.parseAuthors().length > 1){
                booksWithNotOneAuthor++;
            }
        }
        System.out.println("[NumberAndPartOfBooks]");
        System.out.println("booksWithNotOneAuthor: " + booksWithNotOneAuthor);
        System.out.println("books: " + books.size());
        System.out.println("part of booksWithNotOneAuthor: "+ booksWithNotOneAuthor +"/"+books.size());
    }



    private static List<Book> Top10Popular(ArrayList<Book> cources) {

//        System.out.println("[Top10Popular]");
//        cost_cources.sort(Comparator.comparing(Book::getListeners));
//        Collections.reverse(cost_cources);
//        cost_cources = cost_cources.subList(0,9);
//        cost_cources.sort(Comparator.comparing(Book::getCourseCost));
        return null;
    }


    private static ArrayList<Book> TimeSpanSmallOrEquals3Month(ArrayList<Book> cources) {

        System.out.println("[TimeSpanSmallOrEquals3Month]");

        ArrayList<Book> afterChecking = new ArrayList<>();
//        for (Book c: cources) if(c.getTimeSpan()<=3) afterChecking.add(c);
        return afterChecking;
    }

    private static void printBooks(List<Book> books){
        if(books == null){
            System.out.println("No books suitable for the condition");
            return;
        }
        for(Book c : books) {
            System.out.println("Index: " + c.getIndex());
            System.out.println("Title: " + c.getTitle());
            System.out.println("Author(s): " + c.getAuthor());
            System.out.println("Rate: " + c.getRate());
            System.out.println("ID: " + c.getID());
            System.out.println("ID ISBN: " + c.getID_ISBN());
            System.out.println("Language: " + c.getLanguageCode());
            System.out.println("Pages: " + c.getNumberPages());
            System.out.println("Marks: " + c.getNumberMarks());
            System.out.println("------------------");
        }
    }
}
