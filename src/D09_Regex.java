import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D09_Regex {
	
	/*
		# 정규표현식 (Regular Expression)
		
		 - 문자열의 패턴을 표현할 수 있는 표현식
		 - 특정 프로그래밍 언어에 종속되지 않는 공통의 규칙이다
		 - 정의한 문자열 패턴과 일치하는 문자열을 걸러낼 수 있다
		 
		# Java에서 정규표현식을 다룰 때 사용하는 클래스
		
		 - Pattern
		 - Matcher
		
		
	 */
	
	public static void main(String[] args) {
		
		// Pattern.matches(regex, input) : input이 regex에 일치하는지 여부를 검사
		System.out.println(Pattern.matches("sleep", "sleep"));
		
		// [] : 해당 위치의 한 글자에 어떤 문자들이 올 수 있는지 정의하는 표현식
		System.out.println(Pattern.matches("s[l@]eep", "sleep"));
		System.out.println(Pattern.matches("s[l@]eep", "sheep"));
		System.out.println(Pattern.matches("s[l@]eep", "s@eep"));
		System.out.println(Pattern.matches("s[l@]ee[abcdefghijk]", "sleek"));
		System.out.println(Pattern.matches("s[l@]ee[abcdefghijkABCDEFG]", "sleeK"));
		
		/*
			[abc]  : 해당 자리에 a 또는 b 또는 c를 허용 
			[^abc] : 해당 자리에 abc를 제외한 모든 것을 허용
			[a-z] : a부터 z까지 모두 허용
			[A-Z] : A부터 Z까지 모두 허용
			[\\-] : 문자로서 -를 허용 (Escape)
			[a-e&&c-z] : a-e와 c-z를 모두 만족시키는 문자를 허용(교집합)
		 */
		System.out.println(Pattern.matches("s[A-Z]eep", "s-eep"));
		System.out.println(Pattern.matches("s[A\\-Z]eep", "s-eep"));
		System.out.println(Pattern.matches("s[a-e&&c-z]eep", "sceep"));
		
		/*
			# 하나로 여러 문자를 나타내는 것들
			
			.  : 모든 문자
			\d : 모든 숫자
			\D : 숫자를 제외한 모든 것
			\s : 모든 공백(\t, \n, \r)
			\S : 공백을 제외한 모든 것
			\w : 일반적이 문자들을 허용 [a-zA-Z0-9_]
			\W : \w을 제외한 모든 것
			
		 */
		System.out.println(Pattern.matches("s\\Seep", "sdeep"));
		
		/*
			# 해당 패턴이 적용될 문자의 개수를 정의하는 방법
			
			 [.]{n} : {}앞의 패턴이 n개 일치해야 한다
			 [.]{n, m} : {}앞의 패턴이 최소 n개 최대 m개 일치해야 한다
			 [.]{n,} : {}앞의 패턴이 최소 n개 이상 일치해야 한다
			 [.]? : ? 앞의 패턴이 0번 또는 한번 나와야 한다
			 [.]+ : + 앞의 패턴이 최소 한번 이상 나와야 한다
			 [.]* : * 앞의 패턴이 0번 이상 나와야 한다
		 */
		System.out.println(Pattern.matches("[.a-zA-Z]{5}", ".abs."));
		System.out.println(Pattern.matches("[.]{2,5}", "."));
		System.out.println(Pattern.matches("s?heep", "heep"));
		System.out.println(Pattern.matches("s+heep", "ssssssssssssssssheep"));
		System.out.println(Pattern.matches("s+heep", "heep"));
		System.out.println();
		// 연습문제: 해당 문자열이 핸드폰 번호인지 검사할 수 있는 정규표현식을 만들어보세요
		System.out.println(Pattern.matches("010(-[\\d]{4}){2}", "010-5013-0442"));
// 해설	System.out.println(Pattern.matches("010-?[2-9]\\d{3}-?\\d{4}", "010-5013-0442"));
		
		// 연습문제: 해당 문자열이 주민등록번호인지 검사할 수 있는 정규표현식을 만들어보세요
		System.out.println(Pattern.matches("[\\d]{2}[0-1][\\d][0-3][\\d]-?[1-4]\\d{6}", "991111-1234567"));
		System.out.println(Pattern.matches("[\\d]{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])-?[1-4]\\d{6}", "991111-1234567"));
		
		// 연습문제: 해당 문자열이 이메일인지 검사할 수 있는 정규표현식을 만들어보세요
		System.out.println(Pattern.matches("\\w+@\\w+[.](com|net|[a-z]+[.][a-z]+)", "abc123@naver.com"));
//해설	System.out.println(Pattern.matches("\\w+@\\w+(\\.\\w)?(\\.\\w+)?", "abc123@naver.com"));
		
		// # Matcher 사용해서 긴 무자열 검색하기
		
		String fruit = "apple/banana/orange/pineapple/greenapple/redapple/mango";
		
		Pattern pattern1 = Pattern.compile("na");
		
		// pattern1로 fruit을 검사한 결과를 반환한다
		Matcher matcher = pattern1.matcher(fruit);
		
		// matcher.find() : 찾은 것들 중에 다음 것이 존재하면 true
		while(matcher.find()) {
			System.out.println("찾은 것: " + matcher.group());
			System.out.println("위치 : " + matcher.start() + "부터 " + matcher.end() + "까지");
		}
	}

}













