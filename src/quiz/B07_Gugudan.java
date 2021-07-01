package quiz;

public class B07_Gugudan {
	
	/*
		1. 구구단 가로로 출력
		
		2. 구구단 세로로 출력
	 */
	public static void main(String[] args) {
		
		// 1번문제

		for (int dan = 2; dan <= 9; dan++) {
			
			System.out.printf("%d단: ", dan);
			
			for (int gop = 1; gop <= 9; gop++) {
				
				System.out.printf("%dx%d=%02d", dan, gop, dan*gop);
			}
			System.out.println("");
		}
		System.out.println("");
		
		// 2번문제
		for (int gop = 0; gop <= 9; gop++) {

			for (int dan = 2; dan <= 9; dan++) {
				if(gop ==0)
				{	
					System.out.printf("%d단\t", dan);
				}
				else
				{
					System.out.printf("%dx%d=%d\t", dan, gop, dan*gop);
				}
			}
			System.out.println("");

		}

	}

}
