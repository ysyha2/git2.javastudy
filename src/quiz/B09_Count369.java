package quiz;

import java.util.Scanner;

public class B09_Count369 {
	
	/*
		사용자로부터 정수를 하나 입력받은 후
		해당 숫자까지 369 게임이 진행된다면 박수를 총 몇번 쳐야하는지 세어보세요
		
		(※ 33, 36, 39...등의 숫자는 여러번칩니다.)

	 */
	
	public static void main(String[] args) {
		
		/*
			문제해결력 - 문제를 푸는 길을 찾는 것
			구현력 - 생각해낸 길을 코드로 구현하는 것
			프로그래밍 언어 이해력 - 사용하는 언어에 대한 깊은 이해도
			
			국어 - 한글을 이해할 수 있어야 함
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int num = sc.nextInt();
		int clap = 0;
		int exponent = 0;
		int number_check = 0 ;
		for(int i = 1; i <= num; i++) {
			number_check = (int)(i / Math.pow(10, exponent));
			if(number_check == 10) {
				exponent ++;
			}
			for(int j = 0; j <= exponent; j++) {
				if( (int)((i / Math.pow(10, j))) % 10 == 3 || ((int)(i / Math.pow(10, j))) % 10 == 6 
						|| ((int)(i / Math.pow(10, j))) % 10 == 9)
				{
					clap++;
				}
			}
		}
		System.out.printf("369게임을 했을때 %d숫자까지 총 박수친 횟수는 %d 입니다\n",num,clap);
		
/*			해설
		Scanner sc = new Scanner(System.in);
		
		System.out.print("박수 체크해볼 숫자 > ");
		int num = sc.nextInt();
		int count = 0;	
		for (int i = 1; i <= num; i++) {
			
			int checkNum = i;
			System.out.printf("[%d]\t: ", checkNum);
			while(checkNum != 0) {
				int digit = checkNum % 10;
				if (digit != 0 && digit % 3 ==0) {
					System.out.print("짝");
					count++;
				}
				checkNum /= 10;
			}
			System.out.println();
		}
		System.out.printf("박수는 총 %d회 쳤습니다.\n",count);
		*/
		
		
	}

}
