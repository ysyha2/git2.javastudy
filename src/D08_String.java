import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class D08_String {
	
	public static void main(String[] args) {
		
		String fruits = "apple/banana/orange/pineapple";
		
		
		
		// split(delimiter) : 문자열을 원하는 기준으로 자른 문자열 배열을 반환한다
		String[] splitted = fruits.split("/");
		
		for(int i = 0 ; i < splitted.length; i++) {
			System.out.println(i + ": " + splitted[i]);
		}
		
		// String.join(delim, 이어붙이고싶은것...) : 여러 문자열을 원하는 구분자를 추가하여 이어붙인다
		String after = String.join(", ", splitted);
		
		System.out.println(after);
		System.out.println(String.join("-", "연어", "장어", "광어", "우럭", "도미"));
		
		printRabbitWithMessage("커피", "우유" , "주스" , "당근", "피망");
		printRabbitWithMessage("감자", "고구마");
		
		// substring(start) : 문자열을 start부터 마지막까지 자른 인스턴스를 반환
		// substring(start, end) : 문자열을 start부터 end미만까지 자른 인스턴스를 반환
		String sn = "991231-1234567";
		
		String year = sn.substring(0, 2);
		String month = sn.substring(2, 4);
		String date = sn.substring(4, 6);
		
		System.out.println("year: " + year);
		System.out.println("month: " + month);
		System.out.println("date: " + date);
		
		String ph = "010-1234-1234";
		System.out.println("ph에 1234가 포함되어 있나요? " + ph.contains("1234"));
		System.out.println("ph에 4321가 포함되어 있나요? " + ph.contains("4321"));
		
		// startsWith(seq) : 문자열이 해당 문자열로 시작하는지 검사한다
		System.out.println("ph가 010으로 시작하나요? " + ph.startsWith("010"));
		
		// endsWith(seq) : 문자열이 해당 문자열로 끝나는지 검사한다
		System.out.println("ph가 4로 끝나나요? " + ph.endsWith("4"));
		
		// replace(old, new) : 문자열을 다른 문자열로 교체한 인스턴스를 반환한다
		String result = ph.replace("1234", "abcd");
		System.out.println("원본 : " + ph + ", 결과 : " + result);
		
		// getBytes() : 문자열을 byte[]로 변환한다 (데이터 전송 준비)
		System.out.println(Arrays.toString("Hello".getBytes()));
		System.out.println(Arrays.toString("안녕하세요".getBytes()));
		
		// 어떤 규칙(인코딩 타입)을 사용해 byte[]로 변환할지 결정할 수 있다
		try 
		{
		System.out.println(Arrays.toString("안녕하세요".getBytes("UTF-8")));
		System.out.println(Arrays.toString("안녕하세요".getBytes("UTF-16")));
		System.out.println(Arrays.toString("안녕하세요".getBytes("EUC-KR")));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		// byte[]로 나눠졌던 데이터들을 다시 문자열로 합칠 수 있다
		byte[] message = "안녕하세요 반갑습니다.".getBytes();
		System.out.println(new String(message));
		
		// trim() : 문자열 바깥쪽의 공백을 제거한 인스턴스를 반환한다
		String user_input = "\t java \n";
		String answer = "java";
		
		System.out.println(user_input.trim().equals(answer));
		
		// toUpperCase() : 문자열을 대문자로 변환한 인스턴스를 반환한다
		// toLowerCase() : 문자열을 소문자로 변환한 인스턴스를 반환한다
		String text = "hello, java!!";
		System.out.println(text.toUpperCase());
		System.out.println(text.toUpperCase().toLowerCase());
		
		// indexOf(seq) : 원하는 문자열의 인덱스를 반환한다
		// indexOf(seq, start) : 시작 위치부터 원하는 문자열의 인덱스를 반환한다
		String languages = "Java, Python, C, C++, C#, Kotlin, JavaScript";
		languages += languages;
		languages += languages;
		languages += languages;
		
//		System.out.println(languages.indexOf("Java"));
//		System.out.println(languages.indexOf("Java", 1));
		
		// 연습: languages에서 모든 "Java"라는 문자열의 인덱스를 찾아서 적절한 컬렉션에 저장하여 출력해보세요
		System.out.println();
		
		ArrayList<Integer> indexes = new ArrayList<>();
		String search = "Java";
/* 해설1		
		for (int start = 0; start < languages.length();) {
			int index = languages.indexOf(search, start);
			
			if(index == -1)
			{
				break;
			}
			System.out.println("이번에 찾음: " + index);
			indexes.add(index);
			start = index + 1;
		}
		
		*/
		/* 해설 2
		int start = 0;
		int found = -1;
		while((found = languages.indexOf(search, found + 1)) != -1) {
			indexes.add(found);
		}
		System.out.println("찾은거 : " + indexes);

		 */
		TreeSet<Integer> index = new TreeSet<>();
		int index_number = languages.indexOf("Java");
		int first_index = index_number;
		while(true) {
			index_number = languages.indexOf("Java", index_number);
			if(index_number >= first_index) {
				index.add(index_number);
			}
			index_number++;
			if(index_number <= first_index )
			{
				break;
			}
		}
		System.out.println(index);
	
	}
	
	// Type ... : 가변인자, 정해지지 않은 개수의 인자를 해당 타입 배열로 넘겨받을 수 있다
	// ※ 가변인자는 항상 메서드의 마지막에 정의해야 한다
	static void printRabbitWithMessage(String... msgs) {
		System.out.println(" /)/)");
		System.out.println("(  ..)");
		System.out.println("(  >♡");
		System.out.println(Arrays.toString(msgs));
	}

}
















