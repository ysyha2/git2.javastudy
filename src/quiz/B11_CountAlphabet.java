package quiz;

import java.util.Scanner;

public class B11_CountAlphabet {
	
	/*
		사용자로부터 문장을 하나 입력받고
		해당 문장에 어떤 알파벳이 몇 번 등장했는지 세어서 모두 출력해보세요
		(대소문자도 구분할 것)
	 */
	
	public static void main(String[] agrs) {
		
		System.out.print("문장을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		String sentence = sc.next();
		sentence.charAt(0);

		int[] count = new int[52];
		char[] alphabet = new char[52];
		int j = 0;
		for(char i = 'a'; i <= 'z' ; i++) {
			alphabet[j] = i;
			j++;
	
		}
		for(char i = 'A'; i<= 'Z'; i++) {
			alphabet[j] = i;
			j++;
		}
		for(int i=0; i < sentence.length(); i++) {
			for(j=0; j < alphabet.length; j++) {
				if(alphabet[j] == sentence.charAt(i)) {
					count[j]++;
				}	
			}
	
		}
		System.out.print("입력하신 문장에서 ");
		
		for(int i=0; i<count.length;i++) {
			System.out.printf("%c는 %d회\n ",alphabet[i],count[i]);
		}
		System.out.println("나왔습니다");
		
/*		해설1
		System.out.print("아무 문장이나 입력해주세요 >> ");
		String text = new Scanner(System.in).nextLine();
		
		String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String SYMBOLS = UPPERCASE + UPPERCASE.toLowerCase();
		
		final String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		int[] symbol_count = new int[SYMBOLS.length()];
		
		// Common sense is not so common.
		for (int i = 0, len = text.length(); i < len; i++ ) {
			
			방법1
			SYMBOLS.indexOf(text[i]);
			
			방법2
			char ch = text.charAt(i);
			System.out.println("이번에 검사할 문자는 '" + ch + "'입니다.");
			for(int j = 0, len2 = SYMBOLS.length(); j<len2; j++) {
				if(SYMBOLS.charAt[j] == ch) {
					symbol_count[j]++;
					System.out.println("'" + ch + "'는 SYMBOLS의" 
					+ j + "번째에 있으므로 symbol_count의" + j + "번째 값을 증가시킵니다." );
					break;
				}
			}
		}
		
		
		
		
		해설2
		
		System.out.print("아무 문장이나 입력해주세요 >> ");
		String text = new Scanner(System.in).nextLine();
		
		int[] lowercount = new int[26];
		int[] uppercount = new int[26];
		
		for (int i = 0, len = text.length(); i < len; i++ ) {
			
			char ch = text.charAt(i);
			
			if (ch >= 'a' && ch <= 'z')
			{
				lowercount[ch - 'a']++;
			}
			else if(ch >= 'A' && ch<='Z')
			{
				uppercount[ch - 'A' + 26]++;
			}
		}
		
		for (int i =0; i < 26; i++) {
			System.out.printf("대문자 %c는 %d번 등장했습니다.\n", 'A'+i, uppercount[i]);
			System.out.printf("소문자 %c는 %d번 등장했습니다.\n", 'a'+i, lowercount[i]);
		}
		*/
		
	}

}







