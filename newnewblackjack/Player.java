package newnewblackjack;

import java.util.ArrayList;
import java.util.Stack;

public class Player {
	//ī�� ���
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
