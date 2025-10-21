package hms.gui.admin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AdministratorGUI extends JFrame{
    private JTabbedPane mainTab;
    private JPanel a,b,c;
    public AdministratorGUI() {
        setTitle("Administrator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        mainTab = new JTabbedPane();
        add(mainTab);
        setVisible(true);
    }
    private void initLogsPage(){}
}
