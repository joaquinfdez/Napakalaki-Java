package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author JFL
 */
public class BCSpecific extends BadConsequence {

    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();

    public BCSpecific(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        super(text, levels);
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }

    @Override
    public boolean getDeath() {
        return false;
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        ArrayList<TreasureKind> malRoyoVisible = new ArrayList();
        ArrayList<TreasureKind> malRoyoOculto = new ArrayList();
        BadConsequence b = new BadConsequence("", 0);

        if (this.specificVisibleTreasures.size() != 0)
        {
            for (int i = 0; i < v.size(); i++) {
                if (this.specificVisibleTreasures.contains(v.get(i).getType())) {
                    int pos = this.specificVisibleTreasures.indexOf(v.get(i).getType());
                    malRoyoVisible.add(v.get(pos).getType());
                }
            }

        }

        if (this.specificHiddenTreasures.size() != 0) {
            for (int i = 0; i < h.size(); i++) {
                if (this.specificHiddenTreasures.contains(h.get(i).getType())) {
                    int pos = this.specificHiddenTreasures.indexOf(h.get(i).getType());
                    malRoyoOculto.add(h.get(pos).getType());
                }
            }
        }

        b = new BCSpecific("MalRoyoACumplir", 0, malRoyoVisible, malRoyoOculto);//creación de Badconsequence
        return b;
    }

    @Override
    public boolean isEmpty() {
        return (specificHiddenTreasures.size() == 0 && specificVisibleTreasures.size() == 0);
    }

    @Override
    public void substractVisibleTreasure(Treasure treasure) {
        if (!this.specificVisibleTreasures.isEmpty()) {
            this.specificVisibleTreasures.remove(treasure.getType());
        }
    }

    @Override
    public void substractHiddenTreasure(Treasure treasure) {
        if (!this.specificHiddenTreasures.isEmpty()) {
            this.specificHiddenTreasures.remove(treasure.getType());
        }
    }

    @Override
    public String toString() {
        return getText() + "\n\tspecificHiddenTreasures = " + specificHiddenTreasures
                + "\n\tspecificVisibleTreasures = " + specificVisibleTreasures;
    }

    // **************************************************
    // Implementacion para PendingPabConsequenceView
    // **************************************************
    @Override
    public int PendingEspecificoVisible(TreasureKind tk) {

        int contador = 0;

        for (int i = 0; i < specificVisibleTreasures.size(); i++) {
            if (this.specificVisibleTreasures.get(i) == tk) {
                contador++;
            }
        }

        return contador;
    }

    // **************************************************
    // Implementacion para PendingPabConsequenceView
    // **************************************************
    @Override
    public int PendingEspecificoOculto(TreasureKind tk) {

        int contador = 0;

        for (int i = 0; i < specificHiddenTreasures.size(); i++) {
            if (this.specificHiddenTreasures.get(i) == tk) {
                contador++;
            }
        }

        return contador;
    }
}
