package newnewblackjack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * 추가 할 거
 * 
 * 딜러는 한개만 보이개	//해결
 * A카드는 1 또는 11이 되게	//해결 A가 2개 이상만 아니면
 * 기타 버그 제거(배팅 크기 알맞게 & 숫자만 입력받게 등)
 * 칩 적용(승리 패배 조건도)	//해결
 * 블랙잭 반복	//해결
 * 시간 널널하면 플레이어 늘리기	//이건 이지선이 안됨
 * stack쓰기	//해결
 * */
public class Main {
	
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		Player player = new Player();
		CardDeck cardDeck = new CardDeck();
		Rule rule = new Rule();
		RestartGame restart = new RestartGame();
		
		int totalChip = 1000;
		
		System.out.println("시작");
		
		System.out.println("카드 덱 생성");
		ArrayList<Card> newDeck = cardDeck.setCardDeck();
		Stack<Card> deck = cardDeck.getCard(newDeck);
		
		ArrayList<Card> dealerCard = new ArrayList<Card>();
		ArrayList<Card> playerCard = new ArrayList<Card>();
		
		//게임 승리 판단
		while(!(rule.gameLose(totalChip))) {
			System.out.println("카드 나눠줌");	
			//카드가 거의 없을 시
			if(deck.size() < 10) {
				newDeck = cardDeck.setCardDeck();
				deck = cardDeck.getCard(newDeck);
				System.out.println("카드를 초기화 합니다");
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
			
			System.out.println("배팅하기");
			Scanner chip = new Scanner(System.in);
	
			System.out.println("현재 칩 : " + totalChip);
			
			System.out.print("배팅할 칩 : ");
			int bettingChip = chip.nextInt();
	
			totalChip = player.playerBetting(totalChip, bettingChip);
			System.out.println(totalChip);
			
			System.out.println("카드 받음");
			System.out.println("플레이어");
			while(!rule.isBust(playerSum)) {
				System.out.println("1 : 받음, 2 : 안받음");
				Scanner choice = new Scanner(System.in);
				
				//받음
				if(choice.nextInt() == 1) {
					Card card = player.hit(deck, playerCard);
					rule.printCard("player", playerCard);
					playerSum = rule.getSum(playerCard);
				} else {
					break;
				}
			}
			
			System.out.println("딜러");
	
			dealerCard = dealer.dealerGetCard(dealerSum, deck, dealerCard);
			rule.printCard("Dealer", dealerCard);
			dealerSum = rule.getSum(dealerCard);
			
			System.out.println(rule.whoWin(dealerSum, playerSum) + " is win!!");
			System.out.println(dealerSum +" "+playerSum);
			
			System.out.print("배팅 결과 : ");
			totalChip = rule.bettingEnd(totalChip, bettingChip, playerSum, dealerSum);
			System.out.println(totalChip);
			
			System.out.println("초기화\n");
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
				System.out.println("당신이 이겼습니다. 축축");
				break;
			}
		}
	}
}
