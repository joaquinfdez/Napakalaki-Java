
package napakalaki;

import GUI.Dice;
import GUI.NapakalakiView;
import java.util.ArrayList;
import GUI.PlayerNamesCapture;
//import GUI.PlayersNameCapture;

public class EjemploMain {

    public static void main(String[] args) {
        
        ArrayList<String> names;
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
      
        names = namesCapture.getNames();
        
        game.initGame(names);
        
        napakalakiView.setNapakalaki(game);
        

        
        napakalakiView.setVisible(true);
              
    }
}
