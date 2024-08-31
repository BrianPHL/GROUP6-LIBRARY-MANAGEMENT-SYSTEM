import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame
{

    private JPanel LibraryPanel;
    private JTable LibraryTable;
    private JButton AddBooksBtn;
    private JButton RemoveBooksBtn;
    private JButton GetLibrarySizeBtn;
    private JButton FindBooksBtn;
    private JButton CheckIfEmptyBtn;
    private DefaultTableModel MainTableModel;

    Library library = new Library();

    public void initialize()
    {
        initTable();
        initActions();
        initInterface();
    }

    private void initTable()
    {
        final String[] LibraryTableColumns = {
                "Title", "Author", "Genre", "Publication Year"
        };

        MainTableModel = (DefaultTableModel) LibraryTable.getModel();

        for (String LibraryTableColumn : LibraryTableColumns) {
            MainTableModel.addColumn(LibraryTableColumn);
        }

        refreshTable();
    }

    private void initActions()
    {
        AddBooksBtn.addActionListener((e) -> onAddBooks());
        RemoveBooksBtn.addActionListener((e) -> onRemoveBooks());
        FindBooksBtn.addActionListener((e) -> onFindBooks());
        GetLibrarySizeBtn.addActionListener((e) -> onGetLibrarySize());
        CheckIfEmptyBtn.addActionListener((e) -> onEmptyListCheck());

    }

    private void refreshTable()
    {

        MainTableModel.setRowCount(0);

        for (int i = 0; i < library.libraryList.size(); i++)
        {
            MainTableModel.addRow(library.libraryList.get(i).getDetails());
        }
    }

    private void initInterface()
    {
        setContentPane(LibraryPanel);
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(576, 384);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onAddBooks()
    {
        String choice = JOptionPane.showInputDialog(null, "Are you inputting with index (type 1) or not (type 2)?");

        if (choice == null) return;

        if (choice.equals("1"))
        {
            try
            {
                int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Input new book index (You can only insert up to " + library.libraryList.size() + " indices): " ));
                String title = JOptionPane.showInputDialog(null, "Input new book title:");
                String author = JOptionPane.showInputDialog(null, "Input new book author:");
                String genre = JOptionPane.showInputDialog(null, "Input new book genre:");
                int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Input new book publication year:"));

                library.onInsertAtSpecificIndex(index, new Book(title, author, genre, year));
                refreshTable();

            }
            catch (Exception error)
            {
                JOptionPane.showMessageDialog(null, error);
            }

        }
        else if (choice.equals("2"))
        {
            try
            {
                String title = JOptionPane.showInputDialog(null, "Input new book title:");
                String author = JOptionPane.showInputDialog(null, "Input new book author:");
                String genre = JOptionPane.showInputDialog(null, "Input new book genre:");
                int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Input new book publication year:"));

                library.onInsertAnywhere(new Book(title, author, genre, year));
                refreshTable();
            }
            catch (Exception error)
            {
                JOptionPane.showMessageDialog(null, error);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You input a key that is not in the choices! Please try again.");
        }

    }

    private void onRemoveBooks()
{
    try
    {
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Input index of the book you want to remove (You can only remove one book from " + library.libraryList.size() + " indices): " ));
        String bookTitle = library.libraryList.get(index).getDetails()[0];

        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the book, \"" + bookTitle + "\"?", "Confirm", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION)
        {
            library.onRemoveABookByIndex(index);
            refreshTable();
            JOptionPane.showMessageDialog(null, "\"" + bookTitle + "\" book was successfully removed!");
        }

    }
    catch (Exception error)
    {
        JOptionPane.showMessageDialog(null, error);
    }
}

    private void onFindBooks()
    {
        try
        {
            int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Input index of the book you want to find (You can only find one book from " + library.libraryList.size() + " indices): " ));

            Book book = library.getBookByIndex(index);

            String title = book.getDetails()[0];
            String author = book.getDetails()[1];
            String genre = book.getDetails()[2];
            String year = book.getDetails()[3];

            JOptionPane.showMessageDialog(null, "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nYear: " + year);
        }
        catch (Exception error)
        {
            JOptionPane.showMessageDialog(null, error);
        }

    }
    private void onGetLibrarySize()
    {
        JOptionPane.showMessageDialog(null, "The library currently has " + library.libraryList.size() + " books. Feel free to add more!");
    }

    private void onEmptyListCheck()
    {
        if (library.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "The library is currently empty! Feel free to add books.");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "The library currently has " + library.libraryList.size() + " books and is not empty. Feel free to add more!");
        }
    }

    public static void main(String[] args)
    {
        GUI gui = new GUI();
        gui.initialize();
    }


}
