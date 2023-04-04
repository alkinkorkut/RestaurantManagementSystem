package GUI;

import static GUI.Main.dimension;
import static GUI.Main.frame;
import static GUI.Main.manager;
import static GUI.Main.managerMenu;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManagerMenu extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    ManagerMenu managerMenu = new ManagerMenu();
                    managerMenu.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public ManagerMenu(){
        this.setResizable(false);
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        this.setLocation(dimension.width/2-this.getSize().width/2, dimension.height/2-this.getSize().height/2);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#FCC973"));

        JLabel imageLabel = new JLabel(new ImageIcon("manager.png"));
        imageLabel.setBounds(200,90,500,500);

        JLabel jLabel = new JLabel("Manage Restaurant");

        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);

        jLabel.setBounds(130,30,500,50);
        jLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 35));

        mainPanel.add(jLabel);
        mainPanel.add(imageLabel);

        JButton button1 = new JButton("List Employees");
        button1.setBounds(50, 240, 200,30);
        button1.setBackground(Color.decode("#b75e15"));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Calibri",Font.BOLD,20));


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerMenu.setVisible(false);
                JFrame jFrame1 = new JFrame();
                jFrame1.setResizable(false);
                dimension = Toolkit.getDefaultToolkit().getScreenSize();
                jFrame1.setLayout(null);
                jFrame1.setSize(700,700);
                jFrame1.setLocation(dimension.width/2-jFrame1.getSize().width/2, dimension.height/2-jFrame1.getSize().height/2);
                JPanel listEmployeesPanel = new JPanel();
                listEmployeesPanel.setLayout(null);
                listEmployeesPanel.setBounds(0,0,700,700);
                JLabel imageLabel = new JLabel(new ImageIcon("manager.png"));
                imageLabel.setBounds(200,90,500,500);

                listEmployeesPanel.setBackground(Color.decode("#FCC973"));
                JLabel employeeListLabel = new JLabel("List of Employees");
                employeeListLabel.setHorizontalAlignment(JLabel.CENTER);
                employeeListLabel.setVerticalAlignment(JLabel.CENTER);
                employeeListLabel.setBounds(210,30,300,50);
                employeeListLabel.setFont(new Font("Calibri", Font.BOLD, 35));

                listEmployeesPanel.add(employeeListLabel);
                listEmployeesPanel.add(imageLabel);

                ArrayList<String> employeeList;
                employeeList = manager.listEmployees();
                String text = "";
                for(int i = 0; i < employeeList.size(); i++){
                    text = employeeList.get(i);
                    JLabel jLabel = new JLabel(text);
                    jLabel.setFont(new Font("Calibri", Font.BOLD, 20));
                    jLabel.setBounds(30,150+30*i,200,100);
                    listEmployeesPanel.add(jLabel);
                }


                JButton returnBackButton = new JButton("Go Back");
                returnBackButton.setBounds(30, 30, 100,35);
                returnBackButton.setBackground(Color.decode("#b75e15"));
                returnBackButton.setForeground(Color.WHITE);
                returnBackButton.setFont(new Font("Calibri",Font.BOLD,20));
                returnBackButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame1.setVisible(false);
                        managerMenu.setVisible(true);
                    }
                });
                jFrame1.add(returnBackButton);
                jFrame1.add(listEmployeesPanel);
                jFrame1.setVisible(true);
                jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });


        JButton button2 = new JButton("Add Employee");
        button2.setBounds(50, 280, 200,30);
        button2.setBackground(Color.decode("#b75e15"));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Calibri",Font.BOLD,20));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerMenu.setVisible(false);
                JFrame jFrame2 = new JFrame();
                jFrame2.setResizable(false);
                dimension = Toolkit.getDefaultToolkit().getScreenSize();
                jFrame2.setLayout(null);
                jFrame2.setSize(700,700);
                jFrame2.setLocation(dimension.width/2-jFrame2.getSize().width/2, dimension.height/2-jFrame2.getSize().height/2);
                JPanel addEmployeePanel = new JPanel();
                addEmployeePanel.setLayout(null);
                addEmployeePanel.setBounds(0,0,700,700);
                JLabel imageLabel = new JLabel(new ImageIcon("manager.png"));
                imageLabel.setBounds(200,90,500,500);

                addEmployeePanel.setBackground(Color.decode("#FCC973"));
                JLabel addEmployeeLabel = new JLabel("Add Employee");
                addEmployeeLabel.setHorizontalAlignment(JLabel.CENTER);
                addEmployeeLabel.setVerticalAlignment(JLabel.CENTER);
                addEmployeeLabel.setBounds(210,30,300,50);
                addEmployeeLabel.setFont(new Font("Calibri", Font.BOLD, 35));

                addEmployeePanel.add(addEmployeeLabel);
                addEmployeePanel.add(imageLabel);

                JButton addCookButton = new JButton("Add Cook");
                addCookButton.setBackground(Color.decode("#b75e15"));
                addCookButton.setForeground(Color.WHITE);
                addCookButton.setFont(new Font("Calibri",Font.BOLD,20));
                addEmployeePanel.add(addCookButton);
                addCookButton.setBounds(30, 250, 200,35);
                addCookButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame insideJFrame = new JFrame();
                        insideJFrame.setResizable(false);
                        dimension = Toolkit.getDefaultToolkit().getScreenSize();
                        insideJFrame.setLayout(null);
                        insideJFrame.setSize(700,700);
                        insideJFrame.setLocation(dimension.width/2-insideJFrame.getSize().width/2, dimension.height/2-insideJFrame.getSize().height/2);
                        insideJFrame.getContentPane().setBackground(Color.decode("#FCC973"));

                        JLabel cookNameLabel = new JLabel("Enter cook name: ");
                        cookNameLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
                        cookNameLabel.setBounds(200,150,300, 50);
                        insideJFrame.add(cookNameLabel);

                        JTextField cookNameTextField = new JTextField();
                        cookNameTextField.setFont(new Font("Calibri", Font.PLAIN, 20));
                        cookNameTextField.setBounds(200,200,300,100);
                        insideJFrame.add(cookNameTextField);

                        JLabel cookSalaryLabel = new JLabel("Enter cook salary: ");
                        cookSalaryLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
                        cookSalaryLabel.setBounds(200,350, 300, 50);
                        insideJFrame.add(cookSalaryLabel);

                        JTextField cookSalaryTextField = new JTextField();
                        cookSalaryTextField.setFont(new Font("Calibri", Font.PLAIN, 20));
                        cookSalaryTextField.setBounds(200,400,300,100);
                        insideJFrame.add(cookSalaryTextField);

                        JButton submitButton = new JButton("Submit");
                        submitButton.setBounds(200, 550, 300, 50);
                        submitButton.setBackground(Color.decode("#b75e15"));
                        submitButton.setForeground(Color.WHITE);
                        submitButton.setFont(new Font("Calibri",Font.BOLD,20));
                        insideJFrame.add(submitButton);
                        submitButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(!cookNameTextField.getText().equals("") && !cookSalaryTextField.getText().equals("")){
                                    String cookName = cookNameTextField.getText();
                                    double salary = Double.parseDouble(cookSalaryTextField.getText());
                                    manager.addCook(cookName, salary);
                                    showMessageDialog(insideJFrame, "New cook is ready.");

                                }else{
                                    showMessageDialog(insideJFrame, "Cook name and salary must be provided!");
                                }
                            }
                        });

                        JButton returnBackButton = new JButton("Go Back");
                        returnBackButton.setBounds(30, 30, 100,35);
                        returnBackButton.setBackground(Color.decode("#b75e15"));
                        returnBackButton.setForeground(Color.WHITE);
                        returnBackButton.setFont(new Font("Calibri",Font.BOLD,20));
                        returnBackButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                insideJFrame.setVisible(false);
                                jFrame2.setVisible(true);
                            }
                        });
                        returnBackButton.setBounds(30, 30, 100,35);
                        insideJFrame.add(returnBackButton);
                        insideJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        jFrame2.setVisible(false);
                        insideJFrame.setVisible(true);

                    }
                });
                jFrame2.add(addEmployeePanel);

                JButton addWaiterButton = new JButton("Add Waiter");
                addWaiterButton.setBackground(Color.decode("#b75e15"));
                addWaiterButton.setForeground(Color.WHITE);
                addWaiterButton.setFont(new Font("Calibri",Font.BOLD,20));
                addWaiterButton.setBounds(30, 325, 200,35);
                addEmployeePanel.add(addWaiterButton);
                addWaiterButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame insideJFrame = new JFrame();
                        insideJFrame.setResizable(false);
                        dimension = Toolkit.getDefaultToolkit().getScreenSize();
                        insideJFrame.setLayout(null);
                        insideJFrame.setSize(700,700);
                        insideJFrame.setLocation(dimension.width/2-insideJFrame.getSize().width/2, dimension.height/2-insideJFrame.getSize().height/2);
                        insideJFrame.getContentPane().setBackground(Color.decode("#FCC973"));

                        JLabel waiterNameLabel = new JLabel("Enter waiter name: ");
                        waiterNameLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
                        waiterNameLabel.setBounds(200,150,300, 50);
                        insideJFrame.add(waiterNameLabel);

                        JTextField waiterNameTextField = new JTextField();
                        waiterNameTextField.setFont(new Font("Calibri", Font.PLAIN, 20));
                        waiterNameTextField.setBounds(200,200,300,100);
                        insideJFrame.add(waiterNameTextField);

                        JLabel waiterSalaryLabel = new JLabel("Enter waiter salary: ");
                        waiterSalaryLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
                        waiterSalaryLabel.setBounds(200,350, 300, 50);
                        insideJFrame.add(waiterSalaryLabel);

                        JTextField waiterSalaryTextField = new JTextField();
                        waiterSalaryTextField.setFont(new Font("Calibri", Font.PLAIN, 20));
                        waiterSalaryTextField.setBounds(200,400,300,100);
                        insideJFrame.add(waiterSalaryTextField);

                        JButton submitButton = new JButton("Submit");
                        submitButton.setBounds(200, 550, 300, 50);
                        submitButton.setBackground(Color.decode("#b75e15"));
                        submitButton.setForeground(Color.WHITE);
                        submitButton.setFont(new Font("Calibri",Font.BOLD,20));
                        insideJFrame.add(submitButton);
                        submitButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(!waiterNameTextField.getText().equals("") && !waiterSalaryTextField.getText().equals("")){
                                    String waiterName = waiterNameTextField.getText();
                                    double salary = Double.parseDouble(waiterSalaryTextField.getText());
                                    manager.addWaiter(waiterName, salary);
                                    showMessageDialog(insideJFrame, "New waiter is ready.");
                                }else{
                                    showMessageDialog(insideJFrame, "Waiter name and salary must be provided!");
                                }
                            }
                        });

                        JButton returnBackButton = new JButton("Go Back");
                        returnBackButton.setBounds(30, 30, 100,35);
                        returnBackButton.setBackground(Color.decode("#b75e15"));
                        returnBackButton.setForeground(Color.WHITE);
                        returnBackButton.setFont(new Font("Calibri",Font.BOLD,20));
                        returnBackButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                insideJFrame.setVisible(false);
                                jFrame2.setVisible(true);
                            }
                        });
                        returnBackButton.setBounds(30, 30, 100,35);
                        insideJFrame.add(returnBackButton);
                        insideJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        jFrame2.setVisible(false);
                        insideJFrame.setVisible(true);

                    }
                });
                JButton returnBackButton = new JButton("Go Back");
                returnBackButton.setBounds(30, 30, 100,35);
                returnBackButton.setBackground(Color.decode("#b75e15"));
                returnBackButton.setForeground(Color.WHITE);
                returnBackButton.setFont(new Font("Calibri",Font.BOLD,20));
                returnBackButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame2.setVisible(false);
                        managerMenu.setVisible(true);
                    }
                });
                addEmployeePanel.add(returnBackButton);

                managerMenu.setVisible(false);
                jFrame2.setVisible(true);
                jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        JButton button3 = new JButton("Calculate Expenses");
        button3.setBounds(50, 320, 200,30);
        button3.setBackground(Color.decode("#b75e15"));
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Calibri",Font.BOLD,20));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "Employee Expenses: "+ manager.calculateEmployeeExpenses() + "\n"+ "Order Expenses: "+manager.calculateOrderExpenses() + "\n"+ "Total Expenses: "+manager.calculateExpenses();
                showMessageDialog(mainPanel, text, "Expenses", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton button4 = new JButton("Calculate Revenue");
        button4.setBounds(50, 360, 200,30);
        button4.setBackground(Color.decode("#b75e15"));
        button4.setForeground(Color.WHITE);
        button4.setFont(new Font("Calibri",Font.BOLD,20));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = " " + manager.calculateRevenue();
                showMessageDialog(mainPanel, text, "Total Revenue", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton button5 = new JButton("Go Back");
        button5.setBounds(30, 30, 100,35);
        button5.setBackground(Color.decode("#b75e15"));
        button5.setForeground(Color.WHITE);
        button5.setFont(new Font("Calibri",Font.BOLD,20));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerMenu.setVisible(false);
                frame.setVisible(true);
            }
        });

        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(button5);
        add(mainPanel);
    }
}
