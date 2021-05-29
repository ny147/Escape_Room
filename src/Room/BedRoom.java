package Room;


import Config.ImageSet;
import Item_Feather.Player;
import Config.SoundEffect;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BedRoom extends OurFrame {

  
    private ImageSet backgroundImg;
    private JLabel TeddyLabel, ComLabel, GotoCenterLabel;
    private Teddypuzzle teddypuzzle;
    private Compuzzle compuzzle;

    public BedRoom(Player p) {
        super("Bed room", p);
        
        contentpane.setLayout(new BorderLayout());
        addcomponent();

    }

    public void addcomponent() {
        backgroundImg = new ImageSet("resource/bedroom/bedroomBG.png");

        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);

        TeddyLabel = new JLabel(new ImageSet("resource/bedroom/teddy.png").resize(125, 160));
        TeddyLabel.setBounds(850, 390, 125, 160);
        TeddyLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GotoCenterLabel = new JLabel(new ImageSet("resource/Arrow/Left.png").resize(64, 64));
        GotoCenterLabel.setBounds(50, 50, 64, 64);
        GotoCenterLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ComLabel = new JLabel(new ImageSet("resource/bedroom/com.png").resize(170, 170));
        ComLabel.setBounds(0, 215, 170, 170);
        ComLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addListener();
        addpuzzle();

        drawpane.add(TeddyLabel);
        drawpane.add(GotoCenterLabel);
        drawpane.add(ComLabel);
        contentpane.add(drawpane, BorderLayout.CENTER);

        validate();

    }

    public void addListener() {
        TeddyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                if (teddypuzzle == null) {
                    teddypuzzle = new Teddypuzzle(player);
                }

                teddypuzzle.Open();
                player.getOpenpopupSound().playOnce();
               

            }
        });
        ComLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                if (compuzzle == null) {
                    compuzzle = new Compuzzle(player);
                }
                compuzzle.Open();
                player.getOpenpopupSound().playOnce();

            }
        });
        GotoCenterLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);

                player.getLivingRoom().Open();
                player.getOpenRoomSound().playOnce();
            }
        });

    }

    /*public static void main(String args[]) {
        Player Player1 = new Player("Pete");
        Player1.getBedRoom().Open();

    }*/
}

class Compuzzle extends OurFrame {

    private static String PassWord = "1244";
    private JLabel ComLabel, passBGLabel, BackLabel, CongratLabel, Duck1, Duck2, Duck3, Duck4, Duck5;
    private ImageSet duckPurple, duckCyan, duckBlue, duckGreen, duckYellow, duckOrange, duckRed;
    private JPasswordField JPass;
    private JButton summit, summitduck;
    private JComboBox combobox1, combobox2, combobox3, combobox4, combobox5;
    private ImageSet backgroundImg;
    private SoundEffect computersound;
    public Compuzzle(Player p) {
        super("Computer", p);
        //BR = B;
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.LIGHT_GRAY);

