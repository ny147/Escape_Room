package Room;


import Item_Feather.Player;
import Config.ImageSet;
import Config.SoundEffect;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kitchen extends OurFrame {

   
    private ImageSet backgroundImg;
    private JLabel RefrigeratorLabel, SinkLabel, GotoCenterLabel, GotoButtomLabel, CraftLabel;
    private boolean unlock = false, fixed = false;
    private Refrigeratorpuzzle refrigeratorpuzzle;
    private Sinkpuzzle sinkpuzzle;
    private Craftpuzzle craftpuzzle;

  
    public Kitchen(Player p) {
        super("Kitchen", p);
        
        addpuzzle();
        contentpane.setLayout(new BorderLayout());
        addcomponent();

    }

    public void addcomponent() {
        backgroundImg = new ImageSet("resource/kitchen/kitchenBG.png").resize(1366, 668);

        // g = new Ghost();
        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);

        RefrigeratorLabel = new JLabel(new ImageSet("resource/kitchen/refrigerator.png").resize(100, 100));
        RefrigeratorLabel.setBounds(350, 180, 100, 100);
        RefrigeratorLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        GotoCenterLabel = new JLabel(new ImageSet("resource/Arrow/Left.png").resize(64, 64));
        GotoCenterLabel.setBounds(15, 50, 64, 64);
        GotoCenterLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        SinkLabel = new JLabel(new ImageSet("resource/kitchen/sink.png").resize(64, 64));
        SinkLabel.setBounds(400, 510, 50, 50);
        SinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GotoButtomLabel = new JLabel(new ImageSet("resource/Arrow/Down.png").resize(64, 64));
        GotoButtomLabel.setBounds(600, 450, 64, 64);
        GotoButtomLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        CraftLabel = new JLabel(new ImageSet("resource/kitchen/craft.png").resize(150, 100));
        CraftLabel.setBounds(955, 200, 150, 100);
        CraftLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addListener();

        //drawpane.add(g);
        drawpane.add(GotoCenterLabel);
        drawpane.add(RefrigeratorLabel);
        drawpane.add(SinkLabel);
        drawpane.add(GotoButtomLabel);
        drawpane.add(CraftLabel);

        contentpane.add(drawpane, BorderLayout.CENTER);
        // updatePlayerpane();
        validate();

    }

    public void addListener() {
        RefrigeratorLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (unlock) {
                    setVisible(false);
                    if (refrigeratorpuzzle == null) {
                        refrigeratorpuzzle = new Refrigeratorpuzzle(player);
                    }
                    refrigeratorpuzzle.Open();
                    player.getOpenpopupSound().playOnce();
                    //  new Refrigeratorpuzzle(player).setVisible(true);
                } else {
                    player.getLockSound().playOnce();
                    JOptionPane.showMessageDialog(null,
                            "It is locked!!");
                }

            }
        });
        SinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                if (sinkpuzzle == null) {
                    sinkpuzzle = new Sinkpuzzle(player);
                }

                sinkpuzzle.Open();
                sinkpuzzle.getSound().playLoop();
                player.getOpenpopupSound().playOnce();

            }
        });
        CraftLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                if (craftpuzzle == null) {
                    craftpuzzle = new Craftpuzzle(player);
                }
                craftpuzzle.checkmatrial();
                craftpuzzle.Open();
                player.getOpenpopupSound().playOnce();

            }
        });
        GotoCenterLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                player.clearradiofocus();
                player.getLivingRoom().Open();
                player.getOpenRoomSound().playOnce();
                //new TV().setVisible(true); 
            }
        });
        GotoButtomLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                player.clearradiofocus();
                player.getBathRoom().Open();
                player.getOpenRoomSound().playOnce();
            }
        });

    }

    public boolean getfixed() {
        return fixed;
    }

    public void setfixed() {
        fixed = true;
    }

    public boolean getunlock() {
        return unlock;
    }

    public void setunlock() {
        unlock = true;
    }

    public void setSink() {
        SinkLabel.setVisible(false);
    }

    /*public static void main(String args[]) {
        //  new Kitchen();]
        Player p = new Player("somchai");
        p.getKitchen().Open();

    }*/
}

class Refrigeratorpuzzle extends OurFrame {

    private ImageSet backgroundImg;
    private JLabel topRefrigeLabel,
            opentopRefrigeIronLabel,
            opentopRefrigeLabel, BackLabel;
    private SoundEffect fallingsound;

    public Refrigeratorpuzzle(Player p) {
        super("Refrigerator", p);

        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.LIGHT_GRAY);

