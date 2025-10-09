package hms;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class HospitalManagementSystem extends JFrame{
    //Jpanels
    private JPanel mainPnl;
    private JPanel welcomePnl;
    private JPanel employeeIdPnl;
    private JPanel passwordPnl;
    private JPanel loginDetailsPnl;
    private JPanel buttonsPnl;
    //labels
    private JLabel welcomeLbl;
    private JLabel employeeIdLbl;
    private JLabel passwordLbl;
    //Text fields
    private JTextField employeeIdTxtFld;
    private JTextField passwordTxtFld;
    //Buttons
    private JButton loginBtn;
    private JButton clearBtn;
    private JButton exitBtn;
    
    
    //Main method for testing
    public static void main(String[] args) {
        new HospitalManagementSystem();
    }
    public HospitalManagementSystem(){
        setTitle("Hospital Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeElements();
        buttons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //Initialize and add all elements to main Panel
    private void initializeElements(){
        //Jpanels
        mainPnl = new JPanel(new BorderLayout());
        mainPnl.setBorder(new EmptyBorder(20, 20, 20, 20));
        welcomePnl = new JPanel(new FlowLayout());
        
        employeeIdPnl  = new JPanel(new FlowLayout());
        passwordPnl  = new JPanel(new FlowLayout());
        loginDetailsPnl  = new JPanel(new GridLayout(2,1));
        buttonsPnl  = new JPanel(new FlowLayout());
        //labels
        welcomeLbl = new JLabel("Welcome to HMS");
        welcomeLbl.setFont(welcomeLbl.getFont().deriveFont(java.awt.Font.BOLD, 26f) );
        employeeIdLbl = new JLabel("Employee ID:");
        passwordLbl = new JLabel("Password:   ");
        //Text fields
        employeeIdTxtFld = new JTextField(50);
        passwordTxtFld = new JTextField(50);
        //Buttons
        loginBtn = new JButton("Login");
        clearBtn = new JButton("Clear");
        exitBtn = new JButton("Exit");
        
        //Add elements to pannels
        welcomePnl.add(welcomeLbl);
        employeeIdPnl.add(employeeIdLbl);
        employeeIdPnl.add(employeeIdTxtFld);
        passwordPnl.add(passwordLbl);
        passwordPnl.add(passwordTxtFld);
        loginDetailsPnl.add(employeeIdPnl,BorderLayout.NORTH);
        loginDetailsPnl.add(passwordPnl,BorderLayout.CENTER);
        buttonsPnl.add(loginBtn);
        buttonsPnl.add(clearBtn);
        buttonsPnl.add(exitBtn);
        mainPnl.add(welcomePnl, BorderLayout.NORTH);
        mainPnl.add(loginDetailsPnl, BorderLayout.CENTER);
        mainPnl.add(buttonsPnl, BorderLayout.SOUTH);
        add(mainPnl);
    }
    private void buttons(){
        //when login button is clicked a necessary object must be called containing the home page
        loginBtn.addActionListener((e) -> {
            login();
        });
        clearBtn.addActionListener((e) -> {
            employeeIdTxtFld.setText("");
            passwordTxtFld.setText("");
        });
        exitBtn.addActionListener((e) -> {
            System.exit(0);
        });
    }
    private void login(){
        
    }
    
}
