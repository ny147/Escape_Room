package Room;


import Item_Feather.Player;
import Config.SoundEffect;
import Config.ImageSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends OurFrame {

    private Start S = this;
    private ImageSet backgroundImg, VolumeImg, MuteImg;
    private JLabel StartLabel, Tutorialabel, QuitLabel, SoundLabel;
    private JButton CreditButton;
    private SoundEffect menusound,opensound;
    private boolean isplaying;

    public Start() {
        super("Start", null);

        contentpane.setLayout(new BorderLayout());
        menubar.setVisible(false);
        menusound = new SoundEffect("music/BGmusic/menu.wav");
        opensound = new SoundEffect("music/SoundEffect/item/openmenu.wav");

        addcomponent();

    }

    public void addcomponent() {

        backgroundImg = new ImageSet("resource/menu/start/MenuBG.png").resize(1366, 768);
        VolumeImg = new ImageSet("resource/Sound/volume.png").resize(64, 64);
        MuteImg = new ImageSet("resource/Sound/mute.png").resize(64, 64);

        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);

        StartLabel = new JLabel(new ImageSet("resource/menu/start/Start.png").resize(350, 50));
        StartLabel.setBounds(250, 300, 350, 50);
        StartLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Tutorialabel = new JLabel(new ImageSet("resource/menu/start/Tutorial.png").resize(350, 50));
        Tutorialabel.setBounds(250, 390, 350, 50);
        Tutorialabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        CreditButton = new JButton("Credit");
        CreditButton.setBounds(797, 450, 120, 50);
        

        QuitLabel = new JLabel(new ImageSet("resource/menu/start/Exit.png").resize(350, 50));
        QuitLabel.setBounds(250, 480, 350, 50);
        QuitLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        SoundLabel = new JLabel(VolumeImg);
        SoundLabel.setBounds(10, 10, 64, 64);
        SoundLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addListener();
        drawpane.add(StartLabel);
        drawpane.add(Tutorialabel);
        drawpane.add(CreditButton);
        drawpane.add(QuitLabel);
        drawpane.add(SoundLabel );
        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();

    }

    public void playMusic() {
        menusound.playLoop();
        isplaying = true;

    }

    public void addListener() {
        SoundLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (isplaying) {
                    menusound.stop();
                    isplaying = false;
                    SoundLabel.setIcon(MuteImg);
                } else {
                    menusound.playLoop();
                    isplaying = true;
                    SoundLabel.setIcon(VolumeImg);

                }

            }

        });

        StartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                opensound.playOnce();
                player = new Player("Player1");
                player.getLivingRoom().Open();
                player.getRoomSound().playLoop();
                menusound.stop();
                

            }
        });

        Tutorialabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                opensound.playOnce();
                new Tutorial(S).setVisible(true);

            }
        });
        CreditButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                opensound.playOnce();
                new Credit(S).setVisible(true);

            }
        });
        QuitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                System.exit(0);
            }
        });

    }

   /* public static void main(String args[]) {
        Start st =  new Start();
        st.setVisible(true);
        st.playMusic();

    }*/
}

class Tutorial extends OurFrame {

    private Start S;
    private ImageSet backgroundImg;
    private JLabel BackLabel, LeftLabel, RightLabel;
    private JLabel[] tutorLabel = new JLabel[3];
    private int i = 0;
     private SoundEffect changechannelsound;

    public Tutorial(Start s) {
        super("Tutorial", null);
        S = s;
        menubar.setVisible(false);
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.LIGHT_GRAY);
        changechannelsound =   new SoundEffect("music/SoundEffect/item/selected_item.wav");
        addcomponent();
    }

    public void addcomponent() {
        backgroundImg = new ImageSet("resource/menu/tutorial/TutorialBG.png").resize(1366, 768);

        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        
        BackLabel = new JLabel(new ImageSet("resource/Arrow/Left.png").resize(64, 64));
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        LeftLabel = new JLabel(new ImageSet("resource/Arrow/Left.png").resize(64, 64));
        LeftLabel.setBounds(0, 300, 64, 64);
        LeftLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        RightLabel = new JLabel(new ImageSet("resource/Arrow/Right.png").resize(64, 64));
        RightLabel.setBounds(1280, 300, 64, 64);
        RightLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        tutorLabel[0] = new JLabel(new ImageSet("resource/menu/tutorial/tutor1.png").resize(1087, 613));
        tutorLabel[0].setBounds(75, 50, 1087, 613);

        tutorLabel[1] = new JLabel(new ImageSet("resource/menu/tutorial/tutor2.png").resize(1087, 613));
        tutorLabel[1].setBounds(75, 50, 1087, 613);
        tutorLabel[1].setVisible(false);

        tutorLabel[2] = new JLabel(new ImageSet("resource/menu/tutorial/tutor3.png").resize(1087, 613));
        tutorLabel[2].setBounds(75, 50, 1087, 613);
        tutorLabel[2].setVisible(false);

        addListener();

        drawpane.add(BackLabel);
        drawpane.add(LeftLabel);
        drawpane.add(RightLabel);
        drawpane.add(tutorLabel[0]);
        drawpane.add(tutorLabel[1]);
        drawpane.add(tutorLabel[2]);

        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();
    }

    public void addListener() {
        BackLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                S.setVisible(true);
                dispose();
            }
        });
        LeftLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (i > 0) {
                    changechannelsound.playOnce();
                    tutorLabel[i].setVisible(false);
                    i--;
                    tutorLabel[i].setVisible(true);
                }

            }
        });
        RightLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (i < 2) {
                    changechannelsound.playOnce();
                    tutorLabel[i].setVisible(false);
                    System.out.println(i);
                    i++;
                    System.out.println(i);
                    tutorLabel[i].setVisible(true);
                }

            }
        });
    }

}

