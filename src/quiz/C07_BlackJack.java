package quiz;

import java.util.Scanner;

public class C07_BlackJack {

	/*
		# 참고자료

			https://www.247blackjack.com/

		# 카드
			4가지의 문양 : 하트, 클로버, 다이아몬드, 스페이드

			숫자 : A 2 3 4 5 6 7 8 9 10 J Q K

			※ 블랙잭에서 A는 1로 쓸 수도 있고 11로도 쓸 수 있음
			  J, Q, K는 10
			  조커는 사용하지 않음

		# 블랙잭을 만들어 보세요

		1. 컴퓨터(딜러)와 사람(플레이어)이 카드를 뽑는다

		2. 처음에는 모두 2장씩 받는다. 이 때 딜러의 카드는 한장 가려놓는다.

		3. 사용자는 상황을 보고 더 뽑을지(hit) 여기서 멈출지를(stand) 결정한다

		4. 사용자가 멈추면 딜러가 가려져 있던 카드를 오픈하고 규칙에 따라 카드를 뽑는다
		   (딜러는 반드시 카드 합이 16 이하일때 무조건 뽑고, 17 이상이면 무조건 멈춰야 한다)

		5. 플레이어의 카드 숫자들의 합이 딜러보다 높거나 정확하게 21이라면 승리한다.
		   플레이어의 카드 숫자들의 합이 21보다 크면 패배한다. (A ~ K)


	 */
	public static void main(String[] args) {
		Card blackJack = new Card();
		blackJack.play_game();
	}

}

class Card{
	Scanner sc = new Scanner(System.in);
	String[] card;
	String choice;
	int[] card_number;
	int a_count = 0;

	Card(){
		card = new String[]{"하트 A", "하트 2", "하트 3", "하트 4", "하트 5", "하트 6", "하트 7", "하트 8", "하트 9", "하트 10", "하트 J", "하트 Q", "하트 K"
				,"스페이드 A", "스페이드 2", "스페이드 3", "스페이드 4", "스페이드 5", "스페이드 6", "스페이드 7", "스페이드 8", "스페이드 9", "스페이드 10", "스페이드 J", "스페이드 Q", "스페이드 K"
				,"클로버 A", "클로버 2", "클로버 3", "클로버 4", "클로버 5", "클로버 6", "클로버 7", "클로버 8", "클로버 9", "클로버 10", "클로버 J", "클로버 Q", "클로버 K"
				,"다이아 A", "다이아 2", "다이아 3", "다이아 4", "다이아 5", "다이아 6", "다이아 7", "다이아 8", "다이아 9", "다이아 10", "다이아 J", "다이아 Q", "다이아 K"
		};
		card_number = new int[] {11,2,3,4,5,6,7,8,9,10,10,10,10,
				11,2,3,4,5,6,7,8,9,10,10,10,10,
				11,2,3,4,5,6,7,8,9,10,10,10,10,
				11,2,3,4,5,6,7,8,9,10,10,10,10
		};

	}

