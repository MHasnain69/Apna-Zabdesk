import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



/**
 * Credits
 */
public class Credits {
    public static void Credits() {
        ScrollingCredits creditsWindow = new ScrollingCredits(() -> {
            
        });

        SwingUtilities.invokeLater(() -> {
            creditsWindow.setVisible(true);
        });
    }
    
}


class ScrollingCredits extends JFrame {

    private CreditsPanel creditsPanel;
    private Runnable onCloseCallback;

    
    public ScrollingCredits(Runnable onCloseCallback) {
        this.onCloseCallback = onCloseCallback; 

        createView();

        setTitle("Credits");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                if (onCloseCallback != null) {
                    onCloseCallback.run();
                }
            }
        });
    }

    private void createView() {
        creditsPanel = new CreditsPanel();
        getContentPane().add(creditsPanel);
    }

    class CreditsPanel extends JPanel {
        private String[][] credits = {
                {"Copyright © ", "SZABIST 2024"},
                {"Developer", "Muhammad Hasnain"},
                {"Designer", "Apka Bhai"},
                {"Project Manager", "Akela mai hi hu"},
                {"Tester", "Chat GPT"},
                {"UX Specialist", "Nhi hai koi"},
                {"Support", "Nhi karta koi support"},
                {"", ""}, 
                {"Marketing", "Nhi ati marketing"},
                {"Beta Testers", "SZABIST Students"},
                {"", ""}, 
                {"", ""}, 
                {"", "Open Source Libraries"},
                {"", "Community Contributors"},
                {"", "Special Thanks to Our Families"},
                {"", "Thanks For Using My Code 😊"}
        };

        private int yPosition;

        public CreditsPanel() {
            yPosition = getHeight() + 600;
            setBackground(Color.BLACK);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    yPosition -= 2;
                    if (yPosition < -calculateTotalHeight() * 40) {
                        yPosition = getHeight() + 100;
                    }
                    repaint();
                }
            }, 0, 30);
        }

        private int calculateTotalHeight() {
            int totalLines = credits.length + 2; 
            return totalLines;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.setColor(Color.GRAY);

            int xTitle = (getWidth() / 2) - 3 - g.getFontMetrics().stringWidth("APNA ZABDESK") / 2;
            int titleY = yPosition - 30;

            g.drawString("APNA", xTitle, titleY);

            g.setColor(Color.WHITE);
            g.drawString("ZABDESK", xTitle + g.getFontMetrics().stringWidth("APNA "), titleY);

            int currentY = 60;

            for (int i = 0; i < credits.length; i++) {
                String category = credits[i][0];
                String name = credits[i][1];

                if (i >= 10) {
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Serif", Font.BOLD, 24));
                    int xCategory = (getWidth() / 2) - g.getFontMetrics().stringWidth(category) / 2;
                    int xName = (getWidth() / 2) - g.getFontMetrics().stringWidth(name) / 2;
                    g.drawString(category, xCategory, yPosition + currentY);
                    g.drawString(name, xName, yPosition + currentY);

                    currentY += 40;
                } else if (!category.isEmpty()) {
                    
                    g.setColor(Color.GRAY);
                    g.setFont(new Font("Serif", Font.BOLD, 20));
                    g.drawString(category, 100, yPosition + currentY);

                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Serif", Font.BOLD, 20));
                    g.drawString(name, 300, yPosition + currentY);

                    currentY += 40; 
                } else {
                    currentY += 80; 
                }
            }
        }
    }
}
