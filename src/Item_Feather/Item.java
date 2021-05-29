package Item_Feather;


import Config.ImageSet;
import javax.swing.*;


public class Item extends JLabel{

    private String name;
    private ImageSet Img;
    private int amount;
    
    public Item(String n, ImageSet i,int ct) {
        name = n;
        Img = i;
        amount = ct;
        
        this.setIcon(i);
        
    }

   

    public ImageSet getImg() {
        return Img;
    }

    public int getamount() {

        return amount;
    }
    public void setamount(int i){
        amount = i;
    }
    
}
