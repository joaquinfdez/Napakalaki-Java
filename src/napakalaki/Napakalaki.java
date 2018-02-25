/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import GUI.Dice;
/**
 *
 * @author JFL
 */
public class Napakalaki
{
     public static final Napakalaki instance = new Napakalaki();
     private Player currentPlayer = new Player("") ;
     private ArrayList<Player> players = new ArrayList ();
     private Monster currentMonster;
     private CardDealer dealer = CardDealer.getInstance();

    // El constructor privado asegura que no se puede instanciar desde otras clases
    private Napakalaki()
    {
     this.currentPlayer = null;
     this.currentMonster = null;
    }

    public static Napakalaki getInstance()
    {
      return instance;
    }

    private void initPlayers (ArrayList <String> names)
    {
      this.players = new ArrayList();
      for (int i=0; i< names.size() ; i++ ) {
        Player p = new Player (names.get(i));
        players.add(p);
      }
    }

    private Player nextPlayer()
    {
      int sigIndex, totalJugadores, currentPlayerIndex;

      totalJugadores = players.size();

      if(this.currentPlayer == null) // El jugador que comienza el juego se decide al azar, y después se sigue el orden de las agujas del reloj.
      {
          Random r = new Random();
          sigIndex = r.nextInt(totalJugadores);
      }
      else
      {
          currentPlayerIndex = players.indexOf(this.currentPlayer); // Devuelve la posicion del jugador currentPlayer

          if(currentPlayerIndex == totalJugadores-1)
              sigIndex = 0;
          else
              sigIndex = currentPlayerIndex+1;
      }

      Player nextPlayer = players.get(sigIndex);
      this.currentPlayer = nextPlayer;

      return this.currentPlayer;
    }

    private boolean nextTurnIsAllowed ()
    {
       boolean aux;
       if (this.currentPlayer == null) {
        aux = true;
      }
       else
       {
         // Miramos si el jugador actual se ha descartado cartas ( en el caso de superar el numero de cartas ocultas)
         // y miramos tambien si ha cumplido el mal rollo. De esto se encarga validState()
         aux = this.currentPlayer.validState();
       }
       return aux;
    }

    private void setEnemies()
    {
      int totalJugadores = this.players.size();
      int indiceDelEnemigo;
      for (int i=0; i< this.players.size() ; i++ ) {
        Random r = new Random();
        indiceDelEnemigo = r.nextInt(totalJugadores);

        //Comprobamos que el playerEnemigo no sea el mismo, en el caso
        // de que lo fuera, decrementamos el indice de la variable para que señale a otro jugador
        while (this.players.get(indiceDelEnemigo) == this.players.get(i))
        {
          indiceDelEnemigo = r.nextInt(totalJugadores);
        }
        // Asignamos el jugadorEnemigo apuntado por el indiceDelEnemigo al array de players
        Player p = this.players.get(indiceDelEnemigo);
        this.players.get(i).setEnemy(p);
      }
    }

    public CombatResult developCombat ()
    {
        CombatResult resultado = this.currentPlayer.combat(this.currentMonster);
        this.dealer.giveMonsterBack(this.currentMonster); // Añadimos el mostruo al mazo de monstruos usados

        if (resultado == CombatResult.LoseAndConvert) {
          Cultist carta = dealer.nextCultist();
          CultistPlayer cultistP = new CultistPlayer(carta, this.currentPlayer);

          //Actualizamos el array de players con el jugador CultistPlayer
          int currentPlayerIndex = this.players.indexOf(this.currentPlayer);
          this.players.set(currentPlayerIndex, cultistP);

          //Actualizamos el jugador actual
          this.currentPlayer = cultistP;
        }
        return resultado;
    }

    public void discardVisibleTreasures (ArrayList <Treasure> treasures) // Elimina los tesoros visibles indicados por treasures
    {
      for (int i=0 ; i<treasures.size() ; i++ ) {
        this.currentPlayer.discardVisibleTreasure(treasures.get(i)); //descarta los tesoros visible del jugador actual
        this.dealer.giveTreasureBack( treasures.get(i) ); //Los marca como tesoros usados
      }
    }

    public void discardHiddenTreasures (ArrayList <Treasure> treasures)
    {
      for (int i=0 ; i<treasures.size() ; i++ ) {
        this.currentPlayer.discardHiddenTreasure(treasures.get(i)); //descarta los tesoros ocultos del jugador actual
        this.dealer.giveTreasureBack( treasures.get(i) ); //Los marca como tesoros usados
      }
    }
    public void makeTreasuresVisible (ArrayList <Treasure> treasures)
    {
      for (int i=0; i<treasures.size() ; i++ ) {
        this.currentPlayer.makeTreasureVisible(treasures.get(i));
      }
    }

    public void initGame(ArrayList<String> names){
        initPlayers(names);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    public Player getCurrentPlayer ()
    {
      return this.currentPlayer;
    }

    public Monster getCurrentMonster ()
    {
      return this.currentMonster;
    }

    public boolean nextTurn ()
    {
      boolean stateOK = false, dead;

      stateOK = nextTurnIsAllowed(); //Si esta permitido el paso del actual jugador, actualizamos un nuevo monstruo y nuevo jugador

      if (stateOK == true)
      {
        this.currentMonster = this.dealer.nextMonster();
        this.currentPlayer = nextPlayer();

        dead = this.currentPlayer.isDead(); //si está muerto el jugador inicialiamos sus tesoros
        if (dead)
          this.currentPlayer.initTreasures();
      }
      return stateOK;
    }

    public boolean endOfGame (CombatResult result)
    {
      return (result == CombatResult.WinGame);
    }


  }
