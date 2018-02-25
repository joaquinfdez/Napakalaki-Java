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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize price;
    private BadConsequence bc;
    private int levelChangeAgainstCultisPlayer;

    public Monster(String name, int level, BadConsequence bc, Prize price)
    {
      this.name = name;
      this.combatLevel = level;
      this.price = price;
      this.bc = bc;
      this.levelChangeAgainstCultisPlayer = 0;
    }

    public Monster(String name, int level, BadConsequence bc, Prize price, int levChang)
  {
    this.name = name;
    this.combatLevel = level;
    this.price = price;
    this.bc = bc;
    this.levelChangeAgainstCultisPlayer=levChang;
  }

    public String getName()
    {
      return name;
    }
    public int getCombatLevel()
    {
      return combatLevel;
    }

    public int getCombatLevelAgainstCultistPlayer()
    {
      return (getCombatLevel() + this.levelChangeAgainstCultisPlayer);
    }
    public BadConsequence getBadConsequence()
    {
      return bc;
    }
    public Prize getPrice()
    {
      return price;
    }

    public int getLevelsGained()
    {
      return price.getLevels();
    }
    public int getTreasuresGained()
    {
      return price.getTreasures();
    }

    @Override
    public String toString()
    {
      return "Name = " + name + "\ncombatLevel = " + Integer.toString(combatLevel) +
              "\nprice = " + price.toString() + " \nBadConsequence = " + bc.toString();
    }
}
