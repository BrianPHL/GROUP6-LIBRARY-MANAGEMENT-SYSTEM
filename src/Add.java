import javax.swing.JOptionPane;

public class Add {

    public static void main(String[] args) {
        Book book = new Book(0, "", "", 0, "", "");
        Library library = new Library(10);


        while (true) {
            String[] options = {"Add a book", "Add book w/ specific index"};
            int choice = JOptionPane.showOptionDialog(null, "                          How do you want to add your book?", "Add a book",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                book.setBookTitle(JOptionPane.showInputDialog("Book Details \nEnter Book Title "));
                book.setBookAuthorFirstname(JOptionPane.showInputDialog("Author Details \nEnter Author's First Name:  "));
                book.setBookAuthorLastname(JOptionPane.showInputDialog("Author Details \nEnter Author's Last Name:  "));
                book.setBookGenre(JOptionPane.showInputDialog("Book Details \nEnter Book Genre "));
                book.setPublicationYear(Short.parseShort(JOptionPane.showInputDialog("Book Details \nEnter Publication Year ")));

                library.add(book);

                JOptionPane.showMessageDialog(null, "Book added successfully.");

            } else if (choice == 1) {
                String input = JOptionPane.showInputDialog("Enter index: ");
                int index = Integer.parseInt(input);
                book.setBookId(Short.parseShort(JOptionPane.showInputDialog("Book Details \nEnter Book ID: ")));
                book.setBookTitle(JOptionPane.showInputDialog("Book Details \nEnter Book Title "));
                book.setBookAuthorFirstname(JOptionPane.showInputDialog("Author Details \nEnter Author's First Name:  "));
                book.setBookAuthorLastname(JOptionPane.showInputDialog("Author Details \nEnter Author's Last Name:  "));
                book.setBookGenre(JOptionPane.showInputDialog("Book Details \nEnter Book Genre "));
                book.setPublicationYear(Short.parseShort(JOptionPane.showInputDialog("Book Details \nEnter Publication Year ")));

                try {
                    library.insert(index, book);
                    JOptionPane.showMessageDialog(null, "Book inserted successfully at index " + index + ".");
                } catch (IndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Invalid index! Book insertion failed.");
                }
            }
            else {
                break;
            }
        }
    }
}


class Book {
    private String bookTitle, bookGenre;
    private int publicationYear, bookId;
    protected String bookAuthorLastname, bookAuthorFirstname;


    public Book(int bookId, String bookTitle, String bookGenre, int publicationYear, String bookAuthorLastname, String bookAuthorFirstname) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.publicationYear = publicationYear;
        this.bookGenre = bookGenre;
        this.bookAuthorLastname = bookAuthorLastname;
        this.bookAuthorFirstname = bookAuthorFirstname;
    }



    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }


    public String getBookAuthorLastname() {
        return bookAuthorLastname;
    }

    public void setBookAuthorLastname(String bookAuthorLastname) {
        this.bookAuthorLastname = bookAuthorLastname;
    }

    public String getBookAuthorFirstname() {
        return bookAuthorLastname;
    }

    public void setBookAuthorFirstname(String bookAuthorFirstname) {
        this.bookAuthorFirstname = bookAuthorFirstname;
    }
    public void setInfo(int bookId, String bookTitle, String bookGenre, int publicationYear, String bookAuthorLastname, String bookAuthorFirstname) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.publicationYear = publicationYear;
        this.bookAuthorLastname = bookAuthorLastname;
        this.bookAuthorFirstname = bookAuthorFirstname;
    }

}

class Library {
    private Book[] books;
    private int size;

    public Library(int initialCapacity) {
        books = new Book[initialCapacity];
        size = 0;
    }

    // Add a book to the end of the array
    public void add(Book book) {
        if (size == books.length) {
            resize();
        }
        books[size] = book;
        size++;
    }

    // Insert a book at a specified index
    public void insert(int index, Book book) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == books.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            books[i] = books[i - 1];
        }
        books[index] = book;
        size++;
    }

    // Resize the array when it's full
    private void resize() {
        Book[] newBooks = new Book[books.length * 2];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        books = newBooks;
    }
}