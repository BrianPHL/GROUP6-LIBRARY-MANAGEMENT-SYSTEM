import java.util.ArrayList;

public class Library
{

    ArrayList<Book> libraryList = new ArrayList<>();

    public void onInsertAnywhere(Book book)
    {
        libraryList.add(book);
    }

    public void onInsertAtSpecificIndex(int index, Book book)
    {

        libraryList.add(index, book);
    }

    public void onRemoveABookByIndex(int index)
    {
        libraryList.remove(index);
    }
    public Book getBookByIndex(int index)
    {
        return libraryList.get(index);
    }

}