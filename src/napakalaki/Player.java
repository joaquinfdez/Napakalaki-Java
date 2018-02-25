/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;
/**
 *
 * @author JFL
 */
public class Player {
  static int MAXLEVELS = 10;

  private boolean dead = true;
  private String name;
  private int level;
  private boolean canISteal= true;
  private boolean puedeDecrementar = true;

  protected Player enemy;
  private BadConsequence pendingBadConsequence = new BadConsequence( "", 0);
  private ArrayList<Treasure> visibleTreasures = new ArrayList();
  private ArrayList<Treasure> hiddenTreasures = new ArrayList();

  public Player(String n)
  {
    this.name = n;
    this.dead=true;
    this.level=1;
    this.hiddenTreasures= new ArrayList();
    this.visibleTreasures= new ArrayList();
    this.pendingBadConsequence = new BadConsequence( "", 0);
    this.canISteal = true;
  }

  public Player(Player p)
  {
    this.dead = p.getDeath();
    this.name = p.getName();
    this.level = p.getLevels();
    this.pendingBadConsequence = p.getBadConsequence();
    this.visibleTreasures = p.getVisibleTreasures();
    this.hiddenTreasures = p.getHiddenTreasures();
    this.canISteal = p.canISteal();
    this.enemy = p.getEnemy();
  }

  private void bringToLife()
  {
      dead=false;
  }

  public boolean esSectario(){
      return false;
  }

  private boolean canYouGiveMeATreasure()
  {
    boolean puede_ser_robado;
    if (this.enemy.hiddenTreasures.size() == 0) {
      puede_ser_robado = false;
    }
    else
      puede_ser_robado = true;

    return puede_ser_robado;
  }

  private void haveStolen()  //Una vez que haya robado canISteal = false
  {
    if (canISteal) {
      this.canISteal = false;
    }
  }

  public void setEnemy( Player en)
  {
    this.enemy = en;
  }

  public Player getEnemy()
  {
    return this.enemy;
  }
  public boolean canISteal()
  {
    return this.canISteal;
  }

  public int getCombatLevel()
  {
    int realLevel = getLevels();

    for(int i=0;i<this.visibleTreasures.size();i++)
     {
        realLevel += this.visibleTreasures.get(i).getBonus();
     }
     return realLevel;
  }

  private void incrementLevels(int i)
  {
    level += i;
    if (this.level > MAXLEVELS) {
      this.level = MAXLEVELS;
    }
  }
  protected void decrementLevels(int i)
  {
    level -= i;
    if (this.level <= 0) {
      this.level = 1;
    }
  }
  private void setPendingBadConsequence(BadConsequence b)
  {
    pendingBadConsequence = b;
  }

  private void applyPrize(Monster currentMonster)
  {
    int nLevels = currentMonster.getLevelsGained();

    if (nLevels >0)
      incrementLevels(nLevels);

    int nTreasures = currentMonster.getTreasuresGained();

    if (nTreasures >0)  //Si el premio incluye tesoros
    {
      CardDealer dealer = CardDealer.getInstance();

      for (int i=0; i<nTreasures ; i++ ) //Añadimos los tesoros a los tesoros ocultos
      {
        Treasure t = dealer.nextTreasure();
        this.hiddenTreasures.add(t);
      }
    }
  }

  private void applyBadConsequence(BadConsequence bad)
  {
    int nLevels = bad.getLevels(); //Niveles a perder por mal rollo

    this.decrementLevels(nLevels); //Decrementamos dichos niveles

    //Ajustamos el mal rollo, compara con el mal rollo y te avisa de los tesoros que te sobran y que deben ser descartados
    BadConsequence pendiente = bad.adjustToFitTreasureLists(this.visibleTreasures, this.hiddenTreasures);
    this.setPendingBadConsequence(pendiente);
  }