        addcomponent();
        addmusic();
    }

    public void addmusic() {
        fallingsound = new SoundEffect("music/SoundEffect/item/ice.wav");

    }

    public void addcomponent() {
        backgroundImg = new ImageSet("resource/kitchen/BGkitchenpuzzle.png").resize(1366, 668);

        topRefrigeLabel = new JLabel(new ImageSet("resource/kitchen/toprefrige.png").resize(500, 500));
        topRefrigeLabel.setBounds(400, 50, 500, 500);

        opentopRefrigeLabel = new JLabel(new ImageSet("resource/kitchen/opentoprefrige.png").resize(500, 500));
        opentopRefrigeLabel.setBounds(400, 50, 500, 500);
        opentopRefrigeLabel.setVisible(false);

        opentopRefrigeIronLabel = new JLabel(new ImageSet("resource/kitchen/opentoprefrigeIron.png").resize(500, 500));
        opentopRefrigeIronLabel.setBounds(400, 50, 500, 500);
        opentopRefrigeIronLabel.setVisible(false);

        BackLabel = new JLabel(new ImageSet("resource/Arrow/Left.png").resize(64, 64));
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addListener();
        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        contentpane.add(drawpane, BorderLayout.CENTER);
        drawpane.add(topRefrigeLabel);
        drawpane.add(opentopRefrigeLabel);
        drawpane.add(opentopRefrigeIronLabel);
        drawpane.add(BackLabel);

    }

    public void addListener() {
        topRefrigeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                opentopRefrigeIronLabel.setVisible(true);
                topRefrigeLabel.setVisible(false);

            }
        });
        opentopRefrigeIronLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                fallingsound.playOnce();
                JOptionPane.showMessageDialog(null,
                        "Get 3 Irons");
                opentopRefrigeLabel.setVisible(true);
                opentopRefrigeIronLabel.setVisible(false);
                // player.getItem(3).setamount(3);
                player.pickItem(3);
            }
        });
        BackLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                player.getKitchen().Open();

            }
        });
    }
}

class Sinkpuzzle extends OurFrame {

    private ImageSet backgroundImg;
    private JLabel BrokeSinkLabel, FixSinkLabel, BackLabel;
    private boolean usetape = false, Fixed;
    private SoundEffect electricsound;

    public Sinkpuzzle(Player p) {
        super("Sink", p);
     

        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.LIGHT_GRAY);

        addcomponent();
        addmusic();
    }

    public void addmusic() {

        electricsound = new SoundEffect("music/SoundEffect/item/Electrict.wav");
    }

    public SoundEffect getSound() {
        return electricsound;

    }

    public void addcomponent() {
        backgroundImg = new ImageSet("resource/kitchen/BGkitchenpuzzle.png").resize(1366, 668);

        BrokeSinkLabel = new JLabel(new ImageSet("resource/kitchen/BrokeSink.png").resize(500, 500));
        BrokeSinkLabel.setBounds(400, 50, 500, 500);
        BrokeSinkLabel.setVisible(false);
        BrokeSinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        FixSinkLabel = new JLabel(new ImageSet("resource/kitchen/FixSink.png").resize(500, 500));
        FixSinkLabel.setBounds(400, 50, 500, 500);
        FixSinkLabel.setVisible(false);
        

        BackLabel = new JLabel(new ImageSet("resource/Arrow/Left.png").resize(64, 64));
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addListener();
        checkfixed();
        
        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        drawpane.add(BrokeSinkLabel);
        drawpane.add(FixSinkLabel);
        drawpane.add(BackLabel);
        contentpane.add(drawpane, BorderLayout.CENTER);

    }

    public void checkfixed() {
        if (player.getKitchen().getfixed()) {
            BrokeSinkLabel.setVisible(false);
            FixSinkLabel.setVisible(true);
        } else {
            BrokeSinkLabel.setVisible(true);
            FixSinkLabel.setVisible(false);
        }
    }

    public void addListener() {
        BrokeSinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (usetape) {
                    fixed();
                    BrokeSinkLabel.setVisible(false);
                    FixSinkLabel.setVisible(true);
                    player.lostitem(1);
                    player.getKitchen().setunlock();
                    player.getKitchen().setfixed();
                    electricsound.stop();

                }

            }
        });
        player.getRadio(1).addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1 && player.getItem(1).getamount() == 1) {

                    usetape = true;
                } else {
                    usetape = false;
                }
            }

        });
        BackLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                electricsound.stop();
                player.getKitchen().Open();
                if (player.getKitchen().getfixed()) {
                    player.getKitchen().setSink();
                }
            }
        });
    }

    public void fixed() {
        player.getKitchen().setfixed();
    }

}

class Craftpuzzle extends OurFrame {

    private ImageSet backgroundImg;
    private JLabel arrowLabel,
            craft1Label, craft2Label, craft3Label,
            craft4Label, craft5Label, craft6Label,
            craft7Label, craft8Label, craft9Label,
            craftedLabel, woodLabel1, woodLabel2,
            ironLabel1, ironLabel2, ironLabel3,
            AxeLabel, BackLabel;

