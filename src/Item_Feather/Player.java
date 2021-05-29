package Item_Feather;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nearu
 */
import Config.ImageSet;
import Item_Feather.Item;
import Item_Feather.Item;
import Config.SoundEffect;
import Room.LivingRoom;
import Room.Kitchen;
import Room.BedRoom;
import Room.BathRoom;
import Room.BathRoom;
import Room.BedRoom;
import Room.Kitchen;
import Room.LivingRoom;
import java.awt.*;
import javax.swing.*;

public class Player {

    private String name;
    private Item[] item;
    private JRadioButton[] radio;
    private JLabel drawpane;
    private ButtonGroup bt;
    private LivingRoom livgroom;
    private BathRoom bathroom;
    private BedRoom bedroom;
    private Kitchen kitchen;
    private ImageSet woodImg, tabeImg,keyImg,axeImg,ironImg,bgImg,tapeblackImg,keyblackImg,axeblackImg,ironblackImg,woodblackImg;
    private SoundEffect roomsound,  openroomsound, locksound, openpopupsound,getItemsound;
    private Ghost ghost;

    public Player(String n) {
        
         name = n;
     
         item = new Item[5];
         radio = new JRadioButton[5];
         ghost = new Ghost();
       
        addmusic();
        addItem();
        addRadioButton();
        addItemcomponent();
        addRoom();
        ghost.start();
        
        
       

    }

    public void addmusic() {

        roomsound = new SoundEffect("music/BGmusic/room.wav");
        openpopupsound = new SoundEffect("music/SoundEffect/item/openpopup.wav");
        locksound = new SoundEffect("music/SoundEffect/item/can't_open.wav");
        openroomsound = new SoundEffect("music/SoundEffect/item/opendoor.wav");
        getItemsound = new SoundEffect("music/SoundEffect/item/getitem.wav");

    }

    public void addRoom() {

        livgroom = new LivingRoom(this);
        bathroom = new BathRoom(this);
        bedroom = new BedRoom(this);
        kitchen = new Kitchen(this);

   
    }

    public void addItem() {
        
        tapeblackImg = new ImageSet("resource/Item/Black/tapeblack.png").resize(64, 64);
        keyblackImg = new ImageSet("resource/Item/Black/keyblack.png").resize(64, 64);
        axeblackImg = new ImageSet("resource/Item/Black/axeblack.png").resize(64, 64);
        ironblackImg = new ImageSet("resource/Item/Black/ironblack.png").resize(64, 64);
        woodblackImg = new ImageSet("resource/Item/Black/woodblack.png").resize(64, 64);
        
       
        woodImg = new ImageSet("resource/Item/Normal/wood.png").resize(64, 64);
        tabeImg = new ImageSet("resource/Item/Normal/tape.png").resize(64, 64);
        keyImg = new ImageSet("resource/Item/Normal/key.png").resize(64, 64);
        ironImg = new ImageSet("resource/Item/Normal/iron.png").resize(64, 64);
        axeImg = new ImageSet("resource/Item/Normal/axe.png").resize(64, 64);

        item[0] = new Item("Key", keyblackImg, 0);
        item[1] = new Item("Tape", tapeblackImg, 0);
        item[2] = new Item("Wood",woodblackImg, 0);
        item[3] = new Item("Iron",ironblackImg, 0);
        item[4] = new Item("Axe", axeblackImg, 0);

    }

    public void addRadioButton() {
        bt = new ButtonGroup();
        radio[0] = new JRadioButton("key");
        radio[1] = new JRadioButton("Tape");
        radio[2] = new JRadioButton("Wood");
        radio[3] = new JRadioButton("Iron");
        radio[4] = new JRadioButton("Axe");
        for (int i = 0; i < 5; i++) {
            bt.add(radio[i]);
        }

    }

    public void clearradiofocus() {
        bt.clearSelection();
    }

    public void addItemcomponent() {
        bgImg = new ImageSet("resource/Player/Playerpanecolor.png").resize(1366, 150);
        Color graycolor = new Color(53, 53, 58);

        drawpane = new JLabel();
        drawpane.setLayout(null);
        drawpane.setIcon(bgImg);

        item[0].setBounds(90, 23, 64, 64);
        radio[0].setBounds(90, 90, 80, 40);

        item[1].setBounds(350, 23, 64, 64);
        radio[1].setBounds(350, 90, 80, 40);

        item[2].setBounds(630, 23, 64, 64);
        radio[2].setBounds(630, 90, 80, 40);

        item[3].setBounds(920, 23, 64, 64);
        radio[3].setBounds(920, 90, 80, 40);

        item[4].setBounds(1190, 23, 64, 64);
        radio[4].setBounds(1190, 90, 80, 40);

        for (int i = 0; i < 5; i++) {

            radio[i].setBackground(graycolor);
            radio[i].setForeground(Color.WHITE);
            drawpane.add(item[i]);
            drawpane.add(radio[i]);
        }

    }

    public JRadioButton getRadio(int i) {
        if (i > 4 || i < 0) {
            return null;
        } else {
            return radio[i];
        }
    }

    public Item getItem(int i) {
        if (i > 4 || i < 0) {
            return null;
        } else {
            return item[i];
        }

    }

    public void pickItem(int number) {
        switch (number) {
            case 0:
                item[0].setIcon(keyImg);
                item[0].setamount(1);
                break;
            case 1:
                item[1].setIcon(tabeImg);
                item[1].setamount(1);
                break;
            case 2:
                item[2].setIcon(woodImg);
                item[2].setamount(2);
                break;
            case 3:
                item[3].setIcon(ironImg);
                item[3].setamount(3);
                break;
            case 4:
                item[4].setIcon(axeImg);
                item[4].setamount(1);
                break;
        }
         getItemsound.playOnce();

    }

    public void lostitem(int number) {
        switch (number) {
            case 0:
                item[0].setIcon(keyblackImg);
                item[0].setamount(0);
                break;
            case 1:
                item[1].setIcon(tapeblackImg);
                item[1].setamount(0);
                break;
            case 2:
                item[2].setIcon(woodblackImg);
                item[2].setamount(0);
                break;
            case 3:
                item[3].setIcon(ironblackImg);
                item[3].setamount(0);
                break;
            case 4:
                item[4].setIcon(axeblackImg);
                item[4].setamount(0);
                break;
        }

    }

   
    public JLabel getPane() {
        return drawpane;
    }

    public LivingRoom getLivingRoom() {
        return livgroom;
    }

    public BathRoom getBathRoom() {
        return bathroom;
    }

    public BedRoom getBedRoom() {
        return bedroom;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public SoundEffect getRoomSound() {
        return roomsound;

    }

    public SoundEffect getOpenRoomSound() {
        return openroomsound;
    }

    public SoundEffect getOpenpopupSound() {
        return openpopupsound;
    }

    public SoundEffect getLockSound() {
        return locksound;
    }
}
