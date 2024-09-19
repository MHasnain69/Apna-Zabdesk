import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class SnakeVisual extends JFrame {
    MySnakePanel panel = new MySnakePanel(this);

    SnakeVisual() {
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    
    public void restartGame() {
        this.dispose(); 
        new SnakeVisual(); 
    }
}

class MySnakePanel extends JPanel implements ActionListener {
    static final int ScreenWidth = 800;
    static final int ScreenHeight = 800;
    static final int Unit = 25;
    static final int GameUnit = (ScreenWidth * ScreenHeight) / Unit;
    int[] x = new int[GameUnit];
    int[] y = new int[GameUnit];
    static final int Delay = 75;
    int appleEaten;
    int bodyParts = 4;
    int appleX;
    int appleY;
    int greenAppleX = -1;
    int greenAppleY = -1;
    boolean running = false;
    char direction = 'R';

    Timer timer;
    Random random;
    SnakeVisual snakeVisual;

    MySnakePanel(SnakeVisual snakeVisual) {
        this.snakeVisual = snakeVisual;
        random = new Random();
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        StartGame();
    }

    public void StartGame() {
        running = true;
        for (int i = 0; i < bodyParts; i++) {
            x[i] = 50 - i * Unit;
            y[i] = 50;
        }
        newApple();
        timer = new Timer(Delay, this);
        timer.start();
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - Unit;
                break;
            case 'D':
                y[0] = y[0] + Unit;
                break;
            case 'R':
                x[0] = x[0] + Unit;
                break;
            case 'L':
                x[0] = x[0] - Unit;
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(appleX, appleY, Unit, Unit);

        if (appleEaten != 0 && appleEaten % 5 == 0) {
            g.setColor(Color.GREEN);
            g.fillOval(greenAppleX, greenAppleY, Unit * 2, Unit * 2);
        }

        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.WHITE);
                g.fillRect(x[i], y[i], Unit, Unit);
            } else {
                g.setColor(Color.GRAY);
                g.fillRect(x[i], y[i], Unit, Unit);
            }
        }
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + (appleEaten * 8), (ScreenWidth - metrics.stringWidth("Score: " + (appleEaten * 8))) / 2, g.getFont().getSize());

        if (!running) {
            GameOver(g);
        }
    }

    public void GameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 60));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (ScreenWidth - metrics.stringWidth("Game Over")) / 2, ScreenHeight / 2);
    
        g.setFont(new Font("Ink Free", Font.BOLD, 35));
        g.drawString("Noob Salee", (ScreenWidth - metrics.stringWidth("Noob Salee")) / 2 + 60, ScreenHeight / 2 + 35);
    
        if (getComponentCount() == 0) {
            JButton replayButton = new JButton("Play Again");
            replayButton.setFont(new Font("Ink Free", Font.BOLD, 35));
            replayButton.setBackground(new Color(0, 255, 127));
            replayButton.setForeground(Color.WHITE);
            replayButton.setFocusable(false);
            replayButton.setBounds((ScreenWidth - 200) / 2, ScreenHeight / 2 + 65, 200, 50);
    
            replayButton.addActionListener(e -> snakeVisual.restartGame());
    
            this.setLayout(null); 
            this.add(replayButton);
    
            this.revalidate();
            this.repaint();
        }
    }
    

    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        if (x[0] >= ScreenWidth || x[0] < 0 || y[0] >= ScreenHeight || y[0] < 0) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (ScreenWidth / Unit)) * Unit;
        appleY = random.nextInt((int) (ScreenHeight / Unit)) * Unit;
    }

    public void newGreenApple() {
        greenAppleX = random.nextInt((int) (ScreenWidth / Unit)) * Unit;
        greenAppleY = random.nextInt((int) (ScreenHeight / Unit)) * Unit;
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            appleEaten++;
            newApple();
            if (appleEaten % 5 == 0) {
                newGreenApple();
            }
        }
        if ((x[0] >= greenAppleX) && (x[0] < greenAppleX + Unit * 2) &&
                (y[0] >= greenAppleY) && (y[0] < greenAppleY + Unit * 2)) {
            bodyParts += 3;
            appleEaten += 2;
            greenAppleX = -1;
            greenAppleY = -1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}

