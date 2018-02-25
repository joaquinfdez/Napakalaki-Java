/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author JFL
 */
public class Prize {
    private int treasures, level;

    public Prize (int t, int l)
    {
        treasures = t;
        level = l;
    }

    public int getTreasures()
    {
      return treasures;
    }
    public int getLevels()
    {
      return level;
    }
    @Override
    public String toString()
    {
      return "\n\tGanas tesoros = " + Integer.toString(treasures) + "\n\tGanas niveles = " + Integer.toString(level);
    }

}
