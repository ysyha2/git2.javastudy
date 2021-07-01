package quiz;

import java.util.Scanner;

import myobj.checkpass.*;


public class C17_InputRightPassword {
	
	/*
		# 올바른 패스워드를 만들기 위한 규칙
		
		 1. 모두 숫자이면 안됨
		 
		 2. 대문자와 소문자 숫자 특수문자가 섞여있어야 함
		 
		 3. 특수 문자는 !, @, #, %, ^, &, *만 사용 가능
		 
		 4. 비밀번호의 길이가 8자리 이상 24자리 이하여야 함
		 
		 위의 규칙을 어긴 경우 예외를 발생시켜서 알맞은 안내문구를 출력해보세요
		 (여러 규칙을 한번에 어겼다고 해서 모든 것이 나올 필요는 없음)
	 */

	/* 해설
	public static void main(String[] args) {
		try {
			check_password("12412424141414214");
		}
		catch (IllegalLength e)
		{
			System.out.println("길이가 잘못됐습니다.");
		}
		catch (NumericPassword e)
		{
			System.out.println("모두 숫자인 비밀번호입니다. 사용하시겠습니까? [Y/N]");
		}
		catch (NotSatisfiedPassword e)
		{
			System.out.println("비밀번호에는 숫자, 특수문자, 대문자, 소문자가 모두 포함되어야 합니다.");
		}
		catch (IllegalCharacter e)
		{
			System.out.println("허용되지 않은 문자가 있습니다.");
		}
	}
	
	public static void check_password(String password) 
			throws IllegalLength, NumericPassword, NotSatisfiedPassword, IllegalCharacter {
		
		int len = password.length();
		
		if (len < 8 || len > 24) {
			throw new IllegalLength();
		}
		
		if (check_numberic(password.toCharArray())) {
			throw new NumericPassword();
			
		}
		
		if (!check_character_types(password.toCharArray()))
		{
			throw new NotSatisfiedPassword();
		}
		
	}
	
	private static boolean check_special(char ch) {
		String permit =  "!@#$%^&*";
		for (int i = 0; i < permit.length(); i++) {
			if (ch == permit.charAt(i))
			{
				return true;
			}
		}
		return false;
	}
	
	
	private static boolean check_character_types(char[] pass) throws IllegalCharacter {
		
		int len = pass.length;
		
		boolean num = false;
		boolean low = false;
		boolean upper = false;
		boolean special = false;
		
		
		for (int i = 0; i < len; i++) {
			char ch = pass[i];
			if (ch >= '0' && ch <= '9')
			{
				num = true;
			}
			else if(ch >= 'a' && ch <= 'z')
			{
				low = true;
			}
			else if(ch >= 'A' && ch <= 'Z')
			{
				upper = true;
			}
			else if(check_special(ch))
			{
				special = true;
			}
			else
			{
				throw new IllegalCharacter();
			}
		}
		
		return num && low && upper && special;
		
	}
	
	private static boolean check_numberic(char[] pass) {	
		for (int i = 0, len = pass.length; i < len; i++) {
			char ch = pass[i];
			if(ch < '0' || ch > '9')
			{
				return false;
			}
		}
		return true;
	}
	
}	*/
	public static void main(String[] args) {
		System.out.printf("패스워드를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		String password = sc.nextLine();
		try 
		{
			password_check1(password);
			password_check2(password);
			password_check3(password);
			System.out.println("비밀번호가 설정되었습니다.");
		}
		catch(AllNumberCheck e)
		{
			e.printStackTrace();
		}
		catch(PasswordCheck e)
		{
			e.printStackTrace();
		}
		catch(SpecialSymbolCheck e)
		{
			e.printStackTrace();
		}
		catch(PasswordLengthCheck e)
		{
			e.printStackTrace();
		}
	}
	
	public static void password_check1(String password) throws AllNumberCheck {
		int number_check = 0;
		
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= '0' && password.charAt(i) <= '9' )
			{
				number_check++;
			}
			else
			{
				break;
			}
		}
		if(number_check == password.length()) 
		{
			throw new AllNumberCheck();
		}
	}
	
	public static void password_check2 (String password) throws PasswordCheck, SpecialSymbolCheck {
		int number_check = 0;
		int capital_letter_check = 0;
		int small_letter_check = 0;
		int special_symbol = 0;
		int special_symbol_check = 0;
		int sum_check = 0;
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= '0' && password.charAt(i) <= '9' )
			{
				number_check++;
			}
			else if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z' )
			{
				small_letter_check++;
			}
			else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' )
			{
				capital_letter_check++;
			}
			else 
			{
				special_symbol++;
			}
		}
		
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#' 
					|| password.charAt(i) == '%' || password.charAt(i) == '^' || password.charAt(i) == '&' || password.charAt(i) == '*' )
			{
				special_symbol_check++;
			}
		}
		boolean all_check = (number_check != 0 && capital_letter_check != 0 && small_letter_check != 0 && special_symbol != 0);
		
		if(!all_check) 
		{
			throw new PasswordCheck();
		}
		
		else if(!(special_symbol_check == special_symbol))
		{
			throw new SpecialSymbolCheck();
		}
		
	}
	
	public static void password_check3 (String password)  throws PasswordLengthCheck{
		if(!(password.length() >= 8 && password.length() <=24)) {
			throw new PasswordLengthCheck();
		}


	}

}

class AllNumberCheck extends Exception{
	public AllNumberCheck() {
		super("패스워드가 모두 숫자입니다. 규칙에 맞게 패스워드를 입력해주세요.");
	}
}

class PasswordCheck extends Exception{
	public PasswordCheck() {
		super("패스워드에 소문자, 대문자, 숫자, 특수문자 중 없는것이 있습니다.");
	}
}

class SpecialSymbolCheck extends Exception{
	public SpecialSymbolCheck() {
		super("패스워드에 허용되지 않은 특수문자가 포함되어 있습니다.");
	}
}

class PasswordLengthCheck extends Exception{
	public PasswordLengthCheck() {
		super("패스워드의 길이가 8자리 이상 24자리 이하가 아닙니다.");
	}
}


