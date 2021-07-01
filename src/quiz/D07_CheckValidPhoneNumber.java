package quiz;

import java.util.Scanner;

public class D07_CheckValidPhoneNumber {
	
	/*
		사용자로부터 입력받은 문자열이 핸드폰 번호인지 구분하는 프로그램을 만들어보세요
		
	 */
	
	/* 해설
	private static boolean checkNumeric(char[] phoneNumber) {
		for (int i = 0; i < phoneNumber.length; i++) {
			if ((i == 3 || i == 8) && phoneNumber[i] == '-')
			{
				continue;
			}
			else if ((i != 3 && i != 8) && Character.isDigit(phoneNumber[i]))
			{
				continue;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	public static void checkValidPhoneNumber(char[] phoneNumber) {
		boolean valid = true;
		// ""가 있는 이유는 문자열에 붙여서 문자열로 만들려고
		String front = "" + phoneNumber[0] + phoneNumber[1] + phoneNumber[2];
		
		if (!front.equals("010"))
		{
			valid = false;
			System.out.println("[WARNING] 맨 앞의 숫자가 허용되지 않는 숫자입니다.");
		}
		else if(phoneNumber.length != 13)
		{
			valid = false;
			System.out.println("[WARNING] 핸드폰 번호의 길이가 아닙니다.");
		}
		else if(!checkNumeric(phoneNumber))
		{
			valid = false;
			System.out.println("[WARNING] 숫자 아닌 문자가 포함되었거나 -의 위치가 이상합니다.");
		}
		
		System.out.println(new String(phoneNumber) + "는 " 
		+ (valid ? "올바른 핸드폰 번호입니다." : "올바르지 않은 핸드폰 번호입니다."));
 	}
	
	public static void main(String[] args) {
		checkValidPhoneNumber("010-1234-1234".toCharArray());
	} */
	
	public static void main(String[] args) {
		
		System.out.printf("핸드폰 번호를 -를 포함해서 입력해주세요: ");
		Scanner sc = new Scanner(System.in);
		String phone_number = sc.nextLine();
		while(!test(phone_number)) {
			System.out.printf("다시 핸드폰 번호를 -를 포함해 입력해주세요: ");
			phone_number = sc.nextLine();
		}
		
		
		
	}
	
	public static boolean test(String number) {
		if(check_number_length(number) && check_number_type(number))
		{
			System.out.println("입력하신 문자열은 핸드폰번호로 사용할 수 있습니다.");
			return true;
		}
		else
		{
			System.out.println("입력하신 문자열은 핸드폰번호로 사용할 수 없습니다.");
			return false;
		}
	}
	
	public static boolean check_number_length(String number) {
		String[] number_list = new String[3];
		number_list = number.split("-");
		if(number_list[0].length() == 3 && number_list[1].length() == 4
				&& number_list[2].length() == 4)
		{
			return true;
		}
		return false;
		
	}
	
	public static boolean check_number_type(String number) {
		String[] number_list = new String[3];
		number_list = number.split("-");
		for(int i = 0; i < number_list.length; i++) {
			for(int j = 0; j < number_list[i].length(); j++) {
				if(number_list[i].charAt(j) >= '0' && 
						number_list[i].charAt(j) <= '9'	)
				{
					continue;
				}
				else
				{
					return false;
				}
			}
		}
		return true;
	}

}










