package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author JFL
 */
public class BCDeath extends BadConsequence {

    private boolean death;

    public BCDeath(String text, boolean d){
        super(text, 0);
        this.death = d;
    }

    @Override
    public boolean getDeath()
    {
      return this.death;
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> vTreasures, ArrayList<Treasure> hTreasures) {
        return this;
    }


    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void substractVisibleTreasure(Treasure t) {

    }

    @Override
    public void substractHiddenTreasure(Treasure t) {
    
    }

    @Override
    public String toString(){
        return getText() + "\n\tdeath = " + Boolean.toString(death);
    }
}
