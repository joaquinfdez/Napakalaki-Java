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
public class Treasure {
  private String name;
  private int bonus;
  private TreasureKind type;

  public Treasure (String n, int b, TreasureKind t)
  {
    this.name = n;
    this.bonus = b;
    this.type = t;
  }
  public String getName()
  {
    return name;
  }

  public int getBonus()
  {
    return bonus;
  }

  public TreasureKind getType()
  {
    return type;
  }
  @Override
  public String toString(){
      return "Name: " + name +"\t"+ "Bonus= "+Integer.toString(bonus)+"\t"+"treasureKind= "+ this.type;
  }

}
