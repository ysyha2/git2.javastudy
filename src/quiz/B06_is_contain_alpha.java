package quiz;

import java.util.Scanner;

public class B06_is_contain_alpha {

	/*
			1. 사용자가 입력한 문자열에 알파벳이 포함되어 있으면 true를 출력, 없으면 false를 출력
			
			2. 사용자가 입력한 문자열이 알파벳으로만 이루어져 있으면 true, 아니면 false 
			
			3. 사용자가 허락한 문자만으로 이루어진 문자열이라면 true, 아니면 false
			   (허락한 문자: 알파벳 소문자, 숫자, _, &, 첫번째 문자에 숫자 불가)
			
	 */
	public static void main(String[] args) {
		
		System.out.print("단어를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		boolean contain_alpha = false;
		boolean all_alpha = true;
		// 1번문제
		for(int i = 0 ; i < word.length(); i++) {
			if((word.charAt(i) >= 'a' && word.charAt(i)<='z') || (word.charAt(i) >= 'A' && word.charAt(i)<='Z') )
			{
				contain_alpha = true;
				break; // for(int i =0; i< word.length() && !contain; i++)도 가능
			}
		}
			System.out.println("문자열에 알파벳이 있습니까? "+ contain_alpha);
		
		// 2번문제
		
			for(int i = 0 ; i < word.length(); i++) {
				if(!((word.charAt(i) >= 'a' && word.charAt(i)<='z') || (word.charAt(i) >= 'A' && word.charAt(i)<='Z')) )
				{
					all_alpha = false;
					break;
				}
			}
			System.out.println("모든 문자열이 알파벳 입니까? " + all_alpha);
			
		// 3번문제	
			
			boolean user_condition = false;
			// first_letter_check = !(word.charAt(0) >= '0' && word.charAt(0) <= '9'); 이용가능
			for(int i = 0; i < word.length(); i++) {
				if(!(word.charAt(0) >= '0' && word.charAt(0) <= '9'))
				{
					if((word.charAt(i) >= 'a' && word.charAt(i)<='z') || (word.charAt(i) >= '0' && word.charAt(i)<='9') 
							|| word.charAt(i) == 95 || word.charAt(i) == 38)
					{
						user_condition = true;

					}
				}
				
				
			}
			System.out.println("입력한 문자열이 사용자가 허락된 문자로만 이루어져 있습니까? " + user_condition);
			
		
			
	}
}
