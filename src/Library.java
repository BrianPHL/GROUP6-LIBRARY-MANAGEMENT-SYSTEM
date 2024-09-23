import java.util.ArrayList;

public class Library
{

    private static Library instance;

    ArrayList<Book> libraryList = new ArrayList<>();

    public void onInsert(int index, Book book)
    {
        libraryList.add(index, book);
    }

    public void onRemove(int index)
    {
        libraryList.remove(index);
    }
    public Book getBookByIndex(int index)
    {
        return libraryList.get(index);
    }
    public boolean isEmpty() {
        return libraryList.isEmpty();
    }

    public void bubbleSortByTitle()
    {
        int libraryListSize = libraryList.size();
        boolean isSwapped;

        for (int i = 0; i < libraryListSize-1; i++)
        {
            isSwapped = false;

            for (int j = 0; j < (libraryListSize - i - 1); j++)
            {

                if (libraryList.get(j).getDetails()[1].compareTo(libraryList.get(j+1).getDetails()[1]) > 0)
                {
                    Book temp = libraryList.get(j);
                    libraryList.set(j, libraryList.get(j + 1));
                    libraryList.set(j + 1, temp);
                    isSwapped = true;
                }

            }

            if (!isSwapped) break;

        }

    }

}