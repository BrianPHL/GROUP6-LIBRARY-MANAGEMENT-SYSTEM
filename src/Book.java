public class Book
{
    private final String title;
    private final String author;
    private final String genre;
    private final int year;

    public Book(String title, String author, String genre, int year)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public String[] getDetails()
    {
        return new String[]
        {
            this.title,
            this.author,
            this.genre,
            Integer.toString(this.year)
        };
    }
}