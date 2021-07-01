package quiz;

import java.util.Scanner;

public class B03_MonthToSeason {

	public static void main(String[] args) {
		
		int month;
		String season;
		System.out.printf("월을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		month = sc.nextInt();
		switch(month) {
		case 1:
			System.out.println("겨울입니다.");
			break;
		case 2:
			System.out.println("겨울입니다.");
			break;
		case 3:
			System.out.println("봄입니다.");
			break;
		case 4:
			System.out.println("봄입니다.");
			break;
		case 5:
			System.out.println("봄입니다.");
			break;
		case 6:
			System.out.println("여름입니다.");
			break;
		case 7:
			System.out.println("여름입니다.");
			break;
		case 8:
			System.out.println("여름입니다.");
			break;
		case 9:
			System.out.println("가을입니다.");
			break;
		case 10:
			System.out.println("가을입니다.");
			break;
		case 11:
			System.out.println("가을입니다.");
			break;
		case 12:
			System.out.println("겨울입니다.");
			break;
		default:
			System.out.println("존재하지 않는 월입니다.");
			break;
		}
		
	/*	
	 	# 더 간단한 풀이
	 	switch (month) {
		case 12: case 1: case 2:
			season = "겨울";
			break;
		case 3: case 4: case 5:
			season = "봄";
			break;
		case 6: case 7: case 8:
			season = "여름";
			break;
		case 9: case 10: case 11:
			season = "가을";
			break;
		default:
			season = "없음";
			break;
		}
		
		if (month < 1 || month > 12)
		{
			System.out.println("잘못된 월입니다.");
		}
		else
		{
			System.out.printf("%d월은 %s입니다\n", month, season);
		}	

		*/
	}

}
