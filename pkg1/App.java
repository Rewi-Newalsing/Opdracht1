package opdracht.pkg1;
/**
 * 
 * @author Youri Tjang
 *
 */
public class App {

  /**
   * App die onze datastructuur test.
   */
  public static void main(String[] args) {
    Deck deck = new Deck();
    deck.fillDeck();
    
    deck.shuffle();
    
    Card card = new Card("Harten", "2", 52);
    int testIndex = 30;
    deck.insertAt(card, testIndex);
    
    System.out.print("Sequential search ...");
    int foundIndex = deck.sequentialSearch(card);
    System.out.println((foundIndex == testIndex)?"Win":"Fail");
    
    System.out.print("Binary search...");
    deck.sort();
    foundIndex = deck.binarySearch(card);
    System.out.println(foundIndex);
  }
}