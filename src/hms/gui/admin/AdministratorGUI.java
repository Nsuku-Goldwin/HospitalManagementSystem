package hms.gui.admin;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AdministratorGUI extends JFrame{
    private JTabbedPane mainTab;
    //initLogsPage Elements declaration
    private JPanel logsMainPnl;
    private JPanel logsBtnsPnl;
    private JTextArea logsTxtArea;
    private JTextField logsEmployeeIdTxtFld;
    private JComboBox logsDateCombo;
    private JComboBox logsMonthCombo;
    private JComboBox logsYearCombo;
    private JButton logsFilterBtn;
    private JButton logsRefreshBtn;
    public AdministratorGUI() {
        setTitle("Administrator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainTab = new JTabbedPane();
        mainTab.setBorder(new EmptyBorder(20, 20, 20, 20));
        initLogsPage();
        mainTab.add("Logs",logsMainPnl);
        add(mainTab);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void initLogsPage(){
        logsMainPnl = new JPanel(new BorderLayout());
        logsBtnsPnl = new JPanel();
        logsTxtArea = new JTextArea(50,100);
        logsTxtArea.setEditable(false);
        logsEmployeeIdTxtFld = new JTextField(20);
        logsDateCombo = new JComboBox<String>(new String[]{"1", "2", "3", "4", "5","6","7", "8", "9", "10", "11","12", "13", "14", "15", "16","17","18", "19", "20", "21", "22","23", "24", "25", "26", "27","28","29", "30", "31"});
        logsDateCombo.setPreferredSize(new Dimension(100,25));
        logsMonthCombo = new JComboBox<String>(new String[]{"January", "February", "March", "April","May", "June", "July", "August","September", "October", "November", "December"});
        logsMonthCombo.setPreferredSize(new Dimension(100,25));
        logsYearCombo = new JComboBox<String>(new String[]{"2025"});
        logsYearCombo.setPreferredSize(new Dimension(100,25));
        logsFilterBtn = new JButton("Filter");
        logsRefreshBtn = new JButton("Refresh");
        
        logsBtnsPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
        logsBtnsPnl.add(logsEmployeeIdTxtFld);
        logsBtnsPnl.add(logsDateCombo);
        logsBtnsPnl.add(logsMonthCombo);
        logsBtnsPnl.add(logsYearCombo);
        logsBtnsPnl.add(logsFilterBtn);
        logsBtnsPnl.add(logsRefreshBtn);
        logsMainPnl.add(logsTxtArea, BorderLayout.CENTER);
        logsMainPnl.add(logsBtnsPnl, BorderLayout.SOUTH);
        
    }
}