        addcomponent();
        addmusic();
    }
    public void addmusic(){
        
        computersound = new SoundEffect("music/SoundEffect/item/opensoftware.wav");
    }
    public void addcomponent() {
        
        backgroundImg = new ImageSet("resource/bedroom/BGpopup.png").resize(1366, 668);
        
        summit = new JButton("Login");
        summit.setBounds(550, 250, 200, 50);
        summit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPass = new JPasswordField(10);
        JPass.setBounds(475, 197, 350, 40);
        JPass.setFont(new Font("Arial", Font.BOLD, 40));
        JPass.setEchoChar('*');

        ComLabel = new JLabel(new ImageSet("resource/bedroom/compassword.png").resize(700, 500));
        ComLabel.setBounds(350, 50, 700, 500);
        ComLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        passBGLabel = new JLabel(new ImageSet("resource/bedroom/passBG.png").resize(1366, 668));
        passBGLabel.setBounds(0, 0, 1366, 668);

        duckPurple = new ImageSet("resource/bedroom/duckPurple.png").resize(100, 100);
        duckCyan = new ImageSet("resource/bedroom/duckCyan.png").resize(100, 100);
        duckBlue = new ImageSet("resource/bedroom/duckBlue.png").resize(100, 100);
        duckGreen = new ImageSet("resource/bedroom/duckGreen.png").resize(100, 100);
        duckYellow = new ImageSet("resource/bedroom/duckYellow.png").resize(100, 100);
        duckOrange = new ImageSet("resource/bedroom/duckOrange.png").resize(100, 100);
        duckRed = new ImageSet("resource/bedroom/duckRed.png").resize(100, 100);

        Duck1 = new JLabel(duckRed);
        Duck1.setBounds(250, 50, 100, 100);
        Duck1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Duck2 = new JLabel(duckRed);
        Duck2.setBounds(450, 50, 100, 100);
        Duck2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Duck3 = new JLabel(duckRed);
        Duck3.setBounds(650, 50, 100, 100);
        Duck3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Duck4 = new JLabel(duckRed);
        Duck4.setBounds(850, 50, 100, 100);
        Duck4.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Duck5 = new JLabel(duckRed);
        Duck5.setBounds(1050, 50, 100, 100);
        Duck5.setCursor(new Cursor(Cursor.HAND_CURSOR));

        String color[] = {"Red", "Orange", "Yellow", "Green", "Blue", "Cyan", "Purple"};
        combobox1 = new JComboBox(color);
        combobox1.setBounds(250, 175, 100, 20);
        combobox1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        combobox2 = new JComboBox(color);
        combobox2.setBounds(450, 175, 100, 20);
        combobox2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        combobox3 = new JComboBox(color);
        combobox3.setBounds(650, 175, 100, 20);
        combobox3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        combobox4 = new JComboBox(color);
        combobox4.setBounds(850, 175, 100, 20);
        combobox4.setCursor(new Cursor(Cursor.HAND_CURSOR));

        combobox5 = new JComboBox(color);
        combobox5.setBounds(1050, 175, 100, 20);
        combobox5.setCursor(new Cursor(Cursor.HAND_CURSOR));

        BackLabel = new JLabel(new ImageSet("resource/bedroom/back.png").resize(64, 64));
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        summitduck = new JButton("Check!!");
        summitduck.setBounds(600, 300, 200, 50);
        summitduck.setCursor(new Cursor(Cursor.HAND_CURSOR));

        CongratLabel = new JLabel("2 9 0 1 2");
        CongratLabel.setBounds(500, 180, 700, 300);
        CongratLabel.setFont(new Font("Arial", Font.PLAIN, 80));

        addListener();
        drawpane = new JLabel(backgroundImg);
        drawpane.setLayout(null);
        drawpane.add(JPass);
        drawpane.add(summit);
        drawpane.add(ComLabel);
        drawpane.add(Duck1);
        drawpane.add(Duck2);
        drawpane.add(Duck3);
        drawpane.add(Duck4);
        drawpane.add(Duck5);
        drawpane.add(combobox1);
        drawpane.add(combobox2);
        drawpane.add(combobox3);
        drawpane.add(combobox4);
        drawpane.add(combobox5);

        drawpane.add(summitduck);
        drawpane.add(CongratLabel);
        drawpane.add(BackLabel);
        drawpane.add(passBGLabel);
        contentpane.add(drawpane, BorderLayout.CENTER);

        CongratLabel.setVisible(false);
        Duck1.setVisible(false);
        Duck2.setVisible(false);
        Duck3.setVisible(false);
        Duck4.setVisible(false);
        Duck5.setVisible(false);
        summitduck.setVisible(false);
        combobox1.setVisible(false);
        combobox2.setVisible(false);
        combobox3.setVisible(false);
        combobox4.setVisible(false);
        combobox5.setVisible(false);
        passBGLabel.setVisible(false);
        validate();
    }

    public void addListener() {
        combobox1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == combobox1) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String msg = (String) cb.getSelectedItem();
                    switch (msg) {
                        case "Red":
                            Duck1.setIcon(duckRed);
                            break;
                        case "Orange":
                            Duck1.setIcon(duckOrange);
                            break;
                        case "Yellow":
                            Duck1.setIcon(duckYellow);
                            break;
                        case "Green":
                            Duck1.setIcon(duckGreen);
                            break;
                        case "Cyan":
                            Duck1.setIcon(duckCyan);
                            break;
                        case "Blue":
                            Duck1.setIcon(duckBlue);
                            break;
                        case "Purple":
                            Duck1.setIcon(duckPurple);
                            break;
                        default:
                            Duck1.setIcon(duckRed);
                            break;

                    }
                }
            }
        });
        combobox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == combobox2) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String msg = (String) cb.getSelectedItem();
                    switch (msg) {
                        case "Red":
                            Duck2.setIcon(duckRed);
                            break;
                        case "Orange":
                            Duck2.setIcon(duckOrange);
                            break;
                        case "Yellow":
                            Duck2.setIcon(duckYellow);
                            break;
                        case "Green":
                            Duck2.setIcon(duckGreen);
                            break;
                        case "Cyan":
                            Duck2.setIcon(duckCyan);
                            break;
                        case "Blue":
                            Duck2.setIcon(duckBlue);
                            break;
                        case "Purple":
                            Duck2.setIcon(duckPurple);
                            break;
                        default:
                            Duck2.setIcon(duckRed);
                            break;

                    }
                }
            }
        });
        combobox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == combobox3) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String msg = (String) cb.getSelectedItem();
                    switch (msg) {
                        case "Red":
                            Duck3.setIcon(duckRed);
                            break;
                        case "Orange":
                            Duck3.setIcon(duckOrange);
                            break;
                        case "Yellow":
                            Duck3.setIcon(duckYellow);
                            break;
                        case "Green":
                            Duck3.setIcon(duckGreen);
                            break;
                        case "Cyan":
                            Duck3.setIcon(duckCyan);
                            break;
                        case "Blue":
                            Duck3.setIcon(duckBlue);
                            break;
                        case "Purple":
                            Duck3.setIcon(duckPurple);
                            break;
                        default:
                            Duck3.setIcon(duckRed);
                            break;

                    }
                }
            }
        });
        combobox4.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == combobox4) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String msg = (String) cb.getSelectedItem();
                    switch (msg) {
                        case "Red":
                            Duck4.setIcon(duckRed);
                            break;
                        case "Orange":
                            Duck4.setIcon(duckOrange);
                            break;
                        case "Yellow":
                            Duck4.setIcon(duckYellow);
                            break;
                        case "Green":
                            Duck4.setIcon(duckGreen);
                            break;
                        case "Cyan":
                            Duck4.setIcon(duckCyan);
                            break;
                        case "Blue":
                            Duck4.setIcon(duckBlue);
                            break;
                        case "Purple":
                            Duck4.setIcon(duckPurple);
                            break;
                        default:
                            Duck4.setIcon(duckRed);
                            break;

                    }
                }
            }
        });
        combobox5.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == combobox5) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String msg = (String) cb.getSelectedItem();
                    switch (msg) {
                        case "Red":
                            Duck5.setIcon(duckRed);
                            break;
                        case "Orange":
                            Duck5.setIcon(duckOrange);
                            break;
                        case "Yellow":
                            Duck5.setIcon(duckYellow);
                            break;
                        case "Green":
                            Duck5.setIcon(duckGreen);
                            break;
                        case "Cyan":
                            Duck5.setIcon(duckCyan);
                            break;
                        case "Blue":
                            Duck5.setIcon(duckBlue);
                            break;
                        case "Purple":
                            Duck5.setIcon(duckPurple);
                            break;
                        default:
                            Duck5.setIcon(duckRed);
                            break;

                    }
                }
            }
        });
        BackLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                player.getBedRoom().Open();

            }
        });
        summit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(JPass.getPassword());
                if (password.equals(PassWord)) {
                    Duck1.setVisible(true);
                    Duck2.setVisible(true);
                    Duck3.setVisible(true);
                    Duck4.setVisible(true);
                    Duck5.setVisible(true);
                    summitduck.setVisible(true);
                    combobox1.setVisible(true);
                    combobox2.setVisible(true);
                    combobox3.setVisible(true);
                    combobox4.setVisible(true);
                    combobox5.setVisible(true);
                    passBGLabel.setVisible(true);
                    JPass.setVisible(false);
                    summit.setVisible(false);
                    ComLabel.setVisible(false);
                    computersound.playOnce();
                } else {
                    player.getLockSound().playOnce();
                    JOptionPane.showMessageDialog(null,
                            "Password wrong Plz try again!");
                }

            }
        });
        summitduck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int colortrue = 0;
                String msg1 = (String) combobox1.getSelectedItem();
                String msg2 = (String) combobox2.getSelectedItem();
                String msg3 = (String) combobox3.getSelectedItem();
                String msg4 = (String) combobox4.getSelectedItem();
                String msg5 = (String) combobox5.getSelectedItem();
                if (msg1 == "Green") {
                    colortrue++;
                }
                if (msg2 == "Blue") {
                    colortrue++;
                }
                if (msg3 == "Red") {
                    colortrue++;
                }
                if (msg4 == "Yellow") {
                    colortrue++;
                }
                if (msg5 == "Purple") {
                    colortrue++;
                }
                if (colortrue == 5) {
                    Duck1.setVisible(false);
                    Duck2.setVisible(false);
                    Duck3.setVisible(false);
                    Duck4.setVisible(false);
                    Duck5.setVisible(false);
                    summitduck.setVisible(false);
                    combobox1.setVisible(false);
                    combobox2.setVisible(false);
                    combobox3.setVisible(false);
                    combobox4.setVisible(false);
                    combobox5.setVisible(false);
                    CongratLabel.setVisible(true);

                } else {
                    player.getLockSound().playOnce();
                    JOptionPane.showMessageDialog(null,
                            "Wrong Plz try again!");
                }

            }
        });
    }
}

