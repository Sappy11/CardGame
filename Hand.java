import java.util.Vector;

public class Hand {

   private Vector hand;   // The cards in the hand.


   public Hand() {
      hand = new Vector();
   }
   
 
   public void clear() {
      hand.setSize(0);
   }
   
 
   public void addCard(Card c) {
      if (c == null)
         throw new NullPointerException("Can't add a null card to a hand.");
      hand.addElement(c);
   }
   
 
   public void removeCard(Card c) {
      hand.remove(c);
   }
   
  
   public void removeCard(int position) {
      if (position < 0 || position >= hand.size())
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
      hand.removeElementAt(position);
   }

  
   public int getCardCount() {
      return hand.size();
   }
   
  
   public Card getCard(int position) {
      if (position < 0 || position >= hand.size())
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
       return (Card)hand.elementAt(position);
   }
   
   public void sortBySuit() {
      Vector newHand = new Vector();
      while (hand.size() > 0) {
         int pos = 0;  // Position of minimal card.
         Card c = (Card)hand.elementAt(0);  // Minumal card.
         for (int i = 1; i < hand.size(); i++) {
            Card c1 = (Card)hand.elementAt(i);
            if ( c1.getSuit() < c.getSuit() ||
                    (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
                pos = i;
                c = c1;
            }
         }
         hand.removeElementAt(pos);
         newHand.addElement(c);
      }
      hand = newHand;
   }
   
  
   public void sortByValue() {
      Vector newHand = new Vector();
      while (hand.size() > 0) {
         int pos = 0;  // Position of minimal card.
         Card c = (Card)hand.elementAt(0);  // Minumal card.
         for (int i = 1; i < hand.size(); i++) {
            Card c1 = (Card)hand.elementAt(i);
            if ( c1.getValue() < c.getValue() ||
                    (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
                pos = i;
                c = c1;
            }
         }
         hand.removeElementAt(pos);
         newHand.addElement(c);
      }
      hand = newHand;
   }
   
}
