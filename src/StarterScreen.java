import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StarterScreen extends JFrame {
    static String buttonClicked = null;
    public StarterScreen() {
        JPanel mainPanel = new JPanel(new FlowLayout());
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setPreferredSize(new Dimension(800, 500));

//        // create a JLabel with an ImageIcon
//        ImageIcon backgroundIcon = new ImageIcon("path/to/image.jpg");
//        JLabel backgroundLabel = new JLabel(backgroundIcon);
//
//        // set the layout of the startScreen panel to null
//        mainPanel.setLayout(null);
//
//        // set the bounds of the backgroundLabel to fill the startScreen panel
//        backgroundLabel.setBounds(0, 0, mainPanel.getPreferredSize().width, mainPanel.getPreferredSize().height);
//
//        // add the backgroundLabel to the startScreen panel
//        mainPanel.add(backgroundLabel);

        // add components to startScreen panel
        // Create a JLabel with the message

        JLabel space = new JLabel(" ");
        space.setFont(new Font("Arial", Font.BOLD, 175));
        mainPanel.add(space);

        JLabel messageLabel = new JLabel("Welcome to my Life Simulator! pick a colour and hope it is the last one standing!");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(messageLabel);

        JLabel messageLabel2 = new JLabel("The rules are the following: red always kills blue, blue always kills green, green always kills purple, purple always kills yellow, and yellow always kills red");
        messageLabel2.setFont(new Font("Arial", Font.BOLD, 10));
        mainPanel.add(messageLabel2, new FlowLayout());

        // Create a JButton to move on to the next screen
        JButton redButton = new JButton("Red");
        mainPanel.add(redButton, new FlowLayout());
        redButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        redButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game();
                setVisible(false);
                startGame("Red");
                redClicked();
            }
        });
        JButton blueButton = new JButton("Blue");
        mainPanel.add(blueButton, new FlowLayout());
        blueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        blueButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game();
                setVisible(false);
                startGame("Blue");
                blueClicked();
            }
        });
        JButton greenButton = new JButton("Green");
        mainPanel.add(greenButton, new FlowLayout());
        greenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        greenButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game();
                setVisible(false);
                startGame("Green");
                greenClicked();
            }
        });
        JButton purpleButton = new JButton("Purple");
        mainPanel.add(purpleButton, new FlowLayout());
        purpleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        purpleButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        purpleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game();
                setVisible(false);
                startGame("Purple");
                purpleClicked();
            }
        });
        JButton yellowButton = new JButton("Yellow");
        mainPanel.add(yellowButton, new FlowLayout());
        yellowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        yellowButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        yellowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game();
                setVisible(false);
                startGame("Yellow");
                yellowClicked();
            }
        });
        mainPanel.add(redButton); // add the button to the main panel
        mainPanel.add(blueButton);
        mainPanel.add(greenButton);
        mainPanel.add(purpleButton);
        mainPanel.add(yellowButton);
        MyComponent myComponent = new MyComponent();
        mainPanel.add(myComponent);
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void redClicked(){
        buttonClicked = "Red";
    }
    public void blueClicked(){
        buttonClicked = "Blue";
    }
    public void greenClicked(){
        buttonClicked = "Green";
    }
    public void purpleClicked(){
        buttonClicked = "Purple";
    }
    public void yellowClicked(){
        buttonClicked = "Yellow";
    }
    public static String colourPicked(){
        return buttonClicked;
    }

    private void startGame(String buttonPressed) {
        System.out.println("Starting game with " + buttonPressed);
    }

//    public String colourChosen (){
//        return colourChosen[0];
//    }
}

class MyComponent extends JComponent implements MyInterface {
    public void myMethod() {
    }
}

interface MyInterface {
    void myMethod();
}