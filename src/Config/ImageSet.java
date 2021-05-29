package Config;

import java.awt.Image;
import javax.swing.ImageIcon;


public class ImageSet extends ImageIcon {
     public  ImageSet(String fname) {
        super(fname);
    }

    public  ImageSet(Image image) {
        super(image);
    }

   

    public  ImageSet resize(int width, int height) {
        Image oldimg = this.getImage();
        Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageSet(newimg);
    }

    
}
