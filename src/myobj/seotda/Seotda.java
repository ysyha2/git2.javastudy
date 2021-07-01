package myobj.seotda;

import java.util.ArrayList;
import java.util.Collections;

public class Seotda {

	public static void main(String[] args) {

		game_start();


	}

	public static void game_start() {

		Player[] player = new Player[5];
		Card card1 = new Card();
		
		for(int i = 0 ; i < player.length; i++) {
			player[i] = new Player();
			player[i].number = i + 1;
		}

		boolean regame = false;

		for(int i = 0 ; i < 1000; i++) {
			Collections.shuffle(card1.card);
		}

		for(int i = 0; i < player.length; i++) {
			player[i].player_card.add(card1.card.get(0));
			card1.card.remove(0);
		}


		System.out.println("첫번째 패돌림");
		
		for(int i = 0; i < player.length; i++) {

			System.out.println("플레이어 " + (i+1) +"님의 패: " + player[i].player_card);

		}

		System.out.println();
		
		for(int i = 0; i < player.length; i++) {

			player[i].player_card.add(card1.card.get(0));
			card1.card.remove(0);

		}

		System.out.println("두번째 패돌림");
		
		for(int i = 0; i < player.length; i++) {

			System.out.println("플레이어 " + (i+1) +"님의 패: " + player[i].player_card);

		}
		System.out.println();
		for(int i = 0; i < player.length; i++) {
			
			check(player[i]);	
		}



		double[] rank_collect = {player[0].rank, player[1].rank, player[2].rank,
				player[3].rank, player[4].rank};
		for(int i = 0; i < rank_collect.length; i++)
		{
			if(rank_collect[i] == 100)			
			{
				regame = true;
				for(int j = 0; j < rank_collect.length; j++)
				{
					if(rank_collect[j] > 3)
					{
						continue;
					}
					else
					{
						regame = false;
					}
				}

			}
			else if(rank_collect[i] == 101)			
			{
				regame = true;
				for(int j = 0; j < rank_collect.length; j++)
				{
					if(rank_collect[j] > 12)
					{
						continue;
					}
					else
					{
						regame = false;
					}
				}

			}

			if(rank_collect[i] == 102)
			{
				if(player[0].rank == 102 && (player[1].rank == 2 || player[2].rank == 2 ||
						player[3].rank == 2 || player[4].rank == 2 ))
				{
					player[0].rank = 1.5;
				}

				if(player[1].rank == 102 && (player[0].rank == 2 || player[2].rank == 2 ||
						player[3].rank == 2 || player[4].rank == 2 ))
				{
					player[1].rank = 1.5;
				}

				if(player[2].rank == 102 && (player[1].rank == 2 || player[0].rank == 2 ||
						player[3].rank == 2 || player[4].rank == 2 ))
				{
					player[2].rank = 1.5;
				}

				if(player[3].rank == 102 && (player[1].rank == 2 || player[2].rank == 2 ||
						player[0].rank == 2 || player[4].rank == 2 ))
				{
					player[3].rank = 1.5;
				}

				if(player[4].rank == 102 && (player[1].rank == 2 || player[2].rank == 2 ||
						player[3].rank == 2 || player[0].rank == 2 ))
				{
					player[4].rank = 1.5;
				}

			}

			if(rank_collect[i] == 103)
			{
				if(player[0].rank == 102 && ((player[1].rank >= 4 && player[1].rank <= 12) ||
						(player[2].rank >= 4 && player[2].rank <= 12) ||
						(player[3].rank >= 4 && player[3].rank <= 12) ||
						(player[4].rank >= 4 && player[4].rank <= 12)))
				{
					player[0].rank = 3.5;
				}

				if(player[1].rank == 102 && ((player[0].rank >= 4 && player[0].rank <= 12) ||
						(player[2].rank >= 4 && player[2].rank <= 12) ||
						(player[3].rank >= 4 && player[3].rank <= 12) ||
						(player[4].rank >= 4 && player[4].rank <= 12)))
				{
					player[1].rank = 3.5;
				}

				if(player[2].rank == 102 && ((player[1].rank >= 4 && player[1].rank <= 12) ||
						(player[0].rank >= 4 && player[0].rank <= 12) ||
						(player[3].rank >= 4 && player[3].rank <= 12) ||
						(player[4].rank >= 4 && player[4].rank <= 12)))
				{
					player[2].rank = 3.5;
				}

				if(player[3].rank == 102 && ((player[1].rank >= 4 && player[1].rank <= 12) ||
						(player[2].rank >= 4 && player[2].rank <= 12) ||
						(player[0].rank >= 4 && player[0].rank <= 12) ||
						(player[4].rank >= 4 && player[4].rank <= 12)))
				{
					player[3].rank = 3.5;
				}

				if(player[4].rank == 102 && ((player[1].rank >= 4 && player[1].rank <= 12) ||
						(player[2].rank >= 4 && player[2].rank <= 12) ||
						(player[3].rank >= 4 && player[3].rank <= 12) ||
						(player[0].rank >= 4 && player[0].rank <= 12)))
				{
					player[4].rank = 3.5;
				}


			}
		}

		if(regame)
		{
			System.out.println("49로 재경기입니다.");
			System.exit(0);
		}

		ArrayList<Double> rank = new ArrayList<>();
		
		for(int i = 0; i < player.length; i++){
			rank.add(player[i].rank);			
		}

		System.out.println();
		
		for(int i = 0; i < player.length; i++) {
			if(player[i].rank == Collections.min(rank))
			{
				System.out.println("플레이어 " + (i+1) + "님이 승리하셨습니다.");
				break;
			}
		}


	}

