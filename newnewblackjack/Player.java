package newnewblackjack;

import java.util.ArrayList;
import java.util.Stack;

public class Player {
	//카드 얻기
	public Card hit(Stack<Card> deck, ArrayList<Card> playerCard) {
		Card card = deck.pop();
		playerCard.add(card);
		return card;
	}

	public int playerBetting(int totalChip, int bettingChip) {
		totalChip = totalChip - bettingChip;
		return totalChip;
	}
}
