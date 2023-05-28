package mypackage;

import java.util.ArrayList;
import java.util.HashMap;

class Book {
    public static ArrayList<HashMap> bookList = new ArrayList<HashMap>();
    private String name;
    private String author;
    private String abstractText;
    private String ISBN;

    private String ageGroup;



    private boolean reserved;
    private String reservedBy;
    private static int resCount;

    public Book() {
        this.reserved = false;
        this.reservedBy = "";
        this.resCount = 0;

    }


    public void Register(String ISBN , String name, String author, String abstractText, String ageGroup ,String status){
        this.name = name;
        this.author = author;
        this.abstractText = abstractText;
        this.ISBN = ISBN;
        this.ageGroup = ageGroup;
        HashMap<String, String> book = new HashMap<String, String>();
        book.put("ISBN", ISBN);
        book.put("Name", name);
        book.put("Author", author);
        book.put("AgeGroup", ageGroup);
        book.put("Status", status);
        book.put("Abstract", abstractText);
        bookList.add(book);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public static int getResCount() {
        return resCount;
    }

    public String getAgeGroup() {
        return ageGroup;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public static void incrementResCount() {
        resCount++;
    }

    public static void decrementResCount() {
        resCount--;
    }

    public static void list() {
        System.out.println("ISBN | Name | Author | AgeGroup");
        System.out.println("-------------------------------------");
        for (HashMap<String, String> book : bookList) {
            System.out.println(book.get("ISBN") + " | " + book.get("Name") + " | " + book.get("Author") + " | " + book.get("AgeGroup"));
        }
    }
}

