package Room;

import Room.Start;
import Config.ImageSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Credit extends OurFrame {

    private Start S;
    private ImageSet backgroundImg;
    private JLabel BackLabel, CreditLabel;
    private boolean Endgame;

    public Credit(Start s) {
        super("Credit", null);
        S = s;
        menubar.setVisible(false);
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.LIGHT_GRAY);
        Endgame = false;
        addcomponent();
    }

    public Credit() {
        super("Credit", null);
        menubar.setVisible(false);
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.LIGHT_GRAY);
        Endgame = true;
        addcomponent();
    }

    public void addcomponent() {
        backgroundImg = new ImageSet("resource/menu/tutorial/MenuBG.png").resize(1366, 768);

        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);

        CreditLabel = new JLabel(new ImageSet("resource/menu/Credit/credit.png").resize(1087, 613));
        CreditLabel.setBounds(150, 50, 1087, 613);

        BackLabel = new JLabel(new ImageSet("resource/Arrow/Left.png").resize(64, 64));
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        drawpane.add(BackLabel);
        drawpane.add(CreditLabel);

        addListener();

        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();
    }

    public void addListener() {
        BackLabel.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                if (Endgame) {
                    System.exit(0);
                } else {
                       S.setVisible(true);
                       dispose();
                   

                }

            }
        });
    }

}
