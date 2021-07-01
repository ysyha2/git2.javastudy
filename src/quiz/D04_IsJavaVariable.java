package quiz;

import java.util.Scanner;

public class D04_IsJavaVariable {
	
	/*
		사용자로부터 문자열을 입력받으면 해당 문자열이 자바의 변수로써 사용될 수 있는지
		검사하는 메서드를 만들고 테스트해보세요
	 */
	
	/* 해설
	  public static void main(String[] args) {
		String str = "JAva123";
		
		System.out.println(str.toCharArray());
		
		System.out.println(check("String".toCharArray()));
	}
	
	public static boolean check(char[] str) {
		// Character.isJavaIdentifierStart : 자바 변수명의 첫 번째 글자로 적합한지 체크
		boolean check = Character.isJavaIdentifierStart(str[0]);
		
		// Character.isJavaIdentifierPart : 자바 변수명의 나머지 부분으로 적합한지 체크
		for (int i = 1; i < str.length; i++) {
			check = check && Character.isJavaIdentifierPart(str[i]);
		}
		
		return check;
	}*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요: ");
		String input = sc.nextLine();
		
		test(variable_check(input));
		
	}
	
	public static void test(boolean check) {
		
		if(check)
		{
			System.out.println("이 문자열은 변수명으로 가능합니다");
		}
		else
		{
			System.out.println("이 문자열은 변수명으로 불가능합니다");
		}
		
	}
	
	public static boolean variable_check(String input) {

		int check = 0;
		if(!(input.charAt(0) >= '0'  && input.charAt(0) <= '9'))
		{
			for(int i = 0; i < input.length(); i++) {
				if((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
						|| (input.charAt(i) == '_') || (input.charAt(i) == '&')
						|| (input.charAt(i) >= '0' && input.charAt(i) <= '9'))
				{
					check++;
				}
				else
				{
					break;
				}
			}
		}
		else 
		{
			return false;
		}
		
		if(check == input.length()) {
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
