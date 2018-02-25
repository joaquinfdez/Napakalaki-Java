package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author JFL
 */
public class BCNumeric extends BadConsequence {

    private int nVisibleTreasures;
    private int nHiddenTreasures;

    public BCNumeric(String text, int level, int vT, int hT){
        super(text, level);
        this.nVisibleTreasures = vT;
        this.nHiddenTreasures = hT;
    }

    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }

    @Override
    public boolean getDeath() {
        return false;
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)
    {
      int aCumplirVisible=0;
      int aCumplirOculto=0;
      BadConsequence b = null;

      if (this.nVisibleTreasures < v.size())
        aCumplirVisible = this.nVisibleTreasures;
      else
        aCumplirVisible = v.size();

      if (this.nHiddenTreasures < h.size())
        aCumplirOculto = this.nHiddenTreasures;
      else
        aCumplirOculto = h.size();

      b = new BCNumeric("MalRoyoACumplir",0, aCumplirVisible, aCumplirOculto);//creación de Badconsequence
      return b;
    }

    @Override
    public boolean isEmpty() {
        return (this.nVisibleTreasures == 0 && this.nHiddenTreasures == 0);
    }

    @Override
    public void substractVisibleTreasure(Treasure t) {
        this.nVisibleTreasures--;
        if (this.nVisibleTreasures < 0) {
          this.nVisibleTreasures = 0;
        }
    }

    @Override
    public void substractHiddenTreasure(Treasure t) {
        this.nHiddenTreasures--;

        if (this.nHiddenTreasures < 0) {
          this.nHiddenTreasures = 0;
        }
    }

    @Override
    public String toString(){
        return getText() + "\n\tnVisibleTreasures = " + Integer.toString(nVisibleTreasures) +
      "\n\tnHiddenTreasures = " + Integer.toString(nHiddenTreasures);
    }

    // ******************************************************************************
    // *********** Implementacion para PendingBadConsequenceView ********************
    // ******************************************************************************

    @Override
    public int PendingVisibles(){
      return nVisibleTreasures;
  }

    @Override
  public int PendingOcultos(){
      return nHiddenTreasures;
  }
}