  public boolean canMakeTreasureVisible(Treasure t)
  {
    boolean canMake = true, armorOneHand= false;
    int i, cont = 0;

    TreasureKind tipo = t.getType();
    if (tipo == TreasureKind.bothHand)
    {
      for (i=0; i<visibleTreasures.size() ; i++ )
      {
        //Recorremos todos los tesoros mirando si o bien uno coincide con otro
        //o bien, como ya tenemos un tesoro de dos manos, no puede haber uno de una mano
        if (tipo == visibleTreasures.get(i).getType() || TreasureKind.oneHand == visibleTreasures.get(i).getType())
        {
          canMake = false;
        }
      }
    }
    else if (tipo == TreasureKind.oneHand)
    {
      cont = 0;
      for (i=0; i<visibleTreasures.size() ; i++ )
      {
        if ( TreasureKind.oneHand == visibleTreasures.get(i).getType())
        {
          cont++;
        }
        else if (TreasureKind.bothHand == visibleTreasures.get(i).getType()) {
          canMake = false;
        }
      }
      if (cont >= 2) {
        canMake = false;
      }
    }
    else
    {
      for (i=0; i<visibleTreasures.size() ; i++ ) {
        if (tipo == visibleTreasures.get(i).getType() )
        {
          canMake = false;
        }
      }
    }
    return canMake;
  }

  private Treasure giveMeATreasure()  //Damos el tesoro del enemigo
  {
    int totalTesoros = this.hiddenTreasures.size();
    Random r = new Random();
    int sigIndex = r.nextInt(totalTesoros);

    // Devolvemos el tesoro oculto aleatorio y lo eliminamos de sus tesoros ocultos
    Treasure t = this.enemy.getHiddenTreasures().get(sigIndex);
    this.enemy.getHiddenTreasures().remove(sigIndex);

    return t;
  }
  public String getName()
  {
    return name;
  }

  public boolean makeTreasureVisible(Treasure t)
  {
    boolean canI = canMakeTreasureVisible(t);

    if(canI == true)
    {
      visibleTreasures.add(t);
      hiddenTreasures.remove(t);
    }
    return canI;
  }

  private int howManyVisibleTreasures(TreasureKind tKind){
    int cantidad = 0;
    for (int i=0; i<visibleTreasures.size() ; i++ ) {
      if (visibleTreasures.get(i).getType() == tKind) {
        cantidad++;
      }
    }
    return cantidad;
  }

  public boolean isDead()
  {
    return dead;
  }

  public ArrayList <Treasure> getHiddenTreasures(){
      return hiddenTreasures;
  }
  public ArrayList <Treasure> getVisibleTreasures(){
      return visibleTreasures;
  }

  public boolean getDeath()
  {
    return dead;
  }

  public BadConsequence getBadConsequence()
  {
    return pendingBadConsequence;
  }

  public CombatResult combat(Monster m)
  {
    CombatResult resultado;

    int myLevel = getCombatLevel();
    int monsterLevel = this.getOponentLevel(m);

    //en caso de que Si el nivel de jugador > nivel del monstruo
    if (myLevel > monsterLevel)
    {
      this.applyPrize(m); //Actualizamos el premio del monstruo

      if (this.level >= 10) //Actualizamos el resultado, que puede ser o bien win o win and win game
      {
        resultado = CombatResult.WinGame;
        // Thread.sleep(3000); //Para terminar el juego
        // System.exit(0);
      }
      else
      {
        resultado = CombatResult.Win;
      }

    }
    else //Si el nivel del jugador es <= nivel del monstruo
    {
        if (m.getBadConsequence().getDeath() == true) //Si el monstruo pide la muerte
          this.die();
        else
          this.applyBadConsequence(m.getBadConsequence()); //Aplicamos el mal rollo dado por el monstruo m

        boolean es_convertido = this.shouldConvert(); //Se llama a la funcion shouldConvert(), en la que tiramos el dado y vemos si se convierte en sectario

        if ( es_convertido == true)
          resultado = CombatResult.LoseAndConvert;
        else
          resultado = CombatResult.Lose;
    }
    return resultado;
  }

  protected int getOponentLevel(Monster m)
  {
    return m.getCombatLevel();
  }

  private void die()
  {
    this.setLevel(1); //Si muere, ponemos el nivel a 1
    CardDealer dealer = CardDealer.getInstance();

    //Lo dejamos sin tesoros ocultos y visibles marcandolos como tesoros usados
    for (int i=0; i<visibleTreasures.size() ; i++ ) {
      dealer.giveTreasureBack(visibleTreasures.get(i));
    }
    for (int i=0; i<hiddenTreasures.size() ; i++ ) {
      dealer.giveTreasureBack(hiddenTreasures.get(i));
    }

    //Una vez marcados todos los tesoros como usados, vamos a vaciar los dos arrays de tesoros visibles y ocultos
    visibleTreasures.clear();
    hiddenTreasures.clear();

    //Llamamos a la funcion dieIfNoTreasures que se encarga de marcar al jugador como muerto al no tener tesoros
    this.dieIfNoTreasures();
  }

