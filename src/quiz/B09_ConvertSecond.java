package quiz;

import java.util.Scanner;

public class B09_ConvertSecond {
	
	/*

		초를 입력받으면 년/일/시간/분/초로 변환하여 출력해보세요
		
		※ 단, 필요없는 단위는 출력하지 말 것
		
		  ex: 0년 0일 13시간 0분 5초인 경우 -> 13시간 0분 5초

	 */
	public static void main(String[] args) {
		int year;
		int day;
		int hour;
		int minute;
		int second;
		
		int result_year;
		int result_day;
		int result_hour;
		int result_minute;
		int result_second;
		
		System.out.print("초를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		int enter_second = sc.nextInt();
		second = enter_second % 60;
		minute = enter_second / 60;
		hour = minute / 60;
		day = hour / 24;
		year = day / 365;
		
		result_second = second;
		result_minute = minute;
		result_hour = hour;
		result_day = day;
		result_year = year;
		
		
		if(year != 0)
		{
			day -= (year * 365);
			System.out.printf("%d년 " , year);
		}
		if(day != 0)
		{
			hour -= (result_day *24);
			System.out.printf("%d일 ",day);
		}
		if(hour != 0 || day != 0)
		{
			minute -= (result_hour *60);
			System.out.printf("%d시간 ",hour);
		}
		if(minute != 0 || day!= 0 || hour != 0)
		{
			System.out.printf("%d분 ", minute);
		}
		
		System.out.printf("%d초", second);

		
		/*해설

		System.out.print("초 > ");
		int second = new Scanner(System.in).nextInt();
		
		int y = 0, d = 0, h = 0, m = 0, s = 0;
		
		final int SECOND_PER_YEAR = 365 * 24 * 60 * 60;
		final int SECOND_PER_DAY = 24 * 60 * 60;
		final int SECOND_PER_HOUR = 60 * 60;
		final int SECOND_PER_MINUTE = 60;
		
		System.out.printf("'%d'초는 변환하면 ", second );
		
		y = second / SECOND_PER_YEAR;
		second %= SECOND_PER_YEAR;
	
		d = second  / SECOND_PER_DAY;
		second %= SECOND_PER_DAY;
		
		h = second / SECOND_PER_HOUR;
		second %= SECOND_PER_HOUR;
		
		m = second / SECOND_PER_MINUTE;
		second %= SECOND_PER_MINUTE;
		
		
		boolean exist = false;

		if (y != 0) {
			System.out.print(y + "년 ");
			exist = true;
		}
		if (d != 0 || exist) {
			System.out.print(d + "일 ");
			exist = true;
		}
		if (h != 0 || exist) {
			System.out.print(h + "시간 ");
			exist = true;
		}
		if (m != 0 || exist) {
			System.out.print(m + "분 ");
			exist = true;
		}
		System.out.println(second + "초 입니다");
	
		
		배열이용
		
		System.out.print("초 > ");
		int second = new Scanner(System.in).nextInt();
		
		int[] coverted = new int[4];
		int[] seconds = new int[4];
		String[] units = {"년", "일", "시", "분"};
		
		seconds[0] = 365 * 24 * 60 * 60;
		seconds[1] = 24 * 60 * 60;
		seconds[2] = 60 * 60;
		seconds[3] = 60;
		
		for( int i =0; i < converted.length; i++) {
			converted[i] = second / seconds[i];
			second %= seconds[i];
		}
		
		boolean exist = false;
		for (int i = 0; i < converted.length; i++) {
			if(converted[i] ! = 0 || exist) {
				System.out.printf("%d%s ", converted[i], units[i] );
				exist = true;
			}
		}
		System.out.printf("%d초", second);
		System.out.println();
		
	*/


	} 
}














