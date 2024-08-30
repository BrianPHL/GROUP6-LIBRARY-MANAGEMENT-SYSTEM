import javax.swing.*;
import java.awt.print.Book;

public class Remove {

        static class Library {
            private final Book[] books;
            private int size;

            public Library(int capacity) {
                books = new Book[capacity];
                size = 0;
            }



            public void removeBook(int index) {
                if (index >= 0 && index < size) {
                    for (int i = index; i < size - 1; i++) {
                        books[i] = books[i + 1];
                    }
                    size--;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid!");
                }
            }
        }



        public static void main(String[] args) {
            Library library = new Library(10); // specify the capacity of the library

            while (true) {
                String[] options = {"Remove Book","Exit"};
                int choice = JOptionPane.showOptionDialog(null, "Library Management System", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                switch (choice) {
                    case 0:
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Enter a book to remove:"));
                        library.removeBook(index);
                        break;
                    case 1:
                        System.exit(0);
                        break;
                }
            }
        }
    }
