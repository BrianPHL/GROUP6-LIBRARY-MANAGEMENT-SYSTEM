import java.util.Scanner;

public class Add {

    public static void main(String[] args) {
        Library library = new Library(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a book");
            System.out.println("2. Insert a book at a specified index");
            //System.out.println("3. Display all books"); TEST FOR DISPLAY

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int identification = scanner.nextInt();
                    System.out.print("Enter book Title: ");
                    String title = scanner.next();
                    System.out.print("Enter book Author: ");
                    String author = scanner.next();
                    System.out.print("Enter book Genre: ");
                    String genre = scanner.next();
                    System.out.print("Enter book publication year: ");
                    int publicationYear = scanner.nextInt();
                    library.add(new Book(identification, title, author, genre, publicationYear));

                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    identification = scanner.nextInt();
                    System.out.print("Enter book title: ");
                    title = scanner.next();
                    System.out.print("Enter book author: ");
                    author = scanner.next();
                    System.out.print("Enter book Genre: ");
                    genre = scanner.next();
                    System.out.print("Enter book publication year: ");
                    publicationYear = scanner.nextInt();

                    try {
                        library.insert(index, new Book(identification, title, author, genre, publicationYear));
                        System.out.println("Book inserted successfully at index " + index + ".");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index! Book insertion failed.");
                    }
                    break;
//TEST FOR DISPLAY ONLY
                /*case 3:
                    if (library.isEmpty()) {
                        System.out.println("The library is empty.");
                    } else {
                        System.out.println("Books in the library:");
                        for (int i = 0; i < library.size(); i++) {
                            Book b = library.get(i);
                            System.out.println(i + ": " + b.getIdentification() + " " + b.getTitle() +" " + b.getGenre() + " " + "by " + b.getAuthor() + "Published on: " + b.getPublicationYear());
                        }
                    }
                    break;
*/
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }


    static class Book {
        private String title, author, genre;
        private int publicationYear, identification;

        public Book(int identification, String title, String author, String genre, int publicationYear) {
            this.title = title;
            this.author = author;
            this.publicationYear = publicationYear;
            this.identification = identification;
            this.genre = genre;
        }

        public int getIdentification() {
            return identification;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getGenre() {
            return genre;
        }

        public int getPublicationYear() {
            return publicationYear;
        }

    }


    public static class Library {
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
// TEST FOR DISPLAY
/*
        // Get the number of books in the library
        public int size() {
            return size;
        }

        // Check if the library is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Get a book at a specified index
        public Book get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return books[index];
        }
    }

 */
    }
}


