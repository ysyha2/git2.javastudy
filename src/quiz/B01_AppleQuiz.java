package quiz;

import java.util.Scanner;

public class B01_AppleQuiz {
	
	public static void main(String[] args) {
		
		System.out.print("구매하실 사과의 개수는? ");
		Scanner sc = new Scanner(System.in);
		int apple = sc.nextInt();
		int basket = 0;
		//int basket_size = 10;
		if(apple % 10 == 0) {
			basket = apple / 10;
		} else {
			basket = apple / 10 + 1 ;
		}
		
		if(apple <0) {
			System.out.println("올바른 사과 개수가 아닙니다.");
		} else {
			System.out.printf("필요한 상자의 개수는 %d입니다\n", basket);
		}
		
		// basket을 double로 한뒤 10.0으로 나누고 math함수쓰고 int로 형변환
		// Math.ceil(a) : a를 올린다
		// Math.floor(a) : a를 소수 첫재 자리에서 내린다
		// Ctrl + / : 주석처리
		// Ctrl + Shift + b : breakpoint (f11로 디버그모드 가능)
	}

}
