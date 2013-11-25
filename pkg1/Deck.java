package opdracht.pkg1;
import java.util.Arrays;
import java.util.Random;

/**
 * Een deck met Cards
 * 
 * @author Youri Tjang
 *
 */
public class Deck {
  Card[] cardArray;

  /**
   * Constructor
   */
  Deck(){
    cardArray = new Card[0];
  }

  /**
   * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
   * harten en ruiten.
   */
  public void fillDeck() {
      cardArray = new Card[52];
      
      cardArray[0] = new Card("Klaver", "2", 0);
      cardArray[1] = new Card("Klaver", "3", 1);
      cardArray[2] = new Card("Klaver", "4", 2);
      cardArray[3] = new Card("Klaver", "5", 3);
      cardArray[4] = new Card("Klaver", "6", 4);
      cardArray[5] = new Card("Klaver", "7", 5);
      cardArray[6] = new Card("Klaver", "8", 6);
      cardArray[7] = new Card("Klaver", "9", 7);
      cardArray[8] = new Card("Klaver", "10", 8);
      cardArray[9] = new Card("Klaver", "Boer", 9);
      cardArray[10] = new Card("Klaver", "Vrouw", 10);
      cardArray[11] = new Card("Klaver", "Koning", 11);
      cardArray[12] = new Card("Klaver", "Aas", 12);
      
      cardArray[13] = new Card("Schoppen", "2", 13);
      cardArray[14] = new Card("Schoppen", "3", 14);
      cardArray[15] = new Card("Schoppen", "4", 15);
      cardArray[16] = new Card("Schoppen", "5", 16);
      cardArray[17] = new Card("Schoppen", "6", 17);
      cardArray[18] = new Card("Schoppen", "7", 18);
      cardArray[19] = new Card("Schoppen", "8", 19);
      cardArray[20] = new Card("Schoppen", "9", 20);
      cardArray[21] = new Card("Schoppen", "10", 21);
      cardArray[22] = new Card("Schoppen", "Boer", 22);
      cardArray[23] = new Card("Schoppen", "Vrouw", 23);
      cardArray[24] = new Card("Schoppen", "Koning", 24);
      cardArray[25] = new Card("Schoppen", "Aas", 25);
      
      cardArray[26] = new Card("Harten", "2", 26);
      cardArray[27] = new Card("Harten", "3", 27);
      cardArray[28] = new Card("Harten", "4", 28);
      cardArray[29] = new Card("Harten", "5", 29);
      cardArray[30] = new Card("Harten", "6", 30);
      cardArray[31] = new Card("Harten", "7", 31);
      cardArray[32] = new Card("Harten", "8", 32);
      cardArray[33] = new Card("Harten", "9", 33);
      cardArray[34] = new Card("Harten", "10", 34);
      cardArray[35] = new Card("Harten", "Boer", 35);
      cardArray[36] = new Card("Harten", "Vrouw", 36);
      cardArray[37] = new Card("Harten", "Koning", 37);
      cardArray[38] = new Card("Harten", "Aas", 38);
      
      cardArray[39] = new Card("Ruiten", "2", 39);
      cardArray[40] = new Card("Ruiten", "3", 40);
      cardArray[41] = new Card("Ruiten", "4", 41);
      cardArray[42] = new Card("Ruiten", "5", 42);
      cardArray[43] = new Card("Ruiten", "6", 43);
      cardArray[44] = new Card("Ruiten", "7", 44);
      cardArray[45] = new Card("Ruiten", "8", 45);
      cardArray[46] = new Card("Ruiten", "9", 46);
      cardArray[47] = new Card("Ruiten", "10", 47);
      cardArray[48] = new Card("Ruiten", "Boer", 48);
      cardArray[49] = new Card("Ruiten", "Vrouw", 49);
      cardArray[50] = new Card("Ruiten", "Koning", 50);
      cardArray[51] = new Card("Ruiten", "Aas", 51);
  }

  /**
   * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
   * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
   * worden dan 52.
   * 
   * @param card
   *            een Kaart
   * @param index
   *            Op positie
   */
  public void insertAt(Card card, int index) {
     Card[] newCardArray;
     newCardArray = new Card[this.cardArray.length + 1];
   
               
     for(int i=0;i < newCardArray.length; i++)
     {
         if(i < index)
         {
             newCardArray[i] = this.cardArray[i];
         }
         else if(i == index)
         {
             newCardArray[i] = card;
         }
         else
         {
             newCardArray[i] = this.cardArray[i - 1];
         }
     }
     
     this.cardArray = newCardArray;
  }

  /**
   * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
   * met een bepaalde index er uit.
   * 
   * Merk op: na delete is de array zo groot als het aantal elementen dat er in zit.
   * 
   * @param index
   */
  public void delete(int index) {
    Card[] newCardArray;
    newCardArray = new Card[this.cardArray.length - 1];
    
    for(int i=0;i < newCardArray.length; i++)
     {
         if(i != index)
         {
             newCardArray[i] = this.cardArray[i];
         }
     }
     
     this.cardArray = newCardArray;
    
  }

  /**
   * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
   * toegestaan de Java Random generator te gebruiken.
   * 
   */
  public void shuffle() {
    Random rnd = new Random();
    for (int i = cardArray.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      Card a = cardArray[index];
      cardArray[index] = cardArray[i];
      cardArray[i] = a;
    }
  }

  /**
   * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
   * moet als return worden teruggegeven. Zie [Hubbard p.30]
   * 
   * @param card
   *            de kaart die gezocht wordt
   * @return De index van de gevonden kaart
   */
  public int sequentialSearch(Card card) {
    int index = 0;
      
    for(int i=0; i < cardArray.length; i++)
    {
        if(cardArray[i] == card)
        {
            index = i;
        }
    }
    
    return index;
  }

  /**
   * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
   * als de volgorde hetzelfde is als na {@link #fillDeck()}
   */
  public void sort() {
    Card[] newCardArray;
    newCardArray = new Card[this.cardArray.length];
    
    for (int i=0;i < cardArray.length; i++)
    {
      int index = 0;
      for(int c = 0;c < cardArray.length; c++)
      {
          if(cardArray[c].index == i)
          index = c;
      }
      newCardArray[i] = cardArray[index];
    }

    this.cardArray = newCardArray;
  }

  /**
   * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
   * binary search manier zoals besproken in [Hubbart p.31].
   * 
   * @param card
   *            de kaart die gezocht wordt
   * @return De index van de gevonden kaart
   */
  public int binarySearch(Card card) {
    int index = card.index;
    int lo = 0;
    int hi = cardArray.length;
    while(lo < hi)
    {
        int i = (lo + hi) / 2;
        if(cardArray[i].index == index)
        {
            return i;
        }
        else if(cardArray[i].index < index)
        {
            lo = i+1;
        }
        else
        {
            hi = i;
        }
    }
    return -1;
  }

  
  
  /**
   *  Pretty-print het deck.
   */
  @Override
  public String toString() {
    String str = "";
    
    for(int i=0; i<cardArray.length;i++){
      str += cardArray[i];
    }
    return str;
    
  }
}