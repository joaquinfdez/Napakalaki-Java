/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
/**
 *
 * @author JFL
 */
public class CardDealer {
    private static final CardDealer instance =new CardDealer();
    private ArrayList <Treasure> unusedTreasures = new ArrayList();
    private ArrayList <Treasure> usedTreasures= new ArrayList();
    private ArrayList <Monster> usedMonsters= new ArrayList();
    private ArrayList <Monster> unusedMonsters= new ArrayList();
    private ArrayList <Cultist> unusedCultist = new ArrayList();

    private CardDealer() { }

    public CardDealer(ArrayList<Monster> unusedMonsters, ArrayList<Monster> usedMonsters, ArrayList<Treasure> usedTreasures, ArrayList<Treasure> unusedTreasures) {
        this.unusedMonsters = unusedMonsters;
        this.usedMonsters = usedMonsters;
        this.usedTreasures = usedTreasures;
        this.unusedTreasures = unusedTreasures;
    }

    public static CardDealer getInstance()
    {
        return instance;
    }

    public void initTreasureCardDeck()
    {
      Treasure t;
      t = new Treasure ("¡Si mi amo!", 4, TreasureKind.helmet);
      unusedTreasures.add(t);

      t = new Treasure ("Botas de investigacion", 3, TreasureKind.shoe);
      unusedTreasures.add(t);

      t = new Treasure ("Capucha de Cthulhu", 3, TreasureKind.helmet);
      unusedTreasures.add(t);

      t = new Treasure ("A prueba de babas", 2, TreasureKind.armor);
      unusedTreasures.add(t);

      t = new Treasure ("Botas de lluvia acida",1 , TreasureKind.bothHand);
      unusedTreasures.add(t);

      t = new Treasure ("Casco minero", 2, TreasureKind.helmet);
      unusedTreasures.add(t);

      t = new Treasure ("Ametralladora Thompson",  4, TreasureKind.bothHand);
      unusedTreasures.add(t);

      t = new Treasure ("Camiseta de la UGR", 1, TreasureKind.armor);
      unusedTreasures.add(t);

      t = new Treasure ("Clavo de rail ferroviario", 3, TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("Cuchillo de sushi arcano", 2, TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("Fez alopodo", 3,TreasureKind.helmet);
      unusedTreasures.add(t);

      t = new Treasure ("Hacha prehistorica", 2,TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("El aparato del Pr. Tesla", 4, TreasureKind.armor);
      unusedTreasures.add(t);

      t = new Treasure ("Gaita", 4, TreasureKind.bothHand);
      unusedTreasures.add(t);

      t = new Treasure ("Insecticida", 2, TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("Escopeta de 3 cañones", 4, TreasureKind.bothHand);
      unusedTreasures.add(t);

      t = new Treasure ("Garabato mistico", 2, TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("La rebeca metalica", 2, TreasureKind.armor);
      unusedTreasures.add(t);

      t = new Treasure ("Mazo de los antiguos", 3, TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("Necro playboycon", 3, TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("Lanzallamas", 4, TreasureKind.bothHand);
      unusedTreasures.add(t);

      t = new Treasure ("Necro comicon", 1,  TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("Necronomicon", 5,  TreasureKind.bothHand);
      unusedTreasures.add(t);

      t = new Treasure ("Linterna a 2 manos", 3, TreasureKind.bothHand);
      unusedTreasures.add(t);

      t = new Treasure ("Necro-gnomicon", 2, TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("Necrotelecom", 2,TreasureKind.helmet);
      unusedTreasures.add(t);

      t = new Treasure ("Porra preternatural", 2,  TreasureKind.oneHand);
      unusedTreasures.add(t);

      t = new Treasure ("Tentaculo de pega", 2, TreasureKind.helmet);
      unusedTreasures.add(t);

      t = new Treasure ("Zapato deja-amigos", 1, TreasureKind.shoe);
      unusedTreasures.add(t);

      t = new Treasure ("Shogulador", 1, TreasureKind.bothHand);
      unusedTreasures.add(t);

      t = new Treasure ("Varita de atizamiento", 3, TreasureKind.oneHand);
      unusedTreasures.add(t);

      this.shuffleTreasures();
    }

    private void initMonsterCardDeck()
    {
      BadConsequence bc; //Variable auxiliar
      Prize pc; //Variable auxiliar
      Monster m; //Variable auxiliar

      //Para añadir un arrays de piezas: new ArrayList(Arrays.asList(TreasureKind.oneHand, TreasureKind.oneHand, TreasureKind.bothHand))

      bc = new BCSpecific("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList(Arrays.asList(TreasureKind.armor)));
      pc = new Prize( 2, 1);
      m = new Monster( "3 Byakhees de bonanza", 8, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.helmet)), new ArrayList());
      pc = new Prize( 1, 1);
      m = new Monster( "Chibithulhu", 2, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.shoe)), new ArrayList());
      pc = new Prize( 1, 1);
      m = new Monster( "El sopor de Dunwich", 2, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList(Arrays.asList(TreasureKind.oneHand)));
      pc = new Prize( 4, 1);
      m = new Monster( "Angeles de la noche ibicenca",14, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCNumeric("Pierdes todos tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
      pc = new Prize( 3, 1);
      m = new Monster( "El gorron en el umbral", 10, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
      pc = new Prize( 2, 1);
      m = new Monster( "H.P. Munchcraft", 6, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
      pc = new Prize( 1, 1);
      m = new Monster( "Bichgooth", 2, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCNumeric("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
      pc = new Prize(4, 2);
      m = new Monster( "El rey de rosa", 13, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCNumeric("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
      pc = new Prize( 1, 1);
      m = new Monster( "La que redacta en las tinieblas", 2, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
      pc = new Prize( 2, 1);
      m = new Monster( "Los hondos", 8, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCNumeric("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
      pc = new Prize( 2, 1);
      m = new Monster( "Semillas Cthulhu", 4, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList( Arrays.asList(TreasureKind.oneHand)), new ArrayList());
      pc = new Prize( 2, 1);
      m = new Monster( "Dameargo", 1, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCNumeric("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
      pc = new Prize( 1, 1);
      m = new Monster( "Pollipolipo volante", 3, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
      pc = new Prize( 3, 1);
      m = new Monster( "YskhtihyssgGoth", 12, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCDeath("La familia te atrapa. Estas muerto", true );
      pc = new Prize( 4, 1);
      m = new Monster( "Familia feliz", 1, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de 2 manos visibles", 2, new ArrayList(Arrays.asList(TreasureKind.bothHand)), new ArrayList()  );
      pc = new Prize( 2, 1);
      m = new Monster( "Roboggoth", 8, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.helmet)), new ArrayList() );
      pc = new Prize( 1, 1);
      m = new Monster( "El espia", 5, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCNumeric("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0 );
      pc = new Prize( 1, 1);
      m = new Monster( "El lenguas", 20, bc, pc);
      this.unusedMonsters.add(m);

      bc = new BCSpecific("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
              new ArrayList(Arrays.asList(TreasureKind.oneHand, TreasureKind.oneHand, TreasureKind.bothHand)), new ArrayList() );
      pc = new Prize( 4, 1);
      m = new Monster( "Bicefalo", 20, bc, pc);
      this.unusedMonsters.add(m);

      // ***********************************************************************************************************************************************
      // *********************************MONSTRUOS SECTARIOS*******************************************************************************************
      // ***********************************************************************************************************************************************

      bc = new BCSpecific("Pierdes 1 mano visible", 10, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList() );
      pc = new Prize( 3, 1);
      m = new Monster( "El mal indecible impronunciable", 10, bc, pc, -2);
      this.unusedMonsters.add(m);

      bc = new BCNumeric("Pierdes tus tesoros visibles.Jajaja", 6,  BadConsequence.MAXTREASURES, 0);
      pc = new Prize( 2, 1);
      m = new Monster( "Testigos Oculares", 6, bc, pc, 2);
      this.unusedMonsters.add(m);

      bc = new BCDeath("Hoy no es tu día. Mueres.", true);
      pc = new Prize(2,  5);
      this.unusedMonsters.add(new Monster("El gran cthulhu", 20, bc, pc, 4));

      bc = new BCNumeric("Tu gobierno te recorta dos niveles", 2, 0, 0);
      pc = new Prize(2, 1);
      this.unusedMonsters.add(new Monster("Serpiente politico", 8, bc, pc, -2));

      bc = new BCSpecific("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",
              0,
              new ArrayList(Arrays.asList(TreasureKind.armor, TreasureKind.helmet)),
              new ArrayList(Arrays.asList(TreasureKind.oneHand, TreasureKind.oneHand, TreasureKind.bothHand)));
      pc = new Prize(1, 1);
      this.unusedMonsters.add(new Monster("Felpuggoth", 2, bc, pc, 5));

      bc = new BCNumeric("Pierdes 2 niveles", 2, 0, 0);
      pc = new Prize(4, 2);
      this.unusedMonsters.add(new Monster("Shoggoth", 16, bc, pc, -4));

      bc = new BCNumeric("Pintalabios negro. Pierdes dos niveles", 2, 0, 0);
      pc = new Prize(1, 1);
      this.unusedMonsters.add(new Monster("Lolitagooth", 2, bc, pc, 3));

      this.shuffleMonsters();
    }

    private void initCultistCardDeck()
    {
      unusedCultist = new ArrayList();

      unusedCultist.add(new Cultist("Sectario 1", 1));
      unusedCultist.add(new Cultist("Sectario 2", 2));
      unusedCultist.add(new Cultist("Sectario 3", 1));
      unusedCultist.add(new Cultist("Sectario 4", 2));
      unusedCultist.add(new Cultist("Sectario 5", 1));
      unusedCultist.add(new Cultist("Sectario 6", 1));

      shuffleCultist();
    }

    public void initCards()
    {
      initMonsterCardDeck();
      initTreasureCardDeck();
      initCultistCardDeck();
    }

    private void shuffleTreasures()
    {
        Collections.shuffle(unusedTreasures);
    }

    private void shuffleMonsters()
    {
        Collections.shuffle(unusedMonsters);
    }

    private void shuffleCultist()
    {
        Collections.shuffle(unusedCultist);
    }

    public void giveTreasureBack(Treasure t)
    {
      this.usedTreasures.add(t);
    }

    public void giveMonsterBack(Monster m)
    {
      this.usedMonsters.add(m);
    }
    public Treasure nextTreasure()
    {
      Treasure t;
      if (this.unusedTreasures.isEmpty() == true) //Si está vacio lo volvemos a rellenar
      {
        for (int i=0; i < this.usedTreasures.size() ; i++ ) {
          this.unusedTreasures.add(this.usedTreasures.get(i));
        }

        this.usedTreasures.clear();//Vaciamos el mazo de tesoros usados
        shuffleTreasures();//Llamamos a la funcion para barajar los unusedTreasures
      }
      t = this.unusedTreasures.get(0);
      this.unusedTreasures.remove(0);

      this.usedTreasures.add(t);//Lo metemos en los usados

      return t;
    }
    public Monster nextMonster()
    {
      Monster m;
      if (this.unusedMonsters.isEmpty() == true) //Si está vacio
      {
        for (int i=0; i < this.usedMonsters.size() ; i++ ) {
          this.unusedMonsters.add(this.usedMonsters.get(i));
        }
        this.usedMonsters.clear();//Vaciamos el mazo de tesoros usados
        shuffleMonsters();//Llamamos a la funcion para barajar los unusedTreasures
      }
      m = this.unusedMonsters.get(0);
      this.usedMonsters.add(m);
      this.unusedMonsters.remove(0);
      return m;
    }

    public Cultist nextCultist()
    {
      if (unusedCultist.isEmpty()) //Si la lista de Cultist esta vacia, lo rellenamos de nuevo
      {
        initCultistCardDeck();
        shuffleCultist();
      }
      Cultist c = unusedCultist.get(0); //Damos el primero de la pila
      unusedCultist.remove(0);
      return c;
    }
}
