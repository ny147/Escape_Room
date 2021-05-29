package Item_Feather;


import Config.ImageSet;
import Config.SoundEffect;
import Item_Feather.Ghost;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class ghostgame extends JFrame {

    private int count = 0;
    private SoundEffect ghostsound;
    private boolean play = true;

    public ghostgame() {
        ghostsound = new SoundEffect("music/SoundEffect/ghost/ghost.wav");
        setBounds(50, 50, 1366, 768);
        JLabel background = new JLabel(new ImageSet("resource/ghost/ghostBG.png").resize(1366, 718));
        background.setBounds(0, 50, 1366, 718);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        JButton button = new JButton(new ImageSet("resource/ghost/ghost.png").resize(300, 300));
        button.setBounds((int) (Math.random() * 1300), (int) (Math.random() * 600), 300, 300);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        add(button);
        add(background);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(0, 0, 1366, 50);
        progressBar.setForeground(Color.green);
        progressBar.setBackground(Color.black);
        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        ghostsound.playLoop();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (count % 9 == 0 && count != 0) {
                    Ghost.checkghost();
                    ghostsound.stop();
                    play = false;
                    dispose();
                }
                count++;
                progressBar.setValue(count * 10);
            }
        }
        );
        while (play) {
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            button.setBounds((int) (Math.random() * 1300), (int) (Math.random() * 600), 300, 300);
            repaint();

        }

    }

    /*public static void main(String[] args) {
        new ghostgame();
    }*/
}
