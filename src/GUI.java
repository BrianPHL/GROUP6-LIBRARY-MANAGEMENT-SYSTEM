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

    public static void main(String[] args)
    {
        GUI gui = new GUI();
        gui.initialize();
    }

}