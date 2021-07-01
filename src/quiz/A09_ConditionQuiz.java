package quiz;

public class A09_ConditionQuiz {
	
	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		int c = 3;
		int hour = 25;
		int d = 5;
		int e = 6;
		int year = 7;
		int minsuAge = 8;
		int chulsuAge = 9;
		int minsuBirthMonth = 10;
		int chulsuBirthMonth = 11;
		boolean powerOn = true;
		
		System.out.println(a > 10 && a < 20);
		System.out.println(b % 2 == 0 );
		System.out.println(c % 7 == 0 );
		System.out.println(!(hour < 0 || hour >= 24) && hour >= 12 );
		System.out.println(Math.abs(d - e) == 30 );
		System.out.println(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)); // 윤년 지식형문제
		System.out.println(minsuAge - chulsuAge == 2);
		System.out.println(chulsuBirthMonth - minsuBirthMonth == 3 );
		System.out.println(powerOn == false);
		

		String str = "yes";
		String str2 = "yes";
		String str3 = new String("yes"); // 뭐가됐던간에 새로 하나를 만듬, 새로운 주소
		
		// 참조형 변수의 == 비교는 두 변수가 서로 같은 주소를 지니고 있는지를 비교한다
		System.out.println("str == \"yes\" : " + (str == "yes"));
		System.out.println("str == str2 : " + (str == str2));
		System.out.println("str == str3 : " + (str == str3));
		
		// 타입명이 대문자로 시작하는 참조형 변수들은 반드시 equals()를 이용해 비교해야 한다
		System.out.println(str.equals("yes"));
		System.out.println(str.equals(str3));
		
		// 소문자로 시작하는 타입 변수들은 stack에 차곡차곡 쌓인다
		// 대문자로 시작하는 타입 변수들은 stack에는 주소값만 보관하고 실체는 heap에 존재한다
		// 대문자로 시작하는 타입 변수에는 주소값이 저장되어 있고, 거기에 .을 찍고 실제 데이터를 참조할 수 있다
		
		
		
		
		
		
	}

}
