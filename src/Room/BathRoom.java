package Room;


import Config.ImageSet;
import Item_Feather.Player;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BathRoom extends OurFrame {
    
    private JLabel NoteLabel, CraftLabel, KitchenRoomLabel;
    private ImageSet backgroundImg, NoteImg, CraftImg, DoorImg;
    private Hint NoteHint, CraftHint;
    
    public BathRoom(Player p) {
        super("bathroom", p);
        contentpane.setLayout(new BorderLayout());
        
        addcomponent();
        
    }
    
    @Override
    public void addcomponent() {
        backgroundImg = new ImageSet("resource/BathRoom/background/BGNormal.png").resize(1366, 668);
        NoteImg = new ImageSet("resource/BathRoom/object/Craftplan.png ").resize(272, 164);
        CraftImg = new ImageSet("resource/BathRoom/object/Note.png").resize( 365 ,315);
        DoorImg = new ImageSet("resource/Arrow/Left.png").resize(64, 64);
     
        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        
        NoteLabel = new JLabel(NoteImg);
        NoteLabel.setBounds(30, 100, 272, 164);
        NoteLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        CraftLabel = new JLabel(CraftImg);
        CraftLabel.setBounds(1000,-30, 364 ,315);
        CraftLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        KitchenRoomLabel = new JLabel(DoorImg);
        KitchenRoomLabel.setBounds(0, 0, 64, 64);
        KitchenRoomLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        drawpane.add(NoteLabel);
        drawpane.add(KitchenRoomLabel);
        drawpane.add(CraftLabel);
        
        addListener();
        addpuzzle();
        
        contentpane.add(drawpane, BorderLayout.CENTER);
        contentpane.add(player.getPane(), BorderLayout.PAGE_START);

      
    }

    public void addpuzzle() {
        
        NoteHint = new Hint("Note", player);
        CraftHint = new Hint("Craft", player);
    }

    public void addListener() {
        NoteLabel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                //pt.getItem(0).setIcon(null);
                // new Hint("Note", Bt).setVisible(true);

                setVisible(false);
                
                player.getOpenpopupSound().playOnce();
                
                NoteHint.Open();
                
            }
            
        });
        CraftLabel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                //pt.getItem(0).setIcon(null);
                // new Hint("Note", Bt).setVisible(true);

                setVisible(false);
                
                player.getOpenpopupSound().playOnce();
                
                CraftHint.Open();
            }
            
        });
        KitchenRoomLabel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                
                setVisible(false);
                
                player.getOpenRoomSound().playOnce();
                
                player.getKitchen().Open();
                
            }
            
        });
        
    }
        /*public static void main(String[] args){
        Player Player1 = new Player("Pete");
     
        Player1.getBathRoom().Open();
        }*/
    
}

class Hint extends OurFrame {
    
    private ImageSet HintImg;
    private JLabel HintLabel, BackLabel;
    private String name;
    private ImageSet backgroundImg,BackImg;
    // private BathRoom Bt;

    public Hint(String n, Player p) {
        super("Hint", p);
        name = n;
        contentpane.setLayout(new BorderLayout());
        contentpane.setBackground(Color.DARK_GRAY);
        HintLabel = new JLabel(HintImg);
        
        addcomponent();
    }
    
    public void addcomponent() {
        
         backgroundImg = new ImageSet("resource/BathRoom/background/BGpopup.png").resize(1366, 668);
         BackImg = new ImageSet("resource/Arrow/Left.png").resize(64, 64);
         
        drawpane = new JLabel();
        //drawpane.setBackground(Color.DARK_GRAY);
        drawpane.setLayout(null);
        drawpane.setIcon(backgroundImg);
        
        BackLabel = new JLabel(BackImg);
        BackLabel.setBounds(0, 0, 64, 64);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        
        if (name.equals("Note")) {
            //System.out.println("hello");
            SetNoteImg();
        }
        if (name.equals("Craft")) {
            SetCraftImg();
        }
        
        addListener();
        drawpane.add(HintLabel);
        drawpane.add(BackLabel);        
        
        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();
        
    }
    
    public void addListener() {
        
        BackLabel.addMouseListener(new MouseAdapter() {
            
            public void mousePressed(MouseEvent e) {
               
                setVisible(false);
                player.getBathRoom().Open();
                
            }
            
        });
        
    }
    
    public void SetNoteImg() {
        HintLabel.setIcon(new ImageSet("resource/BathRoom/pop up/Note.png").resize(800, 568));
        HintLabel.setBounds(300, 0, 800, 568);
    }
    
    public void SetCraftImg() {
        HintLabel.setIcon(new ImageSet("resource/BathRoom/pop up/Craft.png").resize(800, 568));
        HintLabel.setBounds(300, 0, 800, 568);
        
    }
    
}
