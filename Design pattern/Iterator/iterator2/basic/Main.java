package Iterator.iterator2.basic;

import java.util.ArrayList;
import java.util.List;

class Document {
    private String title;
    private String author;

    public Document(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

class BookCollection {
    private List<Document> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    public void addBook(Document book) {
        books.add(book);
    }
}

class MagazineCollection {
    private List<Document> magazines;

    public MagazineCollection() {
        magazines = new ArrayList<>();
    }

    public void addMagazine(Document magazine) {
        magazines.add(magazine);
    }
}

//I want to print at the screen all the titles and authors of all the magazines and books efficiently