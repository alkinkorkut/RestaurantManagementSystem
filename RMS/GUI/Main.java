package GUI;

import orderManagement.Order;
import orderManagement.OrderHelper;
import orderManagement.Product;
import restaurantManagement.Manager;
import restaurantManagement.Waiter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Manager manager = new Manager();
	public static OrderHelper orderHelper = new OrderHelper();
	static ManagerMenu managerMenu = new ManagerMenu();
	static CustomerMenu customerMenu = new CustomerMenu();
	static Dimension dimension;
	static JFrame frame = new JFrame("RMS");


	public static void main(String[] args) {
		frame.setSize(700,700);
		frame.setLayout(new GridLayout(3,1));
		frame.setResizable(false);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dimension.width/2-frame.getSize().width/2, dimension.height/2-frame.getSize().height/2);

		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel midPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		topPanel.setBackground(Color.decode("#ffefd6"));
		midPanel.setBackground(Color.decode("#ffefd6"));
		buttonPanel.setBackground(Color.WHITE);

		buttonPanel.setLayout(new GridLayout(1,2));

		ImageIcon imageIcon = new ImageIcon("restaurant.png");
		JLabel picLabel = new JLabel(imageIcon);
		JLabel welcomeLabel = new JLabel("Welcome" );
		welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));

		midPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		midPanel.add(picLabel);
		midPanel.add(welcomeLabel);


		JButton managerButton = new JButton("Manager");
		managerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				managerMenu.setVisible(true);
				frame.setVisible(false);
			}
		});
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		managerButton.setBackground(Color.decode("#a4747a"));
		managerButton.setOpaque(true);
		managerButton.setBorderPainted(true);
		managerButton.setBorder(raisedbevel);
		managerButton.setFont(new Font("Calibri", Font.CENTER_BASELINE, 35));
		JButton customerButton = new JButton("Customer");
		customerButton.setBackground(Color.decode("#a4747a"));
		customerButton.setOpaque(true);
		customerButton.setBorderPainted(true);
		customerButton.setBorder(raisedbevel);
		customerButton.setFont(new Font("Calibri", Font.CENTER_BASELINE, 35));
		customerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				//This method returns the time in millis
				double timeMilli = date.getTime();
				customerMenu.setVisible(true);
				double timeMilli2 = date.getTime();
				System.out.println(timeMilli2-timeMilli);
				frame.setVisible(false);
			}
		});


		buttonPanel.add(managerButton);
		buttonPanel.add(customerButton);

		JLabel topLabel = new JLabel("RESTAURANT MANAGEMENT SYSTEM");
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		topLabel.setVerticalAlignment(JLabel.CENTER);
		topPanel.add(topLabel, BorderLayout.CENTER);
		topLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));

		frame.add(topPanel);
		frame.add(midPanel);
		frame.add(buttonPanel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		/*System.out.println("Welcome to OZU Restaurant!\n");
		while(true){
			System.out.println("-------------------------Main Menu-------------------------");
			System.out.println("1: Create Order");
			System.out.println("2: Manage Restaurant");
			System.out.println("3: Exit Program");
			System.out.println("-----------------------------------------------------------");
			System.out.print(">> ");
			String option = scanner.nextLine();
			if(option.equals("1")){
			    createOrder();
			}
			else if(option.equals("2")){
				manageRestaurant();
			}
			else if(option.equals("3")){
			    System.out.println("Bye");
			    break;
			}
			else{
			    System.out.println("Try Again...1");
				}
			}
		}
		
		private static void createOrder() {
			Waiter w = manager.assignWaiter();
			System.out.println("Hi, I am " + w.getName() + ".");
			System.out.println("I will be our waiter today.");
			System.out.println("What would you like to get today?");
			
			Order order = new Order();
			while(true){
				System.out.println("-----------------------Create Order-----------------------");
				System.out.println("1: List Order");
				System.out.println("2: Add Product");
				System.out.println("3: Complete Order");
				System.out.println("4: Go back to Main Menu");
				System.out.println("-----------------------------------------------------------");
				System.out.print(">> ");
				String option = scanner.nextLine();
				if(option.equals("1")){
				    order.listOrder();
				}
				else if(option.equals("2")){
					ArrayList<Product> products = manager.getProducts();
					while(true){
						System.out.println("-----------------------Add Product-----------------------");
						for (int i = 0; i < products.size(); i++) {
							System.out.println((i + 1) + ": " + products.get(i).getName());
						}
						System.out.println("-----------------------------------------------------------");
						System.out.print(">> ");
						option = scanner.nextLine();
						int productNumber = Integer.parseInt(option);
						if (productNumber <= products.size() && productNumber > 0) {
						    order.addProduct(products.get(productNumber - 1));
						    order.listOrder();
						    break;
						}
						else  {
							System.out.println("Try Again...2");
						}
					}
				}
				else if(option.equals("3")){
					orderHelper.createOrder(order);
					System.out.println("Your order is complete!");
					System.out.println("Returning to Main Menu");
				    break;
				}
				else if(option.equals("4")){
					System.out.println("Returning to Main Menu");
				    break;
				}
				else{
				    System.out.println("Try Again...3");
				}
			}
		}
		
		private static void manageRestaurant() {
			
			while(true){
				System.out.println("---------------------Manage Restaurant---------------------");
				System.out.println("1: List Employees");
				System.out.println("2: Add Employee");
				System.out.println("3: Calculate Expenses");
				System.out.println("4: Calculate Revenue");
				System.out.println("5: Go back to Main Menu");
				System.out.println("-----------------------------------------------------------");
				System.out.print(">> ");
				String option = scanner.nextLine();
				if(option.equals("1")){
				    manager.listEmployees();
				}
				else if(option.equals("2")){
					addEmployee();
				}
				else if(option.equals("3")){
					System.out.println("Total Expense: " + manager.calculateExpenses());
				}
				else if(option.equals("4")){
					System.out.println("Total Revenue: " + manager.calculateRevenue());
				}
				else if(option.equals("5")){
					System.out.println("Returning to Main Menu");
				    break;
				}
				else{
				    System.out.println("Try Again...4");
				}
			}
		}

		private static void addEmployee() {
			
			while(true){
				System.out.println("---------------------Add Employee---------------------");
				System.out.println("1: Add Cook");
				System.out.println("2: Add Waiter");
				System.out.println("3: Go back to Manage Restaurant Menu");
				System.out.println("-----------------------------------------------------------");
				System.out.print(">> ");
				String option = scanner.nextLine();
				if(option.equals("1")){
					System.out.println("Name of the Cook:");
					System.out.print(">> ");
					String name = scanner.nextLine();
					System.out.println("Salary of the Cook:");
					System.out.print(">> ");
					String salary = scanner.nextLine();
					manager.addCook(name, Double.parseDouble(salary));
				}
				else if(option.equals("2")){
					System.out.println("Name of the Waiter:");
					System.out.print(">> ");
					String name = scanner.nextLine();
					System.out.println("Salary of the Waiter:");
					System.out.print(">> ");
					double salary = scanner.nextDouble();
					manager.addWaiter(name, salary);
					System.out.println("Returning to Main Menu");
				}
				else if(option.equals("3")){
					System.out.println("Returning to Manage Restaurant Menu");
					break;
				}
				else{
				    System.out.println("Try Again...5");
				}
			}*/
		}

	}

