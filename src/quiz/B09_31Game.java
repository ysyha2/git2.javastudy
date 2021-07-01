package quiz;

import java.util.Scanner;

public class B09_31Game {
	
	/*
		# 31 게임을 만들어보세요
		
		1. 컴퓨터와 사람이 번갈아가면서 숫자를 선택해야 한다.
		   (1, 2, 3 밖에 선택할 수 없음)
		 
		2. 컴퓨터는 랜덤으로 숫자를 선택한다
		
		3. 선공은 랜덤으로 결정한다
		
		4. 마지막에 31이상의 숫자를 부르는 플레이어가 패배한다.
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int now_number = 0;
		int turn = (int)(Math.random()*2+1);
		while(true) {
			int my_number = 0;
			int com_number = 0;
			if(turn == 1)
			{
				System.out.print("부를 숫자의 갯수를 말하세요: ");
				my_number = sc.nextInt();
				while(my_number > 3)
				{
					System.out.print("사용자가 부른 숫자의 갯수가 3개를 초과했습니다 다시 입력해주세요: ");
					my_number = sc.nextInt();
					continue;
				}
				now_number += my_number;
				System.out.printf("사용자가 %d를 불러서 현재 숫자는 %d 입니다\n", my_number, now_number);
				if(now_number>=31)
				{
					System.out.print("사용자가 31이상을 불러 사용자가 패배했습니다.");
					break;
				}
				com_number = (int)(Math.random()*3+1);
				now_number += com_number;
				System.out.printf("컴퓨터가 %d를 불러서 현재 숫자는 %d 입니다\n", com_number, now_number);
				if(now_number>=31)
				{
					System.out.print("컴퓨터가 31이상을 불러 컴퓨터가 패배했습니다.");
					break;
				}
			}
			else
			{
				com_number = (int)(Math.random()*3+1);
				now_number += com_number;
				System.out.printf("컴퓨터가 %d를 불러서 현재 숫자는 %d 입니다\n", com_number, now_number);
				if(now_number>=31)
				{
					System.out.print("컴퓨터가 31이상을 불러 컴퓨터가 패배했습니다.");
					break;
				}
				System.out.print("부를 숫자의 갯수를 말하세요: ");
				my_number = sc.nextInt();
				while (my_number > 3)
				{
					System.out.print("사용자가 부른 숫자의 갯수가 3개를 초과했습니다 다시 입력해주세요: ");
					my_number = sc.nextInt();
					continue;
				}
				now_number += my_number;
				System.out.printf("사용자가 %d를 불러서 현재 숫자는 %d 입니다\n", my_number, now_number);
				if(now_number>=31)
				{
					System.out.print("사용자가 31이상을 불러 사용자가 패배했습니다.");
					break;
				}
			}
		}
		
		/*
		//해설
		turn = (int)(Math.random() *2);
		int num = 0;
		
		if (turn == 0)
		{
			System.out.println("컴퓨터 선공!");
		}
		else
		{
			System.out.println("당신의 선공!");
		}
		
		while(num < 31) {
			
			if ( turn == 0) 
			{
				int com = (int)(Math.random() * 3 + 1);
				num += com;
				System.out.printf("컴퓨터 %d를 골랐습니다. [현재 숫자:%d]\n",com);
			}
			else
			{
				int user = 0;
				while ( user < 1 || user > 3){
					System.out.print("1, 2, 3? ");
					user += sc.nextInt(0);
				}
				num += user;
				System.out.printf("[현재 숫자:%d]\n", num);
				
			}
			
			// 턴은 0과 1만 반복되게 함
			turn = (turn + 1) % 2;
		}
	
	1번	
		if ( turn == 0)
		{
			System.out.println("게임 종료! 컴퓨터의 승리!\n");
		}
		else
		{
			System.out.println("게임 종료! 플레이어의 승리 승리!\n");
		}
	2번
		String winner = turn == 0 ? "컴퓨터" : "플레이어"; // 삼항 연산자
		System.out.printf("게임 종료! %s의 승리!\n", winner);
	3번
		System.out.printf("게임 종료! %s의 승리!\n", turn == 0 ? "컴퓨터" : "플레이어");
		
		int apple = 15;
		int basket = apple % 10 != 0 ? apple / 10 + 1 : apple / 10;
		
		char ch = '0';
		String msg = ch >= 'A' && ch <= 'Z' ? "대문자입니다." : " 대문자가 아닙니다" ; 
		
*/
	}
	
}
