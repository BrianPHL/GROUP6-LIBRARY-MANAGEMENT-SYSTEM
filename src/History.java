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

}
  