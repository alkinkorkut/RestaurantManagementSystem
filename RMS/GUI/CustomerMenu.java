package GUI;

import static GUI.Main.customerMenu;

import static GUI.Main.dimension;
import static GUI.Main.frame;
import static GUI.Main.manager;
import static GUI.Main.orderHelper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import orderManagement.Order;
import orderManagement.Product;


public class CustomerMenu extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    CustomerMenu customerMenu = new CustomerMenu();
                    customerMenu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CustomerMenu() {

        this.setResizable(false);
        dimension = Toolkit.getDefaultToolkit().getScreenSize();

        Order order = new Order();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#FFEFD6"));

        JLabel imageLabel = new JLabel(new ImageIcon("waiter.png"));
        imageLabel.setBounds(300, 190, 400, 400);

        JLabel jLabel = new JLabel("Create Order");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);

        jLabel.setBounds(240, 20, 220, 50);
        jLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 35));

        mainPanel.add(jLabel);
        mainPanel.add(imageLabel);


        JButton button1 = new JButton("List Order");
        button1.setBounds(50, 240, 200, 40);
        button1.setBackground(Color.decode("#0E5E6F"));
        button1.setForeground(Color.white);
        button1.setFont(new Font("Calibri", Font.BOLD, 20));
        button1.setVerticalAlignment(SwingConstants.BOTTOM);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerMenu.setVisible(false);
                JFrame jFrame1 = new JFrame();
                jFrame1.setResizable(false);
                dimension = Toolkit.getDefaultToolkit().getScreenSize();
                jFrame1.setLayout(null);
                jFrame1.setSize(700, 700);
                jFrame1.setLocation(dimension.width / 2 - jFrame1.getSize().width / 2, dimension.height / 2 - jFrame1.getSize().height / 2);
                JPanel listOrdersPanel = new JPanel();
                listOrdersPanel.setLayout(null);
                listOrdersPanel.setBounds(0, 0, 700, 700);
                JLabel imageLabel = new JLabel(new ImageIcon("waiter.png"));
                imageLabel.setBounds(250, 150, 400, 400);

                listOrdersPanel.setBackground(Color.decode("#FFEFD6"));
                JLabel orderListLabel = new JLabel("List of Order");
                orderListLabel.setHorizontalAlignment(JLabel.CENTER);
                orderListLabel.setVerticalAlignment(JLabel.CENTER);
                orderListLabel.setBounds(240, 30, 220, 50);
                orderListLabel.setFont(new Font("Calibri", Font.BOLD, 35));

                listOrdersPanel.add(orderListLabel);
                listOrdersPanel.add(imageLabel);

                ArrayList<Product> orderList;
                orderList = order.listOrder();
                String text = "";
                if (orderList.size() == 0) {
                    text = "You have not ordered anything yet!";
                    JLabel jLabel = new JLabel("<html>" + text + "</html>");
                    jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
                    jLabel.setBounds(30, 194, 250, 75);
                    jLabel.setBorder(BorderFactory.createLineBorder(Color.decode("#0E5E6F"), 1));
                    jLabel.setVerticalAlignment(SwingConstants.CENTER);
                    listOrdersPanel.add(jLabel);
                } else {
                    for (int i = 0; i < orderList.size(); i++) {
                        text = orderList.get(i).getName() + " " + orderList.get(i).getSellingPrice();
                        JLabel jLabel = new JLabel("<html>" + text + "</html>");
                        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
                        jLabel.setBounds(30, 150 + 44 * i, 200, 42);
                        jLabel.setBorder(BorderFactory.createLineBorder(Color.decode("#0E5E6F"), 1));
                        jLabel.setVerticalAlignment(SwingConstants.CENTER);
                        listOrdersPanel.add(jLabel);
                    }
                }
                JButton backButton = new JButton("Go Back");
                backButton.setBounds(30, 30, 100, 35);
                backButton.setBackground(Color.decode("#0E5E6F"));
                backButton.setForeground(Color.white);
                backButton.setFont(new Font("Calibri", Font.BOLD, 20));
                backButton.setVerticalAlignment(SwingConstants.BOTTOM);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame1.setVisible(false);
                        customerMenu.setVisible(true);

                    }
                });
                jFrame1.add(backButton);
                jFrame1.add(listOrdersPanel);
                jFrame1.setVisible(true);
                jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
         JButton button2 = new JButton("Add Product");
        button2.setBounds(50, 290, 200, 40);
        button2.setBackground(Color.decode("#0E5E6F"));
        button2.setForeground(Color.white);
        button2.setFont(new Font("Calibri", Font.BOLD, 20));
        button2.setVerticalAlignment(SwingConstants.BOTTOM);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerMenu.setVisible(false);
                JFrame jFrame2 = new JFrame();
                jFrame2.setResizable(false);
                dimension = Toolkit.getDefaultToolkit().getScreenSize();
                jFrame2.setLayout(null);
                jFrame2.setSize(700, 700);
                jFrame2.setLocation(dimension.width / 2 - jFrame2.getSize().width / 2, dimension.height / 2 - jFrame2.getSize().height / 2);
                JPanel addProductPanel = new JPanel();
                addProductPanel.setLayout(null);
                addProductPanel.setBounds(0, 0, 700, 700);
                JLabel imageLabel = new JLabel(new ImageIcon("waiter.png"));
                imageLabel.setBounds(300, 150, 400, 400);
                addProductPanel.setBackground(Color.decode("#FFEFD6"));
                JLabel addProductLabel = new JLabel("Menu");
                addProductLabel.setHorizontalAlignment(JLabel.CENTER);
                addProductLabel.setVerticalAlignment(JLabel.CENTER);
                addProductLabel.setBounds(240, 30, 220, 50);
                addProductLabel.setFont(new Font("Calibri", Font.BOLD, 35));

                addProductPanel.add(addProductLabel);
                addProductPanel.add(imageLabel);

                ArrayList<Product> products;
                products = manager.getProducts();
                for (int i = 0; i < products.size(); i++) {
                    JButton button = new JButton();
                    button.setFont(new Font("Calibri", Font.BOLD, 18));
                    button.setBackground(Color.decode("#a4747a"));
                    button.setOpaque(true);
                    button.setBorderPainted(true);
                    button.setForeground(Color.white);
                    button.setUI(new StyledButtonUI());
                    button.setText(products.get(i).toString() + " " +products.get(i).getSellingPrice());
                    int finalI = i;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            order.addProduct(products.get(finalI));

                        }
                    });
                    button.setBounds(30, 170 + 45 * i, 270, 40);
                    addProductPanel.add(button);
                }

                JButton backButton = new JButton("Go Back");
                backButton.setBounds(30, 30, 100, 35);
                backButton.setBackground(Color.decode("#0E5E6F"));
                backButton.setForeground(Color.white);
                backButton.setFont(new Font("Calibri", Font.BOLD, 20));
                backButton.setVerticalAlignment(SwingConstants.BOTTOM);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame2.setVisible(false);
                        customerMenu.setVisible(true);
                    }
                });
                jFrame2.add(backButton);
                jFrame2.add(addProductPanel);
                jFrame2.setVisible(true);
                jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        JButton button3 = new JButton("Complete Order");
        button3.setBounds(50, 340, 200, 40);
        button3.setBackground(Color.decode("#0E5E6F"));
        button3.setForeground(Color.white);
        button3.setFont(new Font("Calibri", Font.BOLD, 20));
        button3.setVerticalAlignment(SwingConstants.BOTTOM);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Product> orders=  order.getOrderedProducts();
                if (orders.size() == 0) {
                    JOptionPane.showMessageDialog(mainPanel, "You haven't ordered anything!");

                } else {
                    orderHelper.createOrder(order);
                    JOptionPane.showMessageDialog(mainPanel, "Your order is completed!");
                    //orders.clear();


                }

            }
        });

        JButton button4 = new JButton("Go Back");
        button4.setBounds(30, 30, 100, 35);
        button4.setBackground(Color.decode("#0E5E6F"));
        button4.setForeground(Color.white);
        button4.setFont(new Font("Calibri", Font.BOLD, 20));
        button4.setVerticalAlignment(SwingConstants.BOTTOM);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerMenu.setVisible(false);
                frame.setVisible(true);
            }
        });
        JTextArea hiLabel = new JTextArea(
                "Hi, I am Alex." + "\n" +
                        "I will be our waiter today." + "\n" +
                        "What would you like to get today?");
        hiLabel.setBounds(250, 80, 400, 100);
        hiLabel.setBackground(Color.decode("#FFEFD6"));
        hiLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        hiLabel.setBorder(new RoundBorder(20));

        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(hiLabel);
        add(mainPanel);
    }

    public static class RoundBorder implements Border {
        private int radius;
        public RoundBorder(int radius) {
            this.radius = radius;
        }
        public int getRadius() {
            return radius;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, getRadius(), getRadius()));
            g2d.dispose();
        }
        @Override
        public Insets getBorderInsets(Component c) {
            int value = getRadius() / 2;
            return new Insets(value, value, value, value);
        }
        @Override
        public boolean isBorderOpaque() {
            return false;
        }

    }
    static class StyledButtonUI extends BasicButtonUI {

        @Override
        public void installUI (JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));
        }

        @Override
        public void paint (Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }

        private void paintBackground (Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }
    }
}
