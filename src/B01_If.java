
public class B01_If {
	
	
	/*
		# if문
		  - ()안의 값이 true일 때 {}안의 내용을 실행한다
		  - ()안의 값이 false일 때 {}안의 내용을 무시한다
		  - {}안에서 실행할 내용이 단 한 줄이라면 {}를 생략할 수 있다 (일부러 하지 않는 경우가 많음)
		  
		# else if문
		  - 위에 있는 if문이 실행되지 않았다면 밑에서 if문처럼 동작한다
		  - else if는 단독으로 사용될 수 없다
		  - else if는 여러번 사용할 수 있다
		
		# else문
		  - 위에 있는 모둔 if문과 else if문이 모두 실행되지 않았다면 {}안의 내용을 무조건 실행한다
		  - if문 바로 다음에 사용할 수도 있다
	 */
	
	public static void main(String[] args) {
		
		char ch = '1';
		
		if (ch >= '가' && ch <= '힣') {
			System.out.println("ch에 들어있는 값은 한글입니다!");
			System.out.println("if문 끝!");
		} else if(ch >= 'a' && ch <= 'z') {
			System.out.println("ch에 들어있는 값은 알파벳 소문자입니다!");
		} else if(ch >= 'A' && ch <= 'Z') {
			System.out.println("ch에 들어잇는 값은 알파벳 대문자입니다!");
		} else {
			System.out.println("ch에 들어있는 문자는 알파벳도 아니고 한글도 아닙니다!");
		}
		
		System.out.println("프로그램 끝");
		
	}

}