  public void discardVisibleTreasure(Treasure t)
  {
    visibleTreasures.remove(t);

    //Eliminamos todo el mal rollo pendiente (si es que lo hay)
    if ((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())) {
      this.pendingBadConsequence.substractVisibleTreasure(t);
    }
    this.dieIfNoTreasures();
  }

  public void discardHiddenTreasure(Treasure t)
  {
    hiddenTreasures.remove(t);

    if ((pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())) {
      pendingBadConsequence.substractHiddenTreasure(t);
    }
    this.dieIfNoTreasures();
  }

  private void dieIfNoTreasures()
  {
    if (visibleTreasures.size()==0 && hiddenTreasures.size()==0)
      dead=true;
    else
      dead = false;
  }

  public void discardAllTreasures()
  {
    Treasure t = null;
    for (int i=0; i<this.visibleTreasures.size() ; i++ ) {
      t = this.visibleTreasures.get(i);
      this.discardVisibleTreasure(t);
    }
    for (int i=0; i<this.hiddenTreasures.size(); i++ ) {
      t = this.hiddenTreasures.get(i);
      this.discardHiddenTreasure(t);
    }
  }

  // Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir
  // y no tiene más de 4 tesoros
  public boolean validState()
  {
    if ((this.pendingBadConsequence.isEmpty()==true)  && (this.hiddenTreasures.size()<= 4)) {
      return true;
    }
    else
      return false;
  }

  public void initTreasures()
  {
    CardDealer dealer = CardDealer.getInstance();
    this.bringToLife();//Devuelve a la vida si el jugador esta muerto
    int number = Dice.getInstance().nextNumber();

    if (number == 1) //Si sale 1 roba un tesoro
    {
      Treasure t = dealer.nextTreasure();
      hiddenTreasures.add(t);
    }
    else if (number > 1 && number < 6) //Si no 2 tesoros
    {
      for (int i=0; i<2 ; i++ ) {
        Treasure t = dealer.nextTreasure();
        hiddenTreasures.add(t);
      }
    }
    else //Si no 3 tesoros
    {
      for (int i=0; i<3 ; i++ ) {
        Treasure t = dealer.nextTreasure();
        hiddenTreasures.add(t);
      }
    }
  }

  public Treasure stealTreasure()
  {
    boolean canI = canISteal();
    boolean canYou;
    Treasure t = null;

    if (canI) {
      canYou = canYouGiveMeATreasure();
      if (canYou) {
        t = giveMeATreasure();
        this.hiddenTreasures.add(t);
        this.haveStolen();
      }
    }

    return t;
  }

  public int getLevels(){
    return level;
  }

  private void setLevel(int l) {
    this.level = l;
  }

  protected boolean shouldConvert()
  {
    int number = Dice.getInstance().nextNumber();
    if (number == 1) {
      return true;
    }
    else
    {
      return false;
    }
  }
  // public String rellenaCampo()
  // {
  //   return "NO";
  // }

  @Override
  public String toString(){
      return "Name: " + name +"\n"+ "Level= " + Integer.toString(level)+"\n"+"Nivel de combate= "+Integer.toString(this.getCombatLevel());

  }

  //EXAMEN
  public int decrementaNivelesEnemigo(ArrayList<Treasure> t)
  {
    //Decrementamos niveles
    int suma = 0;
    //Acumulamos bonus de los tesoros
    for (int i=0; i< t.size() ; i++ ) {
      suma = suma + t.get(i).getBonus();
    }
    if (suma >4) {
      suma = 4;
    }

    CardDealer dealer = CardDealer.getInstance();
    for (int i= 0; i<t.size() ; i++ ) {
      //Lo devolvemos
      dealer.giveTreasureBack(t.get(i));
      //Lo eliminamos de nuestros tesoros ocultos
      discardHiddenTreasure(t.get(i));
    }

    //Solo puede robar una vez en la partida
    this.puedeDecrementar =  false;
    return suma;
  }

  public void decrementaNiveles(ArrayList<Treasure> t)
  {
    int suma = decrementaNivelesEnemigo(t);
    this.enemy.decrementLevels(suma);
  }

  public boolean puedeDecrementarNiveles()
  {
    return this.puedeDecrementar;
  }
  // FIN EXAMEN
}
