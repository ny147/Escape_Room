import Room.Start;
/*Thitiwut   Marawang  	    6213126
Weerawich  Wongchatchalikun 6213166
Siralak    Teekha           6213133
Kantapat   Thienthanawint   6213194*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static sun.net.www.http.HttpClient.New;

public class MainApplication {
        
    public static void main(String args[]) {
        Start game =  new Start();
        game.setVisible(true);
        game.playMusic();
    }
        
}
