package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class D09_BruteForce {
	
	/*
 		
 		# 비밀번호의 길이를 입력받으면 다음 문자로 만들 수 있는 모든 해당 길이의 비밀번호를 출력해보세요
 		
 		 - 영어 대/소문자
 		 - 숫자
 		 - 특수문자 (Shift누르고 숫자에 있는것들만)
 		 
 		 ex: 4 -> 0000 ~ zzzz
	 */
	static String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-+";
	
	public static void main(String[] args) {
		bruteforce(2);
	}
	
	public static void bruteforce(int password_size) {
		char[] arr = charset.toCharArray();
		int len = charset.length();
		long all_password =(long)(Math.pow(len, password_size));
		
		for(long i = 0; i < all_password; i++) {
			long value = i;
			
			String password = "";
			
			while (value > 0 ) {
				password += arr[(int)value % len];
				value /= len;
			}
			
			if(password.length() < password_size)
			{
				int gap = password_size - password.length();
				for (int j = 0; j < gap; j++) {
					password = "a" + password;
				}
			}
			System.out.println(password);
		}
	}
	
	
	/*
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호의 길이를 입력하세요 :");
		int password_length = sc.nextInt();
		password(password_length);
	}
	
	public static void password(int password_length) {
		ArrayList<Character> text = new ArrayList<>();
		for(char i = '0'; i <= '9'; i++) {
			text.add(i);
		}
		for(char i = 'a'; i <= 'z'; i++) {
			text.add(i);
		}
		for(char i = 'A'; i <= 'Z'; i++) {
			text.add(i);
		}
		text.add('!');
		text.add('@');
		text.add('#');
		text.add('$');
		text.add('%');
		text.add('^');
		text.add('&');
		text.add('*');
		text.add('(');
		text.add(')');
		
		ArrayList<String> password_list = new ArrayList<>();

		String[] splited = create_all_password(text, "", password_length).split(",");
		for(String password : splited) {
			password_list.add(password);
		}
		int count = 1;
		for(String result : password_list) {
			System.out.println((count++) + ": " + result);
		}
	}
	
	public static String create_all_password(ArrayList<Character> text ,String pre_password, int len) {
		String password = "";
		if(len == 0) 
		{
			return pre_password + ",";
		}
		
		for(char c : text) {
			String new_password = pre_password + c;
			password += create_all_password(text, new_password, len - 1);
		}
		return password;
	}*/

}