	public static void check(Player player) {
		int len1;
		int len2;
		String card1;
		String card2;
		char text1;
		char text2;
		int number1;
		int number2;

		len1 = player.player_card.get(0).length();
		len2 = player.player_card.get(1).length();
		card1 = player.player_card.get(0);
		card2 = player.player_card.get(1);
		text1 = player.player_card.get(0).charAt(0);
		text2 = player.player_card.get(1).charAt(0);
		number1 = player.player_card.get(0).charAt(len1-1) - '0';
		number2 = player.player_card.get(1).charAt(len2-1) - '0';
		if(text1 == '광' && text2 == '광' ) 
		{
			if((number1 == 3 && number2 == 8) || (number2 == 3 && number1 == 8))
			{
				player.rank = 1;
				System.out.println("플레이어 " + player.number + "의 패는 38광땡입니다.");
			}

			else if((number1 == 1 && number2 == 3) || (number2 == 3 && number1 == 1))
			{
				player.rank = 2;
				System.out.println("플레이어 " + player.number + "의 패는 13광땡입니다.");
			}

			else
			{
				player.rank = 2;
				System.out.println("플레이어 " + player.number + "의 패는 18광땡입니다.");
			}

		}

		else if(number1 == number2)
		{
			if(number1 == 0)
			{
				System.out.println("플레이어 " + player.number + "의 패는 장땡입니다.");
				player.rank = 3;
			}

			else if(number1 == 9)
			{
				System.out.println("플레이어 " + player.number + "의 패는 9땡입니다.");
				player.rank = 4;
			}

			else if(number1 == 8)
			{
				System.out.println("플레이어 " + player.number + "의 패는 8땡입니다.");
				player.rank = 5;
			}

			else if(number1 == 7)
			{
				System.out.println("플레이어 " + player.number + "의 패는 7땡입니다.");
				player.rank = 6;
			}

			else if(number1 == 6)
			{
				System.out.println("플레이어 " + player.number + "의 패는 6땡입니다.");
				player.rank = 7;
			}

			else if(number1 == 5)
			{
				System.out.println("플레이어 " + player.number + "의 패는 5땡입니다.");
				player.rank = 8;
			}

			else if(number1 == 4)
			{
				System.out.println("플레이어 " + player.number + "의 패는 4땡입니다.");
				player.rank = 9;
			}

			else if(number1 == 3)
			{
				System.out.println("플레이어 " + player.number + "의 패는 3땡입니다.");
				player.rank = 10;
			}

			else if(number1 == 2)
			{
				System.out.println("플레이어 " + player.number + "의 패는 2땡입니다.");
				player.rank = 11;
			}

			else
			{
				System.out.println("플레이어 " + player.number + "의 패는 1땡입니다.");
				player.rank = 12;
			}

		}

		else if((number1 == 1 && number2 == 2) || (number2 == 2 && number1 == 1))
		{
			System.out.println("플레이어 " + player.number + "의 패는 알리입니다.");
			player.rank = 13;
		}

		else if((number1 == 1 && number2 == 4) || (number2 == 4 && number1 == 1))
		{
			System.out.println("플레이어 " + player.number + "의 패는 독사입니다.");
			player.rank = 14;
		}

		else if((number1 == 1 && number2 == 9) || (number2 == 9 && number1 == 1))
		{
			System.out.println("플레이어 " + player.number + "의 패는 구삥입니다.");
			player.rank = 15;
		}

		else if((number1 == 1 && number2 == 0) || (number2 == 0 && number1 == 1))
		{
			System.out.println("플레이어 " + player.number + "의 패는 장삥입니다.");
			player.rank = 16;
		}

		else if((number1 == 4 && number2 == 0) || (number2 == 0 && number1 == 4))
		{
			System.out.println("플레이어 " + player.number + "의 패는 장사입니다.");
			player.rank = 17;
		}

		else if((number1 == 4 && number2 == 6) || (number2 == 6 && number1 == 4))
		{
			System.out.println("플레이어 " + player.number + "의 패는 세륙입니다.");
			player.rank = 18;
		}



		else if((number1 + number2)%10 == 9)
		{
			System.out.println("플레이어 " + player.number + "의 패는 갑오입니다.");
			player.rank = 19;
		}

		else if((number1 + number2)%10 == 8)
		{
			System.out.println("플레이어 " + player.number + "의 패는 여덟끗입니다.");
			player.rank = 20;
		}
		else if((number1 + number2)%10 == 7)
		{
			System.out.println("플레이어 " + player.number + "의 패는 일곱끗입니다.");
			player.rank = 21;
		}
		else if((number1 + number2)%10 == 6)
		{
			System.out.println("플레이어 " + player.number + "의 패는 여섯끗입니다.");
			player.rank = 22;
		}
		else if((number1 + number2)%10 == 5)
		{
			System.out.println("플레이어 " + player.number + "의 패는 다섯끗입니다.");
			player.rank = 23;
		}
		else if((number1 + number2)%10 == 4)
		{
			System.out.println("플레이어 " + player.number + "의 패는 네끗입니다.");
			player.rank = 24;
		}
		else if((number1 + number2)%10 == 3)
		{
			if((number1 == 4 && number2 == 9) || (number1 == 9 && number2 == 4))
			{
				if(text1 == '특' && text2 == '특')
				{
					System.out.println("플레이어 " + player.number + "의 패는 멍텅구리 사구입니다.");
					player.rank = 100;
				}
				else
				{
					System.out.println("플레이어 " + player.number + "의 패는 사구입니다.");
					player.rank = 101;
				}
			}
			else {
				System.out.println("플레이어 " + player.number + "의 패는 세끗입니다.");
				player.rank = 25;
			}
		}
		else if((number1 + number2)%10 == 2)
		{
			System.out.println("플레이어 " + player.number + "의 패는 두끗입니다.");
			player.rank = 26;
		}
		else if((number1 + number2)%10 == 1)
		{
			if((text1 == '특' && text2 == '특') && ((number1 == 4 && number2 == 7) 
					|| (number1 == 7 && number2 == 4)))
			{
				System.out.println("플레이어 " + player.number + "의 패는 암행어사입니다.");
				player.rank = 102;
			}
			else {
				System.out.println("플레이어 " + player.number + "의 패는 한끗입니다.");
				player.rank = 27;
			}
		}

		else if((number1 + number2)%10 == 0)
		{
			if(((text1 == '특' && text2 == '광') || (text1 == '광' && text2 == '특'))
					&& ((number1 == 3 && number2 == 7) || (number1 == 7 && number2 == 3)))
			{
				System.out.println("플레이어 " + player.number + "의 패는 땡잡이입니다.");
				player.rank = 103;
			}
			else {
				System.out.println("플레이어 " + player.number + "의 패는 망통입니다.");
				player.rank = 28;
			}
		}


	}



}


