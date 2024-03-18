import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoPizza extends JFrame {
    final int FRAME_WIDTH = 400;//This creates the frame that the GUI is in
    final int FRAME_HEIGHT = 400;

    private pizza pizzaToppings;//This creates a way for me to have access the pizza Toppings class

    public DemoPizza() {
        setTitle("BigY Store");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//This sets the frame and exits it when it is closed

        // Creating UI components
        JPanel titleBar = new JPanel();
        titleBar.setPreferredSize(new Dimension(FRAME_WIDTH, 30));
        titleBar.setBackground(new Color(158, 143, 82));//this is setting the general UI

        JLabel heading = new JLabel("What toppings would you like to add?");
        heading.setFont(new Font("Arial", Font.BOLD, 16));//creates the title

        JLabel title = new JLabel("Each topping costs $3:");
        JLabel item1 = new JLabel("Buffalo Chicken");
        JLabel item2 = new JLabel("Artichoke Hearts");
        JLabel item3 = new JLabel("Pineapple and Ham");
        JLabel item4 = new JLabel("Sun-Dried Tomatoes");
        JLabel item5 = new JLabel("BBQ Pulled Pork");
        JLabel item6 = new JLabel("Mushrooms and Gorgonzola");
        JLabel item7 = new JLabel("Prosciutto and Fig");
        JLabel item8 = new JLabel("Sliced Avocado");
        JLabel item9 = new JLabel("Shrimp and Pesto");
        JLabel item10 = new JLabel("Caramelized Onions and Goat Cheese");//This displays all of the possible food options

        JLabel userin1 = new JLabel("enter topping");
        JLabel address1 = new JLabel("enter address");
        title.setFont(new Font("Arial", Font.BOLD, 14));//This asks the user to input the toppings they want and the can enter where the food is going to be sent to

        JTextField userin = new JTextField();
        JTextField address = new JTextField();//creates the text fields for the users topping and address
        JButton buttonAdd = new JButton("Add Topping");//This creats a buttion for the user to add stuff to their cart

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = userin.getText();
                String useraddress = address.getText(); // This gets the text of the toppings and the address
                Topping selectedTopping = getPredefinedTopping(userInput);

                if (selectedTopping != null) {
                    if (pizzaToppings == null) {
                        pizzaToppings = new pizza(selectedTopping);
                    } else {
                        pizzaToppings.addTopping(selectedTopping);
                    }
                } else {
                    JOptionPane.showMessageDialog(DemoPizza.this, "Invalid topping!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
                }
                if (useraddress.isEmpty()) {
                    JOptionPane.showMessageDialog(DemoPizza.this, "Invalid address!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });
        JButton buttonConfirmPurchase = new JButton("Confirm Purchase");
        buttonConfirmPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String useraddress = address.getText();
                DeliveryPizza deliveryPizza = new DeliveryPizza(pizzaToppings.getArrayList().get(0), 0, address.getText());

                if (pizzaToppings != null) {
                    StringBuilder message = new StringBuilder("You have selected:\n\n");
                    for (Topping order : pizzaToppings.getArrayList()) {
                        message.append(order).append("\n");
                    }
                    message.append("\nTotal Price: $").append(deliveryPizza.getAllPrice());
                    message.append("\nThe food is being sent to "+ useraddress);

                    JOptionPane.showMessageDialog(DemoPizza.this, message.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Setting up layout and adding components to content pane
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 1));
        contentPane.add(titleBar);
        contentPane.add(heading);
        contentPane.add(title);
        contentPane.add(item1);
        contentPane.add(item2);
        contentPane.add(item3);
        contentPane.add(item4);
        contentPane.add(item5);
        contentPane.add(item6);
        contentPane.add(item7);
        contentPane.add(item8);
        contentPane.add(item9);
        contentPane.add(item10);
        contentPane.add(userin1);
        contentPane.add(userin);
        contentPane.add(address1);
        contentPane.add(address);
        contentPane.add(buttonAdd);
        contentPane.add(buttonConfirmPurchase);

        getContentPane().add(contentPane);
    }

    private Topping getPredefinedTopping(String userInput) {
        switch (userInput.toLowerCase()) {
            case "buffalo chicken":
                return new Topping("Buffalo Chicken", 3);
            case "artichoke hearts":
                return new Topping("Artichoke Hearts", 3);
            case "pineapple and ham":
                return new Topping("Pineapple and Ham", 3);
            case "sun-dried tomatoes":
                return new Topping("Sun-Dried Tomatoes", 3);
            case "bbq pulled pork":
                return new Topping("BBQ Pulled Pork", 3);
            case "mushrooms and gorgonzola":
                return new Topping("Mushrooms and Gorgonzola", 3);
            case "prosciutto and fig":
                return new Topping("Prosciutto and Fig", 3);
            case "shrimp and pesto":
                return new Topping("Shrimp and Pesto", 3);
            case "caramelized onions and goat cheese":
                return new Topping("Caramelized Onions and Goat Cheese", 3);
            case "sliced avocado":
                return new Topping("Sliced Avocado", 3);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        DemoPizza example = new DemoPizza();
        example.setVisible(true);
    }
}
