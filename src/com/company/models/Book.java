package com.company.models;

import java.util.Arrays;

public class Book {
    private int Index = 0;
    private String Title = "";
    private String Author = "";
    private float Rate = 0;
    private String ID = "";
    private long ID_ISBN = 0;
    private String LanguageCode = "";
    private int NumberPages = 0;
    private int NumberMarks = 0;
    private int NumberRec = 0;


    public String[] parseAuthors(){
        return Author.split("/");
    }


    public void setIndex(int index) {
        Index = index;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setID_ISBN(int ID_ISBN) {
        this.ID_ISBN = ID_ISBN;
    }

    public void setLanguageCode(String languageCode) {
        LanguageCode = languageCode;
    }

    public void setNumberPages(int numberPages) {
        NumberPages = numberPages;
    }

    public void setNumberMarks(int numberMarks) {
        NumberMarks = numberMarks;
    }

    public int getIndex() {
        return Index;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public float getRate() {
        return Rate;
    }

    public String getID() {
        return ID;
    }

    public long getID_ISBN() {
        return ID_ISBN;
    }

    public String getLanguageCode() {
        return LanguageCode;
    }

    public int getNumberPages() {
        return NumberPages;
    }

    public int getNumberMarks() {
        return NumberMarks;
    }

    public Book(int index, String title, String author, float rate, String ID, long ID_ISBN, String languageCode, int numberPages, int numberMarks, int numberRec) {
        Index = index;
        Title = title;
        Author = author;
        Rate = rate;
        this.ID = ID;
        this.ID_ISBN = ID_ISBN;
        LanguageCode = languageCode;
        NumberPages = numberPages;
        NumberMarks = numberMarks;
        NumberRec = numberRec;
    }
}