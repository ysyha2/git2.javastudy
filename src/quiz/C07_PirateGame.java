package quiz;

import java.util.Scanner;

import myobj.pirate.Graphic;
import myobj.pirate.MrTong;
import myobj.pirate.Player;

public class C07_PirateGame {
	
	/*
		
		1. 플레이어는 원하는 곳에 돌아가면서 칼을 찌른다
		
		2. 해적 아저씨가 날아가는 구멍이 랜덤으로 설정된다
		
		3. 플레이어는 여러명이 될 수 있다 (최소 2인, 최대는 구멍 숫자만큼)
		
		4. 새 게임 생성시 구멍 개수를 설정할 수 있다
		
		5. 해적 아저씨를 날린 플레이어가 패배한다
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfPlayer = -1;
		while (numOfPlayer < 2) {
			System.out.print("참여할 인원 수를 입력 >");
			numOfPlayer = sc.nextInt();
		}
		
		Player[] players = new Player[numOfPlayer];
		
		for (int i = 0 ; i < numOfPlayer; i++) {
			players[i] = new Player("플레이어 "+ (i + 1));
		}
		System.out.println("[System] 플레이어 등록 완료..");
		
		// 나중에 통 크기 결정
		int size = 30;
		while (true) {
			MrTong tong = new MrTong(size);
			int turn = 0;
			
			boolean this_game = true;
			while(this_game) {
				System.out.println((turn + 1) + "턴 > \"" 
			+ players[turn % numOfPlayer].getName() + "\"님의 차례");			
				// 이번 게임의 tong 아저씨의 정보를 그대로 그래픽 함수에 넘김
				Graphic.printTong(tong);

				System.out.println();
				
				boolean this_turn = true;
				while(this_turn) {
					int select = 0;
					while(select < 1 || select > size) {
						System.out.printf("찌를 곳의 번호를 선택하세요 (1 ~ %d) : \n", size);
						select = sc.nextInt();


					}
					if(tong.stab(select-1)) 
					{
						// 찌르기도 성공하고 발사도 시킨 경우
						if(tong.launched) {
							
							// 지금 턴의 플레이어는 1패 추가
							// 나머지 플레이어들은 1승 추가
							// 다음 게임으로 넘어가야함
							for (int i = 0; i < numOfPlayer; i++) {
								if (i == turn % numOfPlayer)
								{
									players[i].lose();
									System.out.println(players[i].getName() + "님의 패배!");
									
								}
								else
								{
									players[i].win();
								}
							}
							this_game = false;
							
						}
						else
						{
							// 찔렀지만 발사는 안시킨 경우
							
							//다음 사람이 찌르러 가야 함
							this_turn = false;
						}

						break;

					}
					else
					{
						System.out.println("이미 찔렀던 곳입니다.");
					}
				}
				
				turn++;
			}
			
			System.out.println("새 게임이 시작됩니다!");
			System.out.println("###############################");
			System.out.println("");
			System.out.println("###############################");
		}

	}
	
}
	
/*	public static void main(String[] args) {
		Pirate pirate = new Pirate();
		pirate.create_game();
		pirate.play_game();	

	}

}

class Pirate extends Players {
	int defeat_hole;
	int hole;
	int min_player;
	int[] already_use;
	Scanner sc = new Scanner(System.in);
	Pirate(){
		System.out.print("구멍 수를 설정하세요: ");
		hole = sc.nextInt();
		defeat_hole = (int)(Math.random()*hole+1);
		min_player = 2;
	}
	
	void create_game() {
		System.out.print("플레이어의 수를 설정하세요: ");
		player_count = sc.nextInt();
		if(player_count < min_player)
		{
			while(player_count < min_player) {
				System.out.print("플레이어는 2명이상 이여야합니다 다시 설정해주세요: " );
				player_count = sc.nextInt();
			}
		}
		if(player_count > hole)
		{
			while(player_count > hole) {
				System.out.print("플레이어가 구멍수보다 많습니다 다시 설정해주세요: " );
				player_count = sc.nextInt();
			}
		}
		already_use = new int[hole];
		for(int i = 0; i < already_use.length; i++) {
			already_use[i] = -1;
		}
		
	}
	
	boolean check_sword(int sword) {
		for(int i = 0; i < already_use.length; i++ ) {
			if(sword == already_use[i]) {
				return false;
			}			
		}
		return true;
	}
	
	void play_game() {
		Players[] players = new Players[player_count];
		for(int i = 0; i < players.length; i++) {
			players[i] = new Players();
			players[i].number = i + 1;
		}

		while(sword != defeat_hole) {
			for (int i = 0; i < player_count  ; i++) {
				System.out.printf("%d 플레이어의 차례입니다. 찌를 번호를 입력해주세요: ", players[i].number);
				sword = sc.nextInt();
				if(sword == defeat_hole)
				{
					defeat_player_number = players[i].number;
					break;
				}
				if(sword > hole || sword <= 0) 
				{
					while(sword > hole || sword <= 0) {
						System.out.print("그런 구멍번호는 없습니다 다시 입력해주세요");
						sword = sc.nextInt();
					}

				}
				if(check_sword(sword) == false) 
				{
					while(check_sword(sword) == false) {
						System.out.print("이미 칼이 꼽혀있습니다 다른번호를 선택하세요.");
						sword = sc.nextInt();
						if(sword > hole || sword <= 0) 
						{
							while(sword > hole || sword <= 0) {
								System.out.print("그런 구멍번호는 없습니다 다시 입력해주세요");
								sword = sc.nextInt();
							}
						}
					}
				}
				already_use[use_count++] = sword;
			}
		}

		System.out.printf("해적아저씨가 날라갔습니다. %d플레이어가 패배했습니다.\n", defeat_player_number);


	}

}


class Players{
	int player_count;
	int sword;
	int use_count;
	int number;
	int defeat_player_number;

	
}*/
