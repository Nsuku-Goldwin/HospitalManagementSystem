package hms.gui.admin;
import hms.logic.admin.AdminLogic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;

public class AdministratorGUI extends JFrame{
    //Main tab to contain all the pages/tabs that are requred for the administrator page and functionality
    private JTabbedPane mainTab;
    //initLogsPage Elements declaration
    private JPanel logsMainPnl;
    private JPanel logsBtnsPnl;
    private JScrollPane logsTableScroll;
    private JTable logsTable;
    private JComboBox logsDateCombo;
    private JComboBox logsMonthCombo;
    private JComboBox logsYearCombo;
    private JButton logsFilterBtn;
    private JButton logsRefreshBtn;
    //Table Column names
    private final Object[] columnNames = {"Empoyee ID","Name", "Surname", "Date", "Time", "Description", "Status"};
    //Constructor Method
    public AdministratorGUI() {
        setTitle("Administrator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainTab = new JTabbedPane();
        mainTab.setBorder(new EmptyBorder(20, 20, 20, 20));
        initLogsPage();
        addEmployeePage();
        //Add Tabs Here
        mainTab.add("Logs",logsMainPnl);
        mainTab.add("Add",addEmployeeMainPnl);
        add(mainTab);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //Logs opanel to add to the mainTab
    private void initLogsPage(){
        
        logsMainPnl = new JPanel(new BorderLayout());
        logsBtnsPnl = new JPanel();
        logsTable = new JTable(new AdminLogic().viewAllLogs(), columnNames);
        logsTableScroll = new JScrollPane(logsTable);
        logsDateCombo = new JComboBox<String>(new String[]{"Date","1", "2", "3", "4", "5","6","7", "8", "9", "10", "11","12", "13", "14", "15", "16","17","18", "19", "20", "21", "22","23", "24", "25", "26", "27","28","29", "30", "31"});
        logsDateCombo.setPreferredSize(new Dimension(100,20));
        logsMonthCombo = new JComboBox<String>(new String[]{"Month","January", "February", "March", "April","May", "June", "July", "August","September", "October", "November", "December"});
        logsMonthCombo.setPreferredSize(new Dimension(100,25));
        logsYearCombo = new JComboBox<String>(new String[]{"Year","2025"});
        logsYearCombo.setPreferredSize(new Dimension(100,25));
        logsFilterBtn = new JButton("Filter");
        logsRefreshBtn = new JButton("Refresh");
        
        logsBtnsPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
        logsBtnsPnl.add(logsDateCombo);
        logsBtnsPnl.add(logsMonthCombo);
        logsBtnsPnl.add(logsYearCombo);
        logsBtnsPnl.add(logsFilterBtn);
        logsBtnsPnl.add(logsRefreshBtn);
        JLabel temp = new JLabel("");
        temp.setPreferredSize(new Dimension(400, 20));
        logsBtnsPnl.add(temp);
        logsMainPnl.add(logsTableScroll, BorderLayout.CENTER);
        logsMainPnl.add(logsBtnsPnl, BorderLayout.SOUTH);
        //Add Button functionality
        logsFilterBtn.addActionListener((e) -> {
        });
        logsRefreshBtn.addActionListener((e)->{
            logsTable = new JTable(new AdminLogic().viewAllLogs(), this.columnNames);
        });
    }
    //Add Employee panel to add to the mainTab
    JPanel addEmployeeMainPnl;
    private void addEmployeePage(){
        addEmployeeMainPnl = new JPanel();
        addEmployeeMainPnl.add(new JLabel("Hello"));
    }
    //TO-Do add code for addEmployeePage Logic
}
