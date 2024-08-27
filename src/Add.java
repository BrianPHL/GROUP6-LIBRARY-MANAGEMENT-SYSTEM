import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Add {

    private ArrayList<Book> books;

    public void addBook() {
        String title = JOptionPane.showInputDialog("Enter Book title: ");
        String author = JOptionPane.showInputDialog("Enter Book author: ");
        String genre = JOptionPane.showInputDialog("Enter Book genre: ");
        String year = JOptionPane.showInputDialog("Enter Book year: ");
        Book book = new Book(title, author, genre, year);
        books.add(book);
        JOptionPane.showMessageDialog(null, "Book added successfully!");
    }

    public void insertBookAtSpecifiedIndex() {
        int index = Integer.parseInt(JOptionPane.showInputDialog("Enter the index to insert the book:"));
        if (index < 0 || index > books.size()) {
            JOptionPane.showMessageDialog(null, "Invalid index!");
            return;
        }
        String title = JOptionPane.showInputDialog("Enter book title:");
        String author = JOptionPane.showInputDialog("Enter book author:");
        String publisher = JOptionPane.showInputDialog("Enter book genre:");
        String year = JOptionPane.showInputDialog("Enter book year:");
        Book book = new Book(title, author, publisher, year);
        books.add(index, book);
        JOptionPane.showMessageDialog(null, "Book inserted successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books in the library!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Book book : books) {
                sb.append(book.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public void run() {
        while (true) {
            String[] options = {"Add a book", "Add book w/ specific index","Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Library Management System", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    addBook();
                    break;
                case 1:
                    insertBookAtSpecifiedIndex();
                    break;
                case 2:
                    System.exit(0);
                    break;

            }
        }
    }


    public static void main (String[]args){
        Add library = new Add();
        library.run();
    }
}

class Book {
    private String title;
    private String author;
    private String genre;
    private String year;

    public Book(String title, String author, String genre, String year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nYear: " + year;
    }
}
