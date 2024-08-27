import javax.swing.*;
import java.util.ArrayList;

public class Search {
    private ArrayList<Book> books;

    public Search() {
        this.books = new ArrayList<>();
    }

    public void searchBook() {
        String title = JOptionPane.showInputDialog("Enter book title to search:");
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                JOptionPane.showMessageDialog(null, "Book found!\n" + book);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books in the library!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Book book : books) {
                sb.append(book).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public static void main(String[] args) {
        Search search = new Search();
        search.searchBook();
        search.displayBooks();
    }
}

class Books {
    private String title;

    public Books(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}