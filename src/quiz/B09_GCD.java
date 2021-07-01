package quiz;

import java.util.Scanner;

public class B09_GCD {
	
	/*
		두 숫자를 입력받고 두 숫자의 최대공약수를 구해보세요
		
		# 최대 공약수
		
		  - 두 숫자의 공약수 중 가장 큰 공약수

	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요: ");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요: ");
		int num2 = sc.nextInt();
		int gcd = 1;
		int smaller_num = num1 > num2 ? num2 : num1;
		
//		int max = Math.max(num1, num2);
//		int min = Math.min(num1, num2);
		
		for(int i =1; i <=  smaller_num; i++) {
			if(num1 % i == 0 && num2 % i == 0)
			{
				gcd = i;
			}
		}
		System.out.printf("%d와 %d의 최대공약수는 %d입니다\n",num1,num2,gcd);
		
		
	}

}
