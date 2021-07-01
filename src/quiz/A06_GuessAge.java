package quiz;

import java.util.Scanner;

public class A06_GuessAge {
	
	/*
		사용자로부터 태어난 해와 올해의 년도를 입력받으면
		그 사람의 한국 나이를 계산하여 몇 살인지 알려주는 프로그램을 만들어보세요
	 */
	public static void main(String[] agrs) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("당신이 태어난 해는 몇 년도입니까? ");
		int birth = sc.nextInt();
		System.out.print("올해는 몇년도입니까? ");
		int now = sc.nextInt();
		System.out.printf("당신의 나이는 %d입니다.\n", (now-birth+1));
		
		
		
		
		
	}

}
