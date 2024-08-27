import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Display {
    private ArrayList<Book> books;

    public Display(ArrayList<Book> books) {
        this.books = books;
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

}


