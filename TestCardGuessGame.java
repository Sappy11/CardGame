

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestCardGuessGame {
	
	static Card c,c1,c2,c3,c4;
	static Hand hand;
	static Deck deck1,deck2;

	@BeforeAll
	static void createObjects() {
		c= new Card();
		c1 = new Card(5,2);
		c2 = new Card(1,4);
		try {
			c3 = new Card(14,2);
		}
		catch(Exception e) {
			
		}
		try {
			c4 = new Card(1,6);
		}
		catch(Exception e) {
			
		}
		hand =new Hand();
		deck1=new Deck(true);
		deck2 = new Deck(false);
		
	}
	@Test
	void testCardValid() {
		assertNotNull(c,"Card is Null");
		assertNotNull(c1,"Card is Null");
		assertNotNull(c2,"Card is Null");
	}
	@Test
	void testCardInvalid() {
		assertNotNull(c3,"Card is Null");
		assertNotNull(c4,"Card is Null");
	}
	
	@Test
	void testHandValid() {
		hand.addCard(c);
		assertEquals(1, hand.getCardCount());
		hand.removeCard(c);
		assertEquals(0, hand.getCardCount());
	}
	
	@Test
	void testHandInvalid() {
		try {
			hand.addCard(c3);
		}
		catch(Exception e) {
			
		}
		assertEquals(1, hand.getCardCount());
		
	}
	
	@Test
	void testDeckValid() {
		assertTrue(deck1.hasJokers());
		assertFalse(deck2.hasJokers());
		for(int i=0;i<52;i++) {
			assertNotEquals(0, deck2.cardsLeft());
			deck2.dealCard();
		}
		
		assertEquals(0, deck2.cardsLeft());
	}
	
	@Test
	void testDeckInvalid() {
		assertTrue(deck2.hasJokers());
		try {
			for(int i=0;i<52;i++) {
				
				deck2.dealCard();
				assertNotEquals(0, deck2.cardsLeft());
			}
		}
		catch(Exception e) {
			
		}
		
		
	}

}
