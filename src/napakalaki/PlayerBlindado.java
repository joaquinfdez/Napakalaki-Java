/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author JFL
 */
public class PlayerBlindado extends Player {

    public PlayerBlindado(Player p) {
        super(p);
    }

    @Override
    public boolean canMakeTreasureVisible(Treasure t) {
        boolean canMake = true;
        TreasureKind tipo = t.getType();

        //En el caso de que no sea una armadura, comprobamos si se puede equipar
        if (tipo != TreasureKind.armor) {
            canMake = super.canMakeTreasureVisible(t);
        }

        return canMake;
    }

    public int decrementaNivelesDeTipoArmadura(ArrayList<Treasure> t)
    {
      int numTesorosDeTipoArmor = 0;

      for (int i=0; i<t.size() ; i++ ) {
        if (t.get(i).getType() == TreasureKind.armor) {
          numTesorosDeTipoArmor += 1;
        }
      }
      return numTesorosDeTipoArmor;
    }

    @Override
    public void decrementaNiveles(ArrayList<Treasure> t)
    {
      int numTesorosDeTipoArmor = decrementaNivelesDeTipoArmadura(t);
      //Decrementamos los que por defecto se decrementan más nuestro número de armaduras
      int suma = super.decrementaNivelesEnemigo(t) + numTesorosDeTipoArmor;
      this.enemy.decrementLevels(suma);
    }

    @Override
    public int getCombatLevel()
    {
        //Numero de tesoros equipados (visibles) que tiene de tipo armor
      int numTesorosDeTipoArmor = 0;
      for (int i=0; i< getVisibleTreasures().size() ; i++ ) {
        if (getVisibleTreasures().get(i).getType() == TreasureKind.armor) {
          numTesorosDeTipoArmor += 1;
        }
      }
      //El nivel es el del player más el número de tesoros de tipo armadura por dos
      int suma = super.getCombatLevel() + (numTesorosDeTipoArmor*2);

      return suma;
    }
}
