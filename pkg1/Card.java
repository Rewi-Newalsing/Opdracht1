package opdracht.pkg1;
/**
 * 
 * @author Youri Tjang
 *
 */
public class Card {

    Card(String suit, String number, int index)
    {
        this.suit = suit;
        this.number = number;
        this.index = index;
    }
    
    String suit;
    String number;
    int index;

    public String toString(){
        return suit + " - " + number + " - " + index + "\n";
    }
}