package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author JFL
 */
public class CultistPlayer extends Player {
    private static int totalCultisPlayers=0;
    private Cultist myCultistCard;

    public CultistPlayer (Cultist c, Player p)
    {
      super(p); //Llamamos al constructor de copia de la clase player
      this.myCultistCard = c;
      this.totalCultisPlayers++;
    }

    @Override
    public int getCombatLevel()
    {
      int suma = (int) ((super.getCombatLevel()) + (super.getCombatLevel() * 0.2)  + (this.myCultistCard.getGainedLevels() * this.totalCultisPlayers));

      return suma;
    }

    @Override
    public boolean esSectario(){
        return true;
    }

    @Override
    protected int getOponentLevel(Monster m)
    {
        return m.getCombatLevelAgainstCultistPlayer();
    }

    @Override
    protected boolean shouldConvert()
    {
        return false;
    }

    private Treasure giveMeATreasure()
    {
      int totalTesoros = getVisibleTreasures().size();
      Random r = new Random();
      int sigIndex = r.nextInt(totalTesoros);

      // Devolvemos el tesoro oculto aleatorio y lo eliminamos de sus tesoros ocultos
      Treasure t = getVisibleTreasures().get(sigIndex);
      getVisibleTreasures().remove(sigIndex);

      return t;
    }

    private boolean canYouGiveMeATreasure()
    {
      boolean puede_ser_robado;
      if (getVisibleTreasures().size() == 0) {
        puede_ser_robado = false;
      }
      else
        puede_ser_robado = true;

      return puede_ser_robado;
    }

    public static int getTotalCultistPlayers()
    {
      return totalCultisPlayers;
    }
    // public String rellenaCampo()
    // {
    //   return "Si";
    // }

}
