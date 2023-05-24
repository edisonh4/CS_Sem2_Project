import javax.swing.*;
import java.awt.*;
import java.util.List;
public class Game extends JFrame {
    private final Field field;
    private final JButton startButton;
    private final JLabel gameOverLabel;

    public Game() {
        setTitle("Life Simulator");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        field = new Field(500, 400);
        startButton = new JButton("Start");
        startButton.addActionListener(e -> startGame());
        add(startButton, BorderLayout.NORTH);
        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                field.draw(g);
            }
        };
        panel.setPreferredSize(new Dimension(500, 400));
        add(panel, BorderLayout.CENTER);
        gameOverLabel = new JLabel();
        add(gameOverLabel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void startGame() {
        field.generateObjects();
        startButton.setEnabled(false);
        Timer timer = new Timer(20, e -> {
            field.moveObjects();
            repaint();
            if (this.field.isGameOver()) {
                field.endGame();
            }
        });
        timer.start();
    }

//    private void endGame() {
//        startButton.setEnabled(true);
//        gameOverLabel.setText("Game Over!");
//    }
//    public static void winner(){
//        String finalColour = Field.getFinalColor();
//    }

    public static void main(String[] args) {
        StarterScreen starterScreen = new StarterScreen();
    }
}
