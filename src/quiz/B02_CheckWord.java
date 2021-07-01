package quiz;

import java.util.Scanner;

public class B02_CheckWord {
	
	public static void main(String[] args) {
		
		String str;
		System.out.print("단어를 입력하세요 ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		
		//boolean 타입을 써서도 가능
		//boolean 타입은 그 자체만으로도 조건이 될 수 있다
		
		if(((str.charAt(0))<'a'||(str.charAt(0))>'z')&&((str.charAt(0))<'A'||(str.charAt(0))>'Z')){
			System.out.println("첫번째 글자가 영어가 아닙니다");
		} else if(str.charAt(0) == str.charAt(str.length()-1)) {
			System.out.println("OK");
		} else {
			System.out.println("NOT OK");
		}
	}

}
