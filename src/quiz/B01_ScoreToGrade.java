package quiz;

import java.util.Scanner;

public class B01_ScoreToGrade {
	
	public static void main(String[] args) {
		
		int score;
		char grade;
		System.out.print("점수를 입력하세요(0~100) ");
		
		// ※ 입력을 받았을 때는 잘못된 값을 먼저 거르는 것이 좋다
		Scanner sc = new Scanner(System.in);
		score = sc.nextInt();
		
		if(score >=0 && score<=100) {
			if(score >= 90) {
				grade = 'A';
			} else if(score >=80 && score<90) {
				grade = 'B';
			} else if(score >=70 && score<80) {
				grade = 'C';
			} else if(score >=60 && score<70) {
				grade = 'D';
			} else {
				grade = 'F';
			}
			System.out.printf("해당 점수의 등급은 %c 입니다", grade);
		} else {
			System.out.print("입력하신 점수는 유효한 점수가 아닙니다");
		}
	/*
		if (score < 0 || score > 100){
			System.out.println("잘못된 점수입니다.");
		} else if{ 로 점수조건
		
		
		System.out.printf("당신의 등급은 %c입니다. \n", grade)
		
		
	 */
		
		
	}

}
