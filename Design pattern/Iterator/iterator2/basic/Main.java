package Iterator.iterator2.basic;

// import java.util.ArrayList;
// import java.util.List;

// class Document {
//     private String title;
//     private String author;

//     public Document(String title, String author) {
//         this.title = title;
//         this.author = author;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public String getAuthor() {
//         return author;
//     }

//     @Override
//     public String toString() {
//         return "Title: " + title + ", Author: " + author;
//     }
// }

// class BookCollection {
//     private List<Document> books;

//     public BookCollection() {
//         books = new ArrayList<>();
//     }

//     public void addBook(Document book) {
//         books.add(book);
//     }
// }

// class MagazineCollection {
//     private List<Document> magazines;

//     public MagazineCollection() {
//         magazines = new ArrayList<>();
//     }

//     public void addMagazine(Document magazine) {
//         magazines.add(magazine);
//     }
// }

//I want to print at the screen all the titles and authors of all the magazines and books depending by hiding the implementation of the collections
//I want to add new documents on magazines and books, depending on the title of it, and the print them at the screen with title and authors, by hiding the implementation of the collections

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

interface DocumentCollection {
    void addDocument(Document document);
    Document getDocument(int index);
    int size();
}

class BookCollection implements DocumentCollection {
    private List<Document> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    @Override
    public void addDocument(Document book) {
        books.add(book);
    }

    @Override
    public Document getDocument(int index) {
        return books.get(index);
    }

    @Override
    public int size() {
        return books.size();
    }

    public List<Document> getBooks() {
        return books;
    }
}

class MagazineCollection implements DocumentCollection {
    private List<Document> magazines;

    public MagazineCollection() {
        magazines = new ArrayList<>();
    }

    @Override
    public void addDocument(Document magazine) {
        magazines.add(magazine);
    }

    @Override
    public Document getDocument(int index) {
        return magazines.get(index);
    }

    @Override
    public int size() {
        return magazines.size();
    }

    public List<Document> getMagazines() {
        return magazines;
    }
}

class CollectionDisplayManager {
    private DocumentCollection collection;

    public CollectionDisplayManager(DocumentCollection collection) {
        this.collection = collection;
    }

    public void displayCollection() {
        System.out.println("Displaying Collection:");
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.getDocument(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Document book1 = new Document("The Great Gatsby", "F. Scott Fitzgerald");
        Document book2 = new Document("1984", "George Orwell");

        Document magazine1 = new Document("National Geographic", "John Doe");
        Document magazine2 = new Document("Time", "Jane Smith");

        BookCollection bookCollection = new BookCollection();
        bookCollection.addDocument(book1);
        bookCollection.addDocument(book2);

        MagazineCollection magazineCollection = new MagazineCollection();
        magazineCollection.addDocument(magazine1);
        magazineCollection.addDocument(magazine2);

        CollectionDisplayManager bookDisplayManager = new CollectionDisplayManager(bookCollection);
        CollectionDisplayManager magazineDisplayManager = new CollectionDisplayManager(magazineCollection);

        bookDisplayManager.displayCollection();
        magazineDisplayManager.displayCollection();
    }
}

//I want to refactor the class CollectionDisplayManager, so I can access to the information of the documents in a flexible way.