package newnewblackjack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * �߰� �� ��
 * 
 * ������ �Ѱ��� ���̰�	//�ذ�
 * Aī��� 1 �Ǵ� 11�� �ǰ�	//�ذ� A�� 2�� �̻� �ƴϸ�
 * ��Ÿ ���� ����(���� ũ�� �˸°� & ���ڸ� �Է¹ް� ��)
 * Ĩ ����(�¸� �й� ���ǵ�)	//�ذ�
 * ���� �ݺ�	//�ذ�
 * �ð� �γ��ϸ� �÷��̾� �ø���	//�̰� �������� �ȵ�
 * stack����	//�ذ�
 * */
public class Main {
	
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		Player player = new Player();
		CardDeck cardDeck = new CardDeck();
		Rule rule = new Rule();
		RestartGame restart = new RestartGame();
		
		int totalChip = 1000;
		
		System.out.println("����");
		
		System.out.println("ī�� �� ����");
		ArrayList<Card> newDeck = cardDeck.setCardDeck();
		Stack<Card> deck = cardDeck.getCard(newDeck);
		
		ArrayList<Card> dealerCard = new ArrayList<Card>();
		ArrayList<Card> playerCard = new ArrayList<Card>();
		
		//���� �¸� �Ǵ�
		while(!(rule.gameLose(totalChip))) {
			System.out.println("ī�� ������");	
			//ī�尡 ���� ���� ��
			if(deck.size() < 10) {
				newDeck = cardDeck.setCardDeck();
				deck = cardDeck.getCard(newDeck);
				System.out.println("ī�带 �ʱ�ȭ �մϴ�");
			}
			rule.getCardIM(deck);
			dealerCard.add(deck.pop());
			rule.getCardIM(deck);
			dealerCard.add(deck.pop());
			rule.getCardIM(deck);
			playerCard.add(deck.pop());
			rule.getCardIM(deck);
			playerCard.add(deck.pop());
			
			rule.printCard("dealer", dealerCard);
			rule.printCard("player", playerCard);
			
			int dealerSum = rule.getSum(dealerCard);
			int playerSum = rule.getSum(playerCard);
			System.out.println("--------------");
			
			System.out.println("�����ϱ�");
			Scanner chip = new Scanner(System.in);
	
			System.out.println("���� Ĩ : " + totalChip);
			
			System.out.print("������ Ĩ : ");
			int bettingChip = chip.nextInt();
	
			totalChip = player.playerBetting(totalChip, bettingChip);
			System.out.println(totalChip);
			
			System.out.println("ī�� ����");
			System.out.println("�÷��̾�");
			while(!rule.isBust(playerSum)) {
				System.out.println("1 : ����, 2 : �ȹ���");
				Scanner choice = new Scanner(System.in);
				
				//����
				if(choice.nextInt() == 1) {
					Card card = player.hit(deck, playerCard);
					rule.printCard("player", playerCard);
					playerSum = rule.getSum(playerCard);
				} else {
					break;
				}
			}
			
			System.out.println("����");
	
			dealerCard = dealer.dealerGetCard(dealerSum, deck, dealerCard);
			rule.printCard("Dealer", dealerCard);
			dealerSum = rule.getSum(dealerCard);
			
			System.out.println(rule.whoWin(dealerSum, playerSum) + " is win!!");
			System.out.println(dealerSum +" "+playerSum);
			
			System.out.print("���� ��� : ");
			totalChip = rule.bettingEnd(totalChip, bettingChip, playerSum, dealerSum);
			System.out.println(totalChip);
			
			System.out.println("�ʱ�ȭ\n");
			playerCard = restart.reCard(playerCard);
			dealerCard = restart.reCard(dealerCard);
			bettingChip = restart.reBettingChip(bettingChip);
			playerSum = restart.reSum(playerSum);
			dealerSum = restart.reSum(dealerSum);
	//		rule.printCard("dealer", dealerCard);
	//		rule.printCard("player", playerCard);
	//		System.out.println(bettingChip);
	//		System.out.println(playerSum);
	//		System.out.println(dealerSum);
			if(rule.gameWin(totalChip)) {
				System.out.println("����� �̰���ϴ�. ����");
				break;
			}
		}
	}
}
