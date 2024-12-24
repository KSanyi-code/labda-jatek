import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class main extends JFrame implements ActionListener {

    private int ballX = 150;
    private int ballY = 150;
    private int speedX = 7;
    private int speedY = 7;

    private Timer timer;

    public main() {
        setTitle("Pattogó Labda");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(20, this);
        timer.start();

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(255,0,0));
        g.fillOval(ballX, ballY, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += speedX;
        ballY += speedY;

        // Falak ellenőrzése és a sebesség megfordítása
        if (ballX <= 0 || ballX >= getWidth() - 20) {
            speedX = -speedX;
        }
        if (ballY <= 0 || ballY >= getHeight() - 20) {
            speedY = -speedY;
        }

        repaint();
    }

    public static void main(String[] args) {
        new main();
    }
}