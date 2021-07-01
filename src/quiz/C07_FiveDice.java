package quiz;

import java.util.Scanner;

public class C07_FiveDice {

	/*
		랜덤으로 5개의 주사위를 굴린 다음에 주사위의 결과를 통해 다음을 구분하는 클래스를 만들어보세요

		 1. 풀하우스 (같은 눈이 2개 + 3개) (11666/22333/55252)
		 2. 스몰 스트레이트 (1234/2345/3456)
		 3. 라지 스트레이트 (12345/23456)
		 4. 4 다이스 (같은 숫자 4개)
		 5. 5 다이스 (같은 숫자 5개)

		 (1) 모든 주사위를 한번에 던지는 메서드

		 (2) 원하는 주사위를 제외하고 나머지만 던지는 메서드 (개수 선택 가능)

		 (3) 주사위를 새로 던질 때마다 족보를 확인
	 */

	public static void main(String[] args) {
		Dice game = new Dice();

		game.throwDice();
		game.check();

	}
}

class Dice{
	int number;
	int[] number_collection;
	int[] count;;
	Scanner sc = new Scanner(System.in);
	Dice(){
		number_collection = new int[5];
		count = new int[6];
	}

	void throwDice() {
		System.out.print("주사위는 ");

		for(int i = 0; i < number_collection.length; i++) {
			number = (int)(Math.random()*6 + 1);
			number_collection[i] = number;
			count[number-1]++;
			System.out.print(number_collection[i]  + " ");
		}
		System.out.println("가 나왔습니다");
	}

	void check() {
		int one_count = 0;
		int two_count = 0;
		int choice = 0;
		for(int i = 0; i < count.length; i++) {
			if(count[i] == 5) 
			{
				System.out.println("5다이스 입니다.");
				break;
			}
			else if(count[i] == 4) {
				System.out.println("4다이스 입니다.");
				break;
			}
			else if(count[i] == 3) { 
				for(int j = 0; j < count.length; j++) {
					if(count[j] == 2)
					{
						System.out.println("풀하우스 입니다.");
						break;
					}
				}
			}
			else if(count[i] == 2) {
				two_count++;
			}

			else if(count[i] == 1) 
			{
				one_count++;
				if(one_count == 5 && (count[0] == 0 || count[5] == 0 )) 
				{
					System.out.println("라지스트레이트 입니다.");
					break;
				}
			}	
			if(count[i] == 1) {
				for(int j =0; j < count.length-4; j++) {
					if(count[j] != 0 && count[j+1] != 0 && count[j+2] != 0 && count[j+3] != 0) {
						System.out.println("스몰스트레이트 입니다.");
						break;
					}
				}
			}

		}
		System.out.print("다시 굴리고 싶은 주사위가 있으시면 1을, 없으시면 0을 눌러주세요: ");
		while(true) {
			
			choice = sc.nextInt();
			if(choice == 1 || choice == 0) {
				break;
			}
			else {
				System.out.print("잘못된 숫자입니다 다시 입력해주세요: ");
			}
			
		}
		change(choice);


	}

	void change(int choice) {
		String change_number;
		
		int[] change;
		
		if(choice == 0) {
			System.exit(0);
		}
		else if(choice ==1)
		{
			while(true) {
				System.out.print("바꾸고 싶은 주사위의 위치를 띄어쓰기를 사용하지마시고 말씀해주세요 (1 ~ 5)");
				change_number = sc.next();
				change = new int[change_number.length()];

				for(int i = 0; i < change_number.length(); i++) {
					if(change_number.charAt(i) == '1')
					{
						change[i] = 0;
					}
					else if(change_number.charAt(i) == '2')
					{
						change[i] = 1;
					}
					else if(change_number.charAt(i) == '3')
					{
						change[i] = 2;
					}
					else if(change_number.charAt(i) == '4')
					{
						change[i] = 3;
					}
					else if(change_number.charAt(i) == '5')
					{
						change[i] = 4;
						
					}
				}
				break;
			}
 

			for(int i = 0 ; i < change.length ; i ++) {
				number = (int)(Math.random()*6 + 1);
				count[number_collection[change[i]] - 1]--;
				number_collection[change[i]] = number;
				count[number-1]++;
			}
			System.out.print("주사위는 ");
			
			for(int i = 0; i < number_collection.length; i++) {
				System.out.print(number_collection[i]  + " ");
			}
			System.out.println("로 바뀌었습니다");
		}

		check();

	}
	

}



















