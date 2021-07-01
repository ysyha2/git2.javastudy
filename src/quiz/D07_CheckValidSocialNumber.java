package quiz;

import java.util.Collections;
import java.util.HashSet;

public class D07_CheckValidSocialNumber {
	
	/*
		사용자가 주민등록번호를 입력하면
		그 주민등록번호가 유효한지 검사하는 프로그램을 만들어보세요
		
		맨앞 2자리 숫자
		월 자리에 01 ~ 12 이내의 숫자
		일 자리에 01 ~ 31 이내의 숫자
		(1, 3, 5, 7, 8, 10, 12월이면 31 / 4, 6, 9 ,11월 이면 30 / 2월은 윤년일때 29 아니면 28)
		7번째 자리 '-'
		뒷자리 전부 숫자
	 */
	
	private static HashSet<Integer> month30;
	private static HashSet<Integer> month31;
	private static HashSet<Integer> gender;
	
	static {
		month30 = new HashSet<>();
		month31 = new HashSet<>();
		
		Collections.addAll(month30, 4, 6, 9, 11);
		Collections.addAll(month31, 1, 3, 5, 7, 8, 10, 12);
	}
	
	private static boolean validGender(char gender) {
		return gender >= '1' && gender <= '4';
	}
	
	private static int calcYear(int year, char gender) {
		return gender < '3' ? year + 1900 : year + 2000;
	}
	
	public static boolean check(String sn) {
		char[] sn_arr = sn.toCharArray();
		
		
		if(!validGender(sn_arr[7]))
		{
			System.out.println("[WARNING] 성별에 문제가 있습니다.");
			return false;
		}
		
		int year = calcYear(Integer.parseInt("" + sn_arr[0] + sn_arr[1]),
				sn_arr[7]);
		int month = Integer.parseInt("" + sn_arr[2] + sn_arr[3]);
		int date = Integer.parseInt("" + sn_arr[4] + sn_arr[5]);
		
		if (month30.contains(month) && (date < 1 || date > 30))
		{
			System.out.println("[WARNING] 날짜에 문제가 있습니다.");
			return false;
		}
		else if (month31.contains(month) && (date <1 || date > 31))
		{
			System.out.println("[WARNING] 날짜에 문제가 있습니다.");
			return false;
		}
		else if(month == 2)
		{
			boolean leapYear = (year % 400 == 0) 
					|| (year % 4 == 0 && year % 100 != 0);
			
			if(leapYear && (date < 1 || date > 29))
			{
				System.out.println("[WARNING] 윤년은 29일까지 입니다.");
				return false;
			}
			else if(!leapYear && (date < 1 || date > 28))
			{
				System.out.println("[Warining] 2월은 28일까지 입니다.");
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		if(check("000229-1234567"))
		{
			System.out.println("올바른 주민번호입니다.");
		}
		else 
		{
			System.out.println("잘못된 주민번호입니다.");
		}
	}
	
	
	
	/*
	public static void main(String[] args) {
		System.out.printf("주민등록번호를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		String social_number = sc.nextLine();
		check_social_number(social_number.toCharArray());
	}
	
	public static void check_social_number(char[] social_number) {
		boolean check = true;
		if(social_number.length != 14) {
			check = false;
			System.out.println("길이가 올바르지 않습니다.");
		}
		else if(!check_numeric(social_number))
		{
			check = false;
			System.out.println("숫자가 아닌 문자가 들어가있거나 -의 위치가 이상합니다.");
		}
		else if(!check_condition(social_number))
		{
			check = false;
		}
		
		System.out.println(new String(social_number) + "는 " 
		+ (check ? "올바른 주민등록번호 입니다." : "올바르지 않은 주민등록번호 입니다."));
		
	}
	
	public static boolean check_numeric(char[] social_number) {
		for(int i =0; i < social_number.length; i++) {
			if( i == 6 && social_number[i] == '-') 
			{
				continue;
			}
			else if( i != 6 && Character.isDigit(social_number[i]))
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
	
	public static boolean check_condition(char[] social_number) {
		int year = (social_number[0] - '0') * 10 + (social_number[1] - '0');
		int month = ((social_number[2] - '0') * 10 + (social_number[3] - '0'));
		int day = ((social_number[4] - '0') * 10 + (social_number[5] - '0'));

		if(year >= 21)
		{
			year += 1900;
		}
		
		else
		{
			year += 2000;
		}		

		
		if(!(month >=1 && month >= 12)) {
			return false;
		}
		
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			if(!(day >= 1 && day <= 31 ))
			{
				return false;
			}
		}
		else if(month == 2)
		{			
			if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			{
				if(!(day>= 1 && day <= 29 ))
				{
					return false;
				}
			}
			else
			{
				if(!(day >= 1 && day <= 28))
				{
					return false;
				}
			}
		}
		
		else
		{
			if(!(day >= 1 && day <= 30 ))
			{
				return false;
			}
		}
		if(year >= 2000) {
			if(social_number[7] != 3 && social_number[7] != 4)
			{
				System.out.println("주민번호 뒷자리 첫번째숫자가 올바르지 않습니다.");
				return false;
			}
		}
		else if(year < 2000) {
			if(social_number[7] != 1 && social_number[7] != 2)
			{
				System.out.println("주민번호 뒷자리 첫번째숫자가 올바르지 않습니다.");
				return false;
			}
		}
		
		System.out.println(year);
		return true;
		
	}*/


}