    public Craftpuzzle(Player p) {
        super("Crafting Table", p);

        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.LIGHT_GRAY);

        addcomponent();
    }

    public void addcomponent() {
        backgroundImg = new ImageSet("resource/kitchen/BGkitchenpuzzle.png").resize(1366, 668);

        BackLabel = new JLabel(new ImageSet("resource/Arrow/Left.png").resize(64, 64));
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        craft1Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft1Label.setBounds(400, 50, 100, 100);

        craft2Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft2Label.setBounds(400, 150, 100, 100);

        craft3Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft3Label.setBounds(400, 250, 100, 100);

        craft4Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft4Label.setBounds(500, 50, 100, 100);

        craft5Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft5Label.setBounds(500, 150, 100, 100);

        craft6Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft6Label.setBounds(500, 250, 100, 100);

        craft7Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft7Label.setBounds(600, 50, 100, 100);

        craft8Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft8Label.setBounds(600, 150, 100, 100);

        craft9Label = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft9Label.setBounds(600, 250, 100, 100);

        craftedLabel = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(100, 100));
        craft1Label.setBounds(400, 50, 100, 100);

        arrowLabel = new JLabel(new ImageSet("resource/kitchen/craftarrow.png").resize(100, 100));
        arrowLabel.setBounds(750, 150, 100, 100);

        craftedLabel = new JLabel(new ImageSet("resource/kitchen/pointcrafttable.png").resize(150, 150));
        craftedLabel.setBounds(900, 125, 150, 150);

        AxeLabel = new JLabel(new ImageSet("resource/kitchen/AXE.png").resize(150, 150));
        AxeLabel.setBounds(900, 125, 150, 150);
        AxeLabel.setVisible(false);
        AxeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addListener();

        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        drawpane.add(craft1Label);
        drawpane.add(craft2Label);
        drawpane.add(craft3Label);
        drawpane.add(craft4Label);
        drawpane.add(craft5Label);
        drawpane.add(craft6Label);
        drawpane.add(craft7Label);
        drawpane.add(craft8Label);
        drawpane.add(craft9Label);
        drawpane.add(arrowLabel);
        drawpane.add(craftedLabel);
        drawpane.add(AxeLabel);
        drawpane.add(BackLabel);
        checkmatrial();
        contentpane.add(drawpane, BorderLayout.CENTER);

    }

    public void checkmatrial() {
        if (player.getItem(2).getamount() == 2) {
            woodLabel1 = new JLabel(new ImageSet("resource/kitchen/wood.png").resize(100, 100));
            woodLabel1.setBounds(500, 150, 100, 100);

            woodLabel2 = new JLabel(new ImageSet("resource/kitchen/wood.png").resize(100, 100));
            woodLabel2.setBounds(400, 250, 100, 100);

            drawpane.add(woodLabel1);
            drawpane.add(woodLabel2);

            craft3Label.setVisible(false);
            craft5Label.setVisible(false);

        }
        if (player.getItem(3).getamount() == 3) {
            ironLabel1 = new JLabel(new ImageSet("resource/kitchen/iron.png").resize(100, 100));
            ironLabel1.setBounds(500, 50, 100, 100);

            ironLabel2 = new JLabel(new ImageSet("resource/kitchen/iron.png").resize(100, 100));
            ironLabel2.setBounds(600, 50, 100, 100);

            ironLabel3 = new JLabel(new ImageSet("resource/kitchen/iron.png").resize(100, 100));
            ironLabel3.setBounds(600, 150, 100, 100);

            drawpane.add(ironLabel1);
            drawpane.add(ironLabel2);
            drawpane.add(ironLabel3);

            craft4Label.setVisible(false);
            craft7Label.setVisible(false);
            craft8Label.setVisible(false);

        }
        if (player.getItem(2).getamount() == 2 && player.getItem(3).getamount() == 3) {
            AxeLabel.setVisible(true);
            craftedLabel.setVisible(false);
        }
    }

    public void addListener() {
        AxeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                player.getItem(2).setamount(0);
                player.getItem(3).setamount(0);
                player.lostitem(2);
                player.lostitem(3);
                player.pickItem(4);
                JOptionPane.showMessageDialog(null,
                        "You get AXE");

                craft3Label.setVisible(true);
                craft4Label.setVisible(true);
                craft5Label.setVisible(true);
                craft7Label.setVisible(true);
                craft8Label.setVisible(true);
                craftedLabel.setVisible(true);
                AxeLabel.setVisible(false);
                ironLabel1.setVisible(false);
                ironLabel2.setVisible(false);
                ironLabel3.setVisible(false);
                woodLabel1.setVisible(false);
                woodLabel2.setVisible(false);

            }
        });
        BackLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                player.getKitchen().Open();

            }
        });
    }
}
