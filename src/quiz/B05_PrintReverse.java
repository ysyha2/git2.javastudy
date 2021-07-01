package quiz;

import java.util.Scanner;

public class B05_PrintReverse {
	
	public static void main(String[] args) {
		
		System.out.print("문장을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int str_end = str.length()-1;
		for (int i = str_end; i >= 0 ; i--) {
			System.out.print(str.charAt(i));
			
		}
	}

}
