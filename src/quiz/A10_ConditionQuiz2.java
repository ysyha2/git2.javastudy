package quiz;

import java.util.Scanner;

public class A10_ConditionQuiz2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char a = 'Q';
		char b = ' ';
		char c = '1';
		char d = 'd';
		char e = '하';
		char f = 'e';
		
		System.out.println(a == 81 || a == 113);
		System.out.println(b!=32 && b!=9);
		System.out.println(c>=48 && c<=57); //System.out.println(c>= '0' && c<= '9')
		System.out.println((d>=65 && d<=90) || (d>=97 && d<=122)); //System.out.println((d >= 'a' && d <= 'z')) || (d >= 'A' && d <= 'Z')); 
		System.out.println(e>=0xAC00 && e<=0xD7AF); //System.out.println( e >= '가' && e <= '힣');
		System.out.println(f>=0x3040 && f<=0x30FF); //System.out.println((f>=0x3041 && f<=0x3096) || (f>=0x30A1 && f<=0x30FF));		
		
		System.out.print("exit를 입력하면 true가 나옵니다 > ");
		String txt = sc.nextLine();
		System.out.println(txt.equals("exit"));
		
	}

}
