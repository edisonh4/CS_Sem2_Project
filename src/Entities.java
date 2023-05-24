import java.awt.*;

public class Entities {
    private int x, y, vx, vy;
    private final Color color;

    public Entities(int x, int y, Color color, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
    }

    public void move() {
        x += vx;
        y += vy;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 30, 30);
    }

    public Color getColor() {
        return color;
    }

    public void setVX(int vx) {
        this.vx = vx;
    }

    public void setVY(int vy) {
        this.vy = vy;
    }

    public int getVX(){
        return vx;
    }

    public int getVY(){
        return vy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}