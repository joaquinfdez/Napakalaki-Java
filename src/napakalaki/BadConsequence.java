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
public class BadConsequence {
  private String text;
  private int levels;
  static int MAXTREASURES = 10;

  public BadConsequence(String text, int levels){
      this.text = text;
      this.levels = levels;
  }

  public  BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> vTreasures, ArrayList<Treasure> hTreasures)
  {
    return (new BadConsequence("", 0));
  }

  public boolean isEmpty()
  {
    return true;
  }

  public void substractVisibleTreasure(Treasure t)
  {
  }

  public void substractHiddenTreasure(Treasure t)
  {
  }

  public boolean getDeath()
  {
    return false;
  }

  public String getText(){
      return text;
  }

  public int getLevels(){
      return levels;
  }

  @Override
  public String toString(){
      return text;
  }

  // ******************************************************************************
  //*********** Implementacion para PendingBadConsequenceView ********************
  // ******************************************************************************

  public int PendingVisibles(){
      return 0;
  }

  public int PendingOcultos(){
      return 0;
  }

  public int PendingEspecificoVisible(TreasureKind tk){
      return 0;
  }

  public int PendingEspecificoOculto(TreasureKind tk){
      return 0;
  }
}
