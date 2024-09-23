public class Action
{
    String action;
    Book book;

    public Action(String action, Book book)
    {
        this.action = action;
        this.book = book;
    }

    public String getAction()
    {
        return action;
    }

    public Book getBook()
    {
        return book;
    }
}