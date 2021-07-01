package quiz;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class D02_Lotto {
	
	/*
		1. 1부터 45사이의 중복없는 랜덤 숫자를 생성하는 메서드를 작성해보세요
			(당첨번호는 7개, 손님이 고르는 번호는 6개)
		
		2. 프로그램이 시작되면 당첨번호를 하나 지정하고 (숫자 7개)
		   당첨번호와 일치하는 6개의 숫자가 나올 때 까지 번호를 계속 뽑아보세요
		   
		3. 1등 또는 2등에 당첨될때까지 돈을 얼마나 썼는지 계산해보세요 (숫자 7개 뽑는데 천원)
	 */

	/* 해설
	final private static int LOTTO_SIZE = 45;
	final private static int BONUS_INDEX = 3;
	
	private int bonus = 0;
	
	
	public Set<Integer> generate(int len){
		HashSet<Integer> lotto = new HashSet<>();
		
		while(lotto.size() != len) {
			int ranNum  = (int)(Math.random() * LOTTO_SIZE + 1);
//			System.out.println("Set에 " + ranNum + "이 더해집니다.");
			lotto.add(ranNum);
			
			if(len == 7 && lotto.size() == BONUS_INDEX) {
				bonus = ranNum;
			}
		}
		

		return lotto;
	}
	
	public void test() {
		List<Integer> checkList = new ArrayList<>(7);

		long spent = 0;
		long count = 0;

		while (true) {
			
			Set<Integer> win =  generate(7);

			System.out.println("당첨번호는 " + win + "입니다. 그 중 보너스 번호는 " + bonus + "입니다");
			Set<Integer> blackcow = generate(6);
			count++;

			checkList.addAll(win);
			checkList.removeAll(blackcow);

			if (checkList.size() == 1) {
				spent = count * 1000;
				if(checkList.get(0) == bonus) 
				{
					System.out.println("1등 당첨입니다. 여태까지 쓰신 돈은 " + spent + "원 입니다.");
				}
				else 
				{
					System.out.println("2등 당첨입니다. 여태까지 쓰신 돈은 " + spent + "원 입니다.");
				}
				break;
			}
			checkList.clear();
		}

	}

	public static void main(String[] args) {
		D02_Lotto quiz = new D02_Lotto();
		quiz.test();
	}
	
	
}*/

	public static void main(String[] args) {
		HashSet<Integer> customer_number = Customer_number();
		int count= 1;
		while(!draw_lottery(customer_number)) {
			count++;
		}
		System.out.println("총 사용 금액은 " + count * 1000 + "원입니다.");


	}

	
	public static HashSet<Integer> Customer_number() {
		HashSet<Integer> customer_number = new HashSet<>();
		Random random = new Random();

		while(customer_number.size() != 6) {
			int number1 = random.nextInt(45) + 1;
			customer_number.add(number1);
		}

		return customer_number;
	}
	

	
	public static boolean draw_lottery(Collection<Integer> A) {
		HashSet<Integer> winning_number = new HashSet<>();
		HashSet<Integer> customer_number1 = new HashSet<>(A);
		HashSet<Integer> customer_number2 = new HashSet<>(A);
		Random random = new Random();
		int bonus_number = -1;
		while(winning_number.size() != 6) {
			int number1 = random.nextInt(45) + 1;
			winning_number.add(number1);
		}
		while(winning_number.size() != 7) {
			bonus_number = random.nextInt(45) + 1;
			winning_number.add(bonus_number);
		}
		System.out.println("고객의 번호는 " + customer_number1 + "입니다.");
		System.out.println("당첨번호는 " + winning_number + "입니다.");
		System.out.println("보너스 번호는 " + bonus_number + "입니다");
		
		customer_number1.remove(bonus_number);
		customer_number1.retainAll(winning_number);
		if(customer_number1.size() == 6) 
		{
			System.out.println("1등 당첨되셨습니다.");
			return true;
		}
		
		customer_number2.removeAll(winning_number);
		customer_number2.remove(bonus_number);
		if(customer_number2.size() == 1) 
		{
			System.out.println("2등 당첨되셨습니다.");
			return true;
		}
		System.out.println();
		return false;
		
		
	}
}
