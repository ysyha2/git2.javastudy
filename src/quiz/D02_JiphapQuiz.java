package quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class D02_JiphapQuiz<T> {
	
	/*
		1. 두 컬렉션을 매개변수로 전달 받으면 두 컬레션의 합집합을 Set으로 반환하는 메서드
		
		[1, 2, 3, 4] 합집합 [3, 4, 5] => [1, 2, 3, 4, 5]
		
		2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set으로 반환하는 메서드
		
		[1, 2, 3, 4] 교집합 [3, 4, 5] => [3, 4]
		
		3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set으로 반환하는 메서드
		
		[1, 2, 3, 4] 차집합 [3, 4, 5] => [1, 2]
		
		[1, 2, 3, 4] 차집합 [3, 4, 5] => [5]
		
		를 만들고 테스트 해보세요
	 */
	
	public static void main(String[] args) {
		
		ArrayList<Integer> number1 = new ArrayList<>();
		ArrayList<Integer> number2 = new ArrayList<>();
		
		number1.add(1);
		number1.add(2);
		number1.add(3);
		number1.add(4);

		number2.add(3);
		number2.add(4);
		number2.add(5);
		
		System.out.println("집합1 : " + number1);
		System.out.println("집합2 : " + number2);
		System.out.println("합집합 결과는: " + union(number1, number2));
		System.out.println();
		
		ArrayList<Integer> number3 = new ArrayList<>();
		ArrayList<Integer> number4 = new ArrayList<>();
		
		number3.add(1);
		number3.add(2);
		number3.add(3);
		number3.add(4);

		number4.add(3);
		number4.add(4);
		number4.add(5);
		
		System.out.println("집합1 : " + number3);
		System.out.println("집합2 : " + number4);
		System.out.println("교집합 결과는: " +intersection(number3, number4));
		System.out.println();
		
		ArrayList<Integer> number5 = new ArrayList<>();
		ArrayList<Integer> number6 = new ArrayList<>();
		
		number5.add(1);
		number5.add(2);
		number5.add(3);
		number5.add(4);

		number6.add(3);
		number6.add(4);
		number6.add(5);
		
		System.out.println("집합1 : " + number5);
		System.out.println("집합2 : " + number6);
		System.out.println("차집합 결과는: " +difference(number5, number6));
		
		
	}
	
	public static HashSet union(Collection col1, Collection col2) {
		HashSet<Integer> set1 = new HashSet(col1);
		HashSet<Integer> set2 = new HashSet(col2);
		set1.addAll(set2);
		return set1;
	}
	
	public static HashSet intersection(Collection col1, Collection col2) {
		HashSet<Integer> set1 = new HashSet(col1);
		HashSet<Integer> set2 = new HashSet(col2);
		set1.retainAll(set2);
		return set1;
	}
	
	public static HashSet difference(Collection col1, Collection col2) {
		HashSet<Integer> set1 = new HashSet(col1);
		HashSet<Integer> set2 = new HashSet(col2);
		set1.removeAll(set2);
		return set1;
	}

	
/*해설
 		<> (제네릭)이 없으면 모든타입이 Obejct가되서 번거로움
 		<> 있이 쓰려면 클래스에 <T>라고 붙이면됨
 		인스턴스가 결정될때 타입이 결정됨
 		static에 <T>를 사용하면 오류가 뜨는 이유: <T>는 인스턴스가 생기면 타입이 결정되는건데
 		static은 인스턴스의 개념이없다(인스턴스가 생기기전에 만들어짐)
 		
 	static class Fruit {}
 	
 	static class Apple extends Fruit {}
 	static class Banana extends Fruit {}
 	static class Carrot {}
 		
 	public static void main(String[] args) {
 		D02_JiphapQuiz<String> jiphap = new D02_JiphapQuiz<>();
 		
 		List<String> A = new ArrayList<>();
 		Set<String> B = new HashSet();
 		
 		A.add("Americano");
 		A.add("Americano");
 		A.add("Cold Brew");
 		A.add("Latte");
 		
 		B.add("Americano");
 		B.add("Coke");
 		B.add("Sprite");
 		
 		System.out.println(jiphap.union(A,B));
 		System.out.println(jiphap.intersection(A,B));
 		System.out.println(jiphap.diff(B,A));
 		
		D02_JiphapQuiz<Fruit> jiphap2 = new D02_JiphapQuiz<>();
 		
 		List<Apple> apple_list = new ArrayList<>();
 		Set<Apple> apple_set = new HashSet<>();
 		
 		jiphap.union(apple_list, apple_set); 
 		// 만약에 밑에 메서드에서 그냥 <T>로 하면 Apple은 fruit이 아니므로 빨간줄이뜬다
 		// 애초에 Apple로 만들면 가능하지만 Fruit로 만들면 안됨
 		// 당연한 업캐스팅이 제너릭사이에선 적용되지않는다
 		// ?을 사용하면 모든게 다들어올수있으니 ? extends T로 하므로써 T를 상속받은 무엇인가가 들어올수있다고 제한검
		
	}
	
	
	public static HashSet<T> union(Collection<? extends T> A, Collecton<? extends T> B) {
		HashSet<T> union = new HashSet<>();
		
		union.addAll(A);
		union.addAll(B);
		
		return union;
		
		
	}
	
	public static HashSet<T> intersection(Collection<? extends T> A, Collection<? extends T> B) {
		HashSet<T> inter = new HashSet<>();
		
		inter.addAll(A);
		inter.retainAll(B);
		
		return inter;
	}
	
	public static HashSet<T> diff(Collection<? extends T> A, Collection? extends T> B) {
		HashSet<T> diff = new HashSet<>();
		
		diff.addAll(A);
		diff.removeAll(B);
		
		return diff;
	}*/
	

}
