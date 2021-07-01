package quiz;

public class A02_Gildong {
	public static void main(String[] args) {
		String name = "홍길동";
		
		// byte타입은 데이터 전송시에 사용하는 경우가 대부분이다
		// 숫자 범위가 작다고해서 byte타입을 사용하지는 않는다
		int age = 20;
		String phone_number = "010-1234-1234";
		double height = 178.5;
		double weight = 75;
		String blood = "O";
		boolean job = false;
		
		System.out.println("========== 출력 결과 ==========");
		System.out.println("\n이름\t: " + name);
		System.out.println("나이\t: " + age);
		System.out.println("Tel\t: " + phone_number);
		System.out.println("키\t: " + height);
		System.out.println("몸무게\t: " + weight);
		System.out.println("혈액형\t: " + blood);
		System.out.println("직업유무\t: " + job);
		
	}

}