class Teddypuzzle extends OurFrame {

    //private BedRoom BR;
    private JLabel TeddyBearLabel, BackLabel, BackTeddyBearLabel;
    private ImageSet backgroundImg, BacktImg;
    private JRadioButton b1, b2;
    private TeddyZip teddyzip;

    public Teddypuzzle(Player p) {
        super("Teddy", p);
        //BR = B;
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.LIGHT_GRAY);

        addcomponent();
    }

    public void addpuzzle() {
        teddyzip = new TeddyZip(player);

    }

    public void addcomponent() {
   
        BacktImg = new ImageSet("resource/bedroom/back.png").resize(64, 64);
        backgroundImg = new ImageSet("resource/bedroom/BGpopup.png").resize(1366, 668);
        
        drawpane = new JLabel(backgroundImg);
        drawpane.setLayout(null);
        
        TeddyBearLabel = new JLabel(new ImageSet("resource/bedroom/frontteddy.png").resize(800, 568));
        TeddyBearLabel.setBounds(300, 0, 800, 568);

        BackTeddyBearLabel = new JLabel(new ImageSet("resource/bedroom/backteddy.png").resize(800, 568));
        BackTeddyBearLabel.setBounds(300, 0, 800, 568);
        BackTeddyBearLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        BackLabel = new JLabel(BacktImg);
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        drawpane.add(BackLabel);
        drawpane.add(TeddyBearLabel);
        drawpane.add(BackTeddyBearLabel);
        BackTeddyBearLabel.setVisible(false);

        b1 = new JRadioButton("Front");
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2 = new JRadioButton("Back");
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ButtonGroup group = new ButtonGroup();
        b1.setBounds(1200, 200, 100, 100);
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setSelected(true);
        b1.setFont(new Font("Arial", Font.PLAIN, 28));

        b2.setOpaque(false);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setBounds(1200, 300, 100, 100);
        b2.setFont(new Font("Arial", Font.PLAIN, 28));
        group.add(b2);
        group.add(b1);
        drawpane.add(b1);
        drawpane.add(b2);

        addListener();
        addpuzzle();

        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();
    }

    public void addListener() {
        BackTeddyBearLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                teddyzip.Open();
                //new TeddyZip(BR).setVisible(true);
            }

        });
        BackLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //BR.setVisible(true);
                //setVisible(false);
                //dispose();
                setVisible(false);
                player.getBedRoom().Open();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeddyBearLabel.setVisible(true);
                BackTeddyBearLabel.setVisible(false);
            }

        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeddyBearLabel.setVisible(false);
                BackTeddyBearLabel.setVisible(true);
            }

        });

    }

}

