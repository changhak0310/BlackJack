package newnewblackjack;

import java.util.ArrayList;
import java.util.Stack;

public class Rule {
	//ī�� �� ���ϱ�
	public int getSum(ArrayList<Card> deck) {
		int sum = 0;
		boolean containA = false;
		
		for(int i = 0; i < deck.size(); i++) {
			String number = deck.get(i).getNumber();
			if(number.equals("A")) {
				sum += 11;
				containA = true;
			}else if(number.equals("J") || number.equals("Q") || number.equals("K")) {
				sum += 10;
			}else {
				sum += Integer.parseInt(number);
			}
		}
		if(containA && sum > 21) {
			sum = sum - 10;
		}
		
		return sum;
	}
	
	//21�� ���� ���
	public boolean isBust(int sum) {
		if(sum>21) {
			System.out.println("����Ʈ");
			return true;
		} else {
			return false;
		}
	}
	
	//����
	public String whoWin(int dealerSum, int playerSum) {
		int dealer = dealerSum;
		int player = playerSum;
		String winner = null;
		
		if(isBust(playerSum) || (!(isBust(dealerSum)) && player <= dealer)) {
			winner = "Dealer";
		} else {
			winner = "Player";
		}
		return winner;
	}
	
	//ī�� ���
	public void printCard(String who, ArrayList<Card> deck) {
		Rule rule = new Rule();
		int sum = 0;
		
		System.out.println(who + " ī�� : ");
		
		if(who=="dealer" && deck.size()==2) {
			System.out.println(deck.get(0).getPattern() + ", " + deck.get(0).getNumber());
		} else {
			for(int i=0; i<deck.size(); i++) {
				System.out.println(deck.get(i).getPattern() + ", " + deck.get(i).getNumber());
			}
			sum = rule.getSum(deck);
			System.out.println("�� : " + sum + "\n");
		}
		System.out.println();
	}

	//Ĩ ���
	public int bettingEnd(int totalChip, int bettingChip, int playerSum, int dealerSum) {
		String winner = whoWin(dealerSum, playerSum);
		
		if(winner == "Player") {
			totalChip = totalChip + bettingChip*2;
		} 
		return totalChip;
	}
	
	//���� �й�
	public boolean gameLose(int totalChip) {
		if(totalChip <= 0) {
			return true;
		}
		return false;
	}
	
	public boolean gameWin(int totalChip) {
		if(totalChip >= 2000) {
			return true;
		}
		return false;
	}

	public void getCardIM(Stack<Card> deck) {
//		Card card = new Card();	
		Card firstCard = deck.peek();
		//Card firstCard = deck.get(0);
		
		System.out.print(firstCard.getPattern());
		System.out.println(" "+firstCard.getNumber());
		
		//��
//		if(firstCard.getNumber()=="6") {
//			System.out.println("sdadasdassadadsadadsas");
//		}
	}
	
	
}
