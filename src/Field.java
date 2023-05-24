import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Field {
    private final ArrayList<Entities> objects;
    private final int width;
    private final int height;
    public String finalColour;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        objects = new ArrayList<Entities>();
    }

    public void generateObjects() {
        Random rand = new Random();
        int numObjects = rand.nextInt(21) + 30;
        for (int i = 0; i < numObjects; i++) {
            int x = rand.nextInt(width - 30);
            int y = rand.nextInt(height - 30);
            int vx = rand.nextInt(15) - 12;
            int vy = rand.nextInt(15) - 12;
            Color color = getRandomColor();
            Entities object = new Entities(x, y, color, vx, vy);
            objects.add(object);
        }
//
//        int delay = 5000;
//        Timer timer = new Timer(delay, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Random rand = new Random();
//                int x = rand.nextInt(width - 30);
//                int y = rand.nextInt(height - 30);
//                int vx = rand.nextInt(7) - 3;
//                int vy = rand.nextInt(7) - 3;
//                Color color = getRandomColor();
//                Object object = new Object(x, y, color, vx, vy);
//                objects.add(object);
//            }
//        });
//        timer.start();
    }

    private Color getRandomColor() {
        Random rand = new Random();
        int colorNum = rand.nextInt(5);
        return switch (colorNum) {
            case 0 -> Color.RED;
            case 1 -> Color.BLUE;
            case 2 -> Color.GREEN;
            case 3 -> new Color(128, 0, 128);
            default -> Color.YELLOW;
        };
    }

    public void moveObjects() {
        // Loop through each object in the "objects" list
        for (int i = 0; i < objects.size(); i++) {
            // Get the current object
            Entities object = objects.get(i);
            // Call the "move()" method on the object
            object.move();
            // If the object is out of bounds in the x-direction, reverse its velocity in the x-direction
            if (object.getX() < 0 || object.getX() > width - 30) {
                object.setVX(-object.getVX());
            }
            // If the object is out of bounds in the y-direction, reverse its velocity in the y-direction
            if (object.getY() < 0 || object.getY() > height - 30) {
                object.setVY(-object.getVY());
            }
            // Loop through each pair of objects in the "objects" list (starting with the i-th object)
            for (int j = i + 1; j < objects.size(); j++) {
                // Get the other object in the pair
                Entities other = objects.get(j);
                // If the two objects are colliding, call the "interact()" method with the two objects as input parameters
                if (object.getX() < other.getX() + 30 && object.getX() + 30 >other.getX() &&
                        object.getY() < other.getY() + 30 && object.getY() + 30 > other.getY()) {
                    interact(object, other);
                }
            }
        }
    }

    private void interact(Entities object, Entities other) {
        Color color1 = object.getColor();
        Color color2 = other.getColor();

        if ((color1.equals(Color.RED) && color2.equals(Color.BLUE)) ||
                (color1.equals(Color.BLUE) && color2.equals(Color.GREEN)) ||
                (color1.equals(Color.GREEN) && color2.equals(new Color(128, 0, 128))) ||
                (color1.equals(new Color(128, 0, 128)) && color2.equals(Color.YELLOW)) ||
                (color1.equals(Color.YELLOW) && color2.equals(Color.RED))) {
            kill(object, other);
        } else {
            kill(object,other);
        }
    }

    private void reproduce(Entities object, Entities other) {
        Random rand = new Random();
        int x = (object.getX() + other.getX()) / 2;
        int y = (object.getY() + other.getY()) / 2;
        int vx = rand.nextInt(50) - 3;
        int vy = rand.nextInt(50) - 3;
        Color color = object.getColor();
        Entities newObject = new Entities(x, y, color, vx, vy);
        objects.remove(object);
        objects.remove(other);
        objects.add(newObject);
    }

    private void kill(Entities object, Entities other) {
        objects.remove(other);
    }

    public void draw(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, width, height);
        for (Entities object : objects) {
            object.draw(g);
        }
    }

//    public boolean isGameOver() {
//        Color color = null;
//        for (Object object : objects) {
//            if (color == null) {
//                color = object.getColor();
//            } else if (!color.equals(object.getColor())) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isThereOneColourLeft(){
        Color color = null;
        for (Entities object : objects) {
            if (color == null) {
                color = object.getColor();
            } else if (!color.equals(object.getColor())) {
                return false;
            }
        }
        return true;
    }
public boolean isGameOver() {
    return this.objects.size() <= 1;
}
    void endGame() {
        if (this.objects.size() == 1) {
            Color color = objects.get(0).getColor();
            new ImageIcon();
            String colors;
            ImageIcon colorImage = null;
            if (color == Color.RED) {
                colors = "RED";
                if(StarterScreen.colourPicked()=="Red") {
                    JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You win!", "WINNER", JOptionPane.INFORMATION_MESSAGE, colorImage);
                }
                else JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You lose!", "LOSER", JOptionPane.INFORMATION_MESSAGE, colorImage);
            } else if (color == Color.BLUE) {
                colors = "BLUE";
                if(StarterScreen.colourPicked()=="Blue") {
                    JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You win!", "WINNER", JOptionPane.INFORMATION_MESSAGE, colorImage);
                }
                else JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You lose!", "LOSER", JOptionPane.INFORMATION_MESSAGE, colorImage);
            } else if (color == Color.GREEN) {
                colors = "GREEN";
                if(StarterScreen.colourPicked()=="Green") {
                    JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You win!", "WINNER", JOptionPane.INFORMATION_MESSAGE, colorImage);
                }
                else JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You lose!", "LOSER", JOptionPane.INFORMATION_MESSAGE, colorImage);
            } else if (color == Color.YELLOW) {
                colors = "YELLOW";
                if(StarterScreen.colourPicked()=="Yellow") {
                    JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You win!", "WINNER", JOptionPane.INFORMATION_MESSAGE, colorImage);
                }
                else JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You lose!", "LOSER", JOptionPane.INFORMATION_MESSAGE, colorImage);
            }
            else if (color == new Color(128, 0, 128)){
                colors = "PURPLE";
                if(StarterScreen.colourPicked()=="Purple") {
                    JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You win!", "WINNER", JOptionPane.INFORMATION_MESSAGE, colorImage);
                }
                else JOptionPane.showMessageDialog(null, colors + " is the Winner!" + " You lose!", "LOSER", JOptionPane.INFORMATION_MESSAGE, colorImage);
            }
            else JOptionPane.showMessageDialog(null, "You lose!", "LOSER!!", JOptionPane.INFORMATION_MESSAGE, colorImage);
        }
        System.exit(0);
    }
    public Color getColour() {
        Color color = null;
        Color finalColor = null;
        for (Entities object : objects) {
            if (color == null) {
                color = object.getColor();
                finalColor = object.getColor();
            } else if (!color.equals(object.getColor())) {
                break;
            }
        }
        return finalColor;
    }
    public String getFinalColor(){
        finalColour = String.valueOf(getColour());
        return finalColour;
    }
}