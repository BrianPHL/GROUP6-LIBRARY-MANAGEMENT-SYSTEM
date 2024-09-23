import javax.swing.*;
import java.util.Stack;

public class History
{
    private final GUI gui;
    private final Library library;

    Stack<Action> historyStack = new Stack<>();

    public History(GUI gui, Library library)
    {
        this.gui = gui;
        this.library = library;
    }
    public void undo()
    {

        if (!historyStack.isEmpty())
        {
            Action lastAction = historyStack.pop();

            if (lastAction.getAction().equals("add"))
            {
                int index = Integer.parseInt(lastAction.getBook().getDetails()[0]);
                library.libraryList.remove(index);
                JOptionPane.showMessageDialog(null, "Successfully undo recent action: Add \"" + lastAction.getBook().getDetails()[1] + "\" book.");
                gui.refreshTable();
            }
            else if (lastAction.getAction().equals("remove"))
            {
                Book book = lastAction.getBook();
                library.libraryList.add(book);
                JOptionPane.showMessageDialog(null, "Successfully undo recent action: Remove \"" + book.getDetails()[1] + "\" book.");
                gui.refreshTable();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(
                    null,
                    "No actions to undo at this time."
            );
        }

    }
}
  