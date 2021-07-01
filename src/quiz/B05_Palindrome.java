package quiz;

import java.util.Scanner;

public class B05_Palindrome {

	public static void main(String[] args) {

		System.out.print("단어를 입력하세요 ");
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int word_length = word.length();
		boolean palindrome = true;

		for(int i=0; i<=word_length/2; i++) {
			if(word.charAt(i) != word.charAt(word.length()-1-i))
			{
				i = word_length/2;
				palindrome = false;
			}
		}
		if(palindrome == true)
		{
			System.out.println("PALINDROME");
		}
		else
		{
			System.out.println("NOT PALINDROME");
		}
		
		/*
			# 문장을 거꾸로 뒤집어서 비교하는방법도 있음
		 */
	}
}