	void play_game() {
		String[] player_card = new String[21];
		String[] dealer_card = new String[21];
		int player_card_count = 0;
		int dealer_card_count = 0;
		int player_number = 0;
		int dealer_number = 0;
		int card_order = -1;
		int a_count = 0;
		int exclusion_of_duplicates = 0;


		for(int i = 0; i < 2; i++) {
			player_card[i] = card[(int)(Math.random()*card.length)];
			dealer_card[i] = card[(int)(Math.random()*card.length)];
			for(int j = 0; j < card.length; j++) {
				if(player_card[i].equals(card[j]))
				{
					player_number += card_number[j];
					break;
				}
			}
			for(int j = 0; j < card.length; j++) {
				if(dealer_card[i].equals(card[j]))
				{
					dealer_number += card_number[j];
					break;
				}
			}
			player_card_count++;
			dealer_card_count++;
		}

		if(player_number > 21) {
			for(int k = 0; k < player_card_count; k++) {
				if(player_card[k].charAt(player_card[k].length()-1) == 'A')
				{
					a_count++;
				}
			}
			if(a_count >= 1)
			{
				player_number -= 10 ;
				exclusion_of_duplicates++;
			}
		}
		

		System.out.println("현재 내카드 : " + player_card[0] + " " + player_card[1]);
		System.out.println("현재 딜러카드 : " + dealer_card[0] + " " + " ??");
		
		if(player_number == 21) {
			System.out.println("\n축하합니다 플레이어의 숫자의 합이 21로 블랙잭입니다!");
			System.exit(0);
		}

		while(true) {
			System.out.println("플레이어의 숫자의 합은 " + player_number + " 입니다");
			System.out.println();
			System.out.print("hit 하시겠습니까? stand 하시겠습니까? ");
			choice = sc.nextLine();
			System.out.println();
			if(choice.equals("stand"))
			{
				break;
			}

			player_card[player_card_count++] = card[(int)(Math.random()*card.length)];
			for(int i = 0; i < card.length; i++) {
				if(player_card[(player_card_count - 1)].equals(card[i]))
				{
					player_number += card_number[i];
					break;
				}
			}
			System.out.print("현재 내카드 : " + player_card[0] + " " + player_card[1] + " ");
			for(int i = 2; i < player_card_count; i++) {
				System.out.print(player_card[i] + " ");	
			}


			if(player_number == 21) {
				System.out.println("\n축하합니다 플레이어의 숫자의 합이 21로 블랙잭입니다!");
				System.exit(0);
			}

			else if(player_number > 21) {
				a_count = 0;
				for(int k = 0; k < player_card_count; k++) {
					if(player_card[k].charAt(player_card[k].length()-1) == 'A')
					{
						a_count++;
					}
				}
				if(a_count >= 1 && a_count > exclusion_of_duplicates  )
				{
					player_number -= 10 ;
					exclusion_of_duplicates++;
					if(player_number == 21) {
						System.out.println("\n축하합니다 플레이어의 숫자의 합이 21로 블랙잭입니다!");
						System.exit(0);
					}
				}
				else if(a_count == 0)
				{
					System.out.println("\n플레이어의 숫자의 합이 " + player_number +"로 21이 넘었습니다 패배했습니다");
					System.exit(0);
				}

				if(player_number > 21) {
					System.out.println("\n플레이어의 숫자의 합이 " + player_number +"로 21이 넘었습니다 패배했습니다");
					System.exit(0);
				}

			}
			System.out.println();
		}

		a_count = 0;
		exclusion_of_duplicates = 0;
		System.out.print("현재 내카드 : ");
		for(int i = 0; i < player_card_count; i++) {
			System.out.print(" " + player_card[i]);

		}

		System.out.println();
		System.out.println("플레이어의 숫자의 합은 " + player_number + " 입니다");

		System.out.print("현재 딜러카드 : ");
		for(int i = 0; i < dealer_card_count; i++) {
			System.out.print(" " + dealer_card[i]);

		}

		if(dealer_number > 21) {
			for(int k = 0; k < dealer_card_count; k++) {
				if(dealer_card[k].charAt(dealer_card[k].length()-1) == 'A')
				{
					a_count++;
				}
			}
			if(a_count >= 1 )
			{
				dealer_number -= 10 ;
				exclusion_of_duplicates = a_count;
			}
		}
		System.out.println();
		System.out.println("딜러의 숫자의 합은 " + dealer_number + " 입니다");
		System.out.println();
		if(dealer_number == 21) {
			System.out.println("\n딜러의 숫자의 합이 21로 블랙잭입니다 패배하였습니다.");
			System.exit(0);
		}

		while(true) {
			if(dealer_number >= 17) {
				break;
			}
			dealer_card[dealer_card_count++] = card[(int)(Math.random()*card.length)];
			for(int i = 0; i < card.length; i++) {
				if(dealer_card[(dealer_card_count - 1)].equals(card[i]))
				{
					dealer_number += card_number[i];
					break;
				}
			}
			System.out.print("현재 내카드 : ");

			for(int i = 0; i < player_card_count; i++) {
				System.out.print(" " + player_card[i]);

			}
			System.out.println();
			System.out.println("플레이어의 숫자의 합은 " + player_number + " 입니다");

			System.out.print("현재 딜러카드 : " + dealer_card[0] + " " + dealer_card[1] + " ");
			for(int l = 2; l < dealer_card_count; l++) {
				System.out.print(dealer_card[l] + " ");
			}


			if(dealer_number == 21) {
				System.out.println("\n딜러의 숫자의 합이 21로 블랙잭입니다 패배하였습니다.");
				System.exit(0);
			}
			else if(dealer_number > 21) {
				a_count = 0;
				for(int k = 0; k < dealer_card_count; k++) {
					if(dealer_card[k].charAt(dealer_card[k].length()-1) == 'A')
					{
						a_count++;
					}
				}
				if(a_count >= 1 && a_count > exclusion_of_duplicates  )
				{
					dealer_number -= 10 ;
					exclusion_of_duplicates = a_count;
					if(dealer_number == 21) {
						System.out.println("\n딜러의 숫자의 합이 21로 블랙잭입니다 패배하였습니다.");
						System.exit(0);
					}
				}
				else if(a_count == 0)
				{
					System.out.println("\n딜러의 숫자의 합이 " + dealer_number +"로 21이 넘었습니다 패배했습니다");
					System.exit(0);
				}
			}


			System.out.println();
			System.out.println("딜러의 숫자의 합은 " + dealer_number + " 입니다");
			System.out.println();
		}
		System.out.println();

		if(player_number > dealer_number) 
		{
			System.out.println("축하합니다 플레이어의 숫자의 합은 " + player_number + "딜러의 숫자의 합은 " + dealer_number + "로 플레이어의 숫자가 더 커 승리했습니다.");
		}
		else if(player_number < dealer_number) 
		{
			System.out.println("플레이어의 숫자의 합은 " + player_number + "딜러의 숫자의 합은 " + dealer_number + "로 딜러의 숫자가 더 커 패배했습니다");
		}
		else
		{
			System.out.println("플레이어의 숫자의 합은 " + player_number + "딜러의 숫자의 합은 " + dealer_number + "로 비겼습니다.");
		}




	}

}

















