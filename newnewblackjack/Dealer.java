package newnewblackjack;

import java.util.ArrayList;
import java.util.Stack;

public class Dealer {
	//ī�� ��� (��Ģ ����)
	public ArrayList<Card> dealerGetCard(int dealerSum, Stack<Card> deck, ArrayList<Card> dealerCard) {
		Rule rule = new Rule();
		int sum = dealerSum;
		
		while(sum < 17) {
			Card card = deck.pop();
			dealerCard.add(card);
			sum = rule.getSum(dealerCard);
		}
		return dealerCard;
	}
}
