package Room;


import Item_Feather.Player;
import Config.ImageSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class OurFrame extends JFrame {

    private int frameWidth = 1366, frameHeight = 768;
    protected JLabel drawpane, playerpane;
    protected Player player;
    protected JPanel contentpane, Setpane, Playerpane;
    protected JMenuItem on, off;
    protected JMenuBar menubar;
    protected JMenu music;
 
    private boolean isplaying;

    public OurFrame(String s, Player p) {
        
        addmenu();
        player = p;
        setTitle(s);
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        setVisible(false);
        setLocationRelativeTo(null); // set middle Display
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageSet("resource/Icon/logo.png").getImage());
        contentpane = (JPanel) getContentPane();
        isplaying = true;
 
        
    }

    public void Open() {
        setVisible(true);
        player.clearradiofocus();

        contentpane.add(player.getPane(), BorderLayout.PAGE_START);

        validate();

    }

    public void addmenu() {
        on = new JMenuItem("on");
        off = new JMenuItem("off");
        menubar = new JMenuBar();

        music = new JMenu("music");
        music.add(on);
        music.add(off);

        menubar.add(music);

        add(menubar);
        setJMenuBar(menubar);
        try {
            on.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == on) {
                        if (isplaying) {
                            player.getRoomSound().stop();

                        } else {
                            player.getRoomSound().playLoop();
                        }

                    }
                }
            });
            off.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == off) {
                        isplaying = false;
                        player.getRoomSound().stop();

                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
   
    public void addpuzzle() {
        /*add puzzle event*/
    }

    public void addcomponent() {
        /* add for your JLabel JPanel */
    }

    public void addmusic() {/*add music*/
    }

    public void addListener() {
        /* add your Event */
    }
}