class TeddyZip extends OurFrame {

    // private BedRoom BR;
    private JLabel BackTeddyBearLabel, ZipOpenLabel, BackLabel;
    private int x, y, x2, y2;
    private ImageSet backgroundImg;
    private SoundEffect zipsound;

    public TeddyZip(Player p) {
        super("Teddy Puzzle(Back)", p);
        //BR = B;
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.DARK_GRAY);
        addcomponent();
        addmusic();

    }
    public void addmusic(){
    
        zipsound = new SoundEffect("music/SoundEffect/item/zip.wav");
    }

    public void addcomponent() {
       
        backgroundImg = new ImageSet("resource/bedroom/BGpopup.png").resize(1366, 668);
        
        drawpane = new JLabel(backgroundImg);
        drawpane.setLayout(null);

        BackLabel = new JLabel(new ImageSet("resource/bedroom/back.png").resize(64, 64));
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        BackTeddyBearLabel = new JLabel(new ImageSet("resource/bedroom/backteddy.png").resize(800, 568));
        BackTeddyBearLabel.setBounds(300, 0, 800, 568);
        BackTeddyBearLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                                                                        //.resize(400, 400));
        ZipOpenLabel = new JLabel(new ImageSet("resource/bedroom/openteddy.png").resize(800, 568));
        ZipOpenLabel.setBounds(300, 0,800, 568);

        drawpane.add(ZipOpenLabel);
        drawpane.add(BackTeddyBearLabel);
        drawpane.add(BackLabel);

        ZipOpenLabel.setVisible(false);

        addListener();

        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();
    }

    public void addListener() {
        BackTeddyBearLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                if (y2 - y >= 100 && x2 - x <= 50) {
                    ZipOpenLabel.setVisible(true);
                    zipsound.playOnce();
                }
            }
        });
        BackLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //BR.setVisible(true);
                //setVisible(false);
                setVisible(false);
                player.getBedRoom().Open();
            }
        });

    }
    
}

