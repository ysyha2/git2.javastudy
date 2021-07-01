package quiz;

public class WhileBasicQuiz {
	
	/*
		While문을 이용하여 다음을 구하시오
		
		1. 1 부터 100 사이에 있는 3의 배수의 총합
		
		2. 355 부터 237까지 출력
		
		3. continue를 반드시 사용하여 3000부터 5000사이의 7의 배수만 출력하기
		
		4. 1부터 200까지의 숫자 중 2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합
	 */
	
	
	public static void main(String[] args) {
		
		// 1번문제
		
		int i = 0;
		int sum = 0;
		while (i<100) {
			i++;
			if(i % 3 == 0)
			{
				sum += i;
			}
			
		}
		System.out.printf("1부터 100사이에 있는 3의 배수의 총합은 %d입니다 \n",sum);
		
		// 2번문제
		i = 356;
		
		while(i > 237) {
			i--;
			System.out.println(i);
			
		}

		
		
		
		
		// 3번문제
		
		i = 2999;
		while(i<5000) {
			i++;
			if(i % 7 != 0) 
			{
				
				continue;
			}
			else 
			{
				System.out.println(i);
			}
			
		}
		
		
		
		// 4번문제
		
		i = 0;
		sum = 0;
		while(i<200) {
			i++;
			if( i % 2 != 0 && i % 3 != 0)
			{
				sum += i;
			}
			
		}
		System.out.printf("1부터 200까지의 숫자 중 2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합은 %d 입니다 \n", sum);

		
		
		


		
	}

}
