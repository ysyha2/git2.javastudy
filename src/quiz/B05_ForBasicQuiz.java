package quiz;

import java.util.Scanner;

public class B05_ForBasicQuiz {
	
	public static void main(String[] args) {
		
		int num;
		int sum = 0;
		System.out.print("숫자를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		
		//1번 문제
		if(num>=10)
		{
			for(int i = 10; i <= num; i++) {
				sum += i;
			}
			
		}
		else
		{
			for(int i = 10; i >= num; i--) {
				sum += i;
			}
		}
		
	/*	int start, end;
		if (num > 10)
		{
			start = 10;
			end = num;
		}
		else
		{
			start = num;
			end = 10;
			
		}
		for (int i = start; i <= end; i++) {
			sum += i;
		}
		*/
		System.out.printf("10부터 %d까지의 합은 %d입니다\n", num, sum);
		
		//2번 문제
		if(num<=1000)
		{
			for(int i = 1000; i>= num; i--) {
				System.out.println(i);
			}
		}
		else
		{
			for(int i = 1000; i<= num; i++) {
				System.out.println(i);
			}
		}
		//3번 문제
		if (num > 1)
		{
			for(int i = 1; i<=num; i++) {
				if(i%5==0)
				{
					System.out.println(i);
				}
			}

		}
		else
		{
			for(int i = 1; i>=num; i--) {
				if(i%5==0)
				{
					System.out.println(i);
				}
			}	
		}
	}

}
