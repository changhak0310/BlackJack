package newnewblackjack;

import java.util.ArrayList;
import java.util.Stack;

public class CardDeck {
	
	//µ¦ »ý¼º
	public ArrayList<Card> setCardDeck() {
		ArrayList<Card> makeDeck = new ArrayList<Card>();
		
		for(int i=0; i<52; i++) {
			Card card = new Card();
			switch(i%4) {
			case 0:
				card.setPattern("hearts");
				break;
			case 1:
				card.setPattern("spades");
				break;
			case 2:
				card.setPattern("diamons");
				break;
			case 3:
				card.setPattern("clubs");
				break;
			}
			
			switch(i%13) {
			case 0:
				card.setNumber("A");
				break;
			case 1:
				card.setNumber("2");
				break;
			case 2:
				card.setNumber("3");
				break;
			case 3:
				card.setNumber("4");
				break;
			case 4:
				card.setNumber("5");
				break;
			case 5:
				card.setNumber("6");
				break;
			case 6:
				card.setNumber("7");
				break;
			case 7:
				card.setNumber("8");
				break;
			case 8:
				card.setNumber("9");
				break;
			case 9:
				card.setNumber("10");
				break;
			case 10:
				card.setNumber("J");
				break;
			case 11:
				card.setNumber("Q");
				break;
			case 12:
				card.setNumber("K");
				break;
			}
			
			makeDeck.add(card);
		}
		
		return makeDeck;
	}
	
	public Stack<Card> getCard(ArrayList<Card> makeDeck){
		System.out.println("Ä«µå ¼¯À½");
		Stack<Card> deck = new Stack<Card>();
		
		for(int i=makeDeck.size(); i>0; i--)
			deck.push(mixCard(makeDeck));
		
		return deck;
	}
	
	//Ä«µå ¼¯±â ³Ö±â
	public Card mixCard(ArrayList<Card> makeDeck) {
		int size = makeDeck.size();	//µ¦ Å©±â
		int num = (int)(Math.random() * size);
		
		Card card = makeDeck.get(num);
		makeDeck.remove(num);
		
		return card;
	}
}
