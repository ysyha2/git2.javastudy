package quiz;

import java.util.Scanner;

public class B11_CountRandomFruit {
	
	/*
		사용자로부터 숫자를 입력받으면 해당 개수 만큼의 랜덤 과일을 선택한다
		(랜덤으로 등장하는 과일 - apple, banana, kiwi, orange, grape, peach)
		
		그 후 각 과일이 몇 번 등장했는지 모두 기록하고 출력한다

	 */
	public static void main(String[] args) {
		
		System.out.print("과일을 몇번이나 선택할까요? ");
		int num = new Scanner(System.in).nextInt();
		
		String[] fruit = new String[] {"apple", "banana", "kiwi", "orange", "grape", "peach"};
		int[] fruit_count = new int[fruit.length];
		for(int i = 0; i < num; i++) {
			int randomnumber = (int)(Math.random()*6);
			System.out.println(fruit[randomnumber]);
			for(int j = 0; j < fruit.length; j++) {
				if(fruit[randomnumber].equals(fruit[j])) {
					fruit_count[j]++;
					break;
				}
				
			}
			
		}
		for(int i = 0; i < fruit_count.length; i++) {
			System.out.printf("%s는 %d번 나왔습니다\n",fruit[i],fruit_count[i]);
		}
		
		
/*		해설
		int repeat = 100;
		
		String[] fruits = {"apple", "banana", "kiwi", "orange", "grape", "peach"};
		
		int[] fruit_count = new int[fruits.length];
		
		for (int i = 0; i < repeat; i++) {
			int random_number = (int)(Math.random() * fruits.length);
			System.out.println(random_number);
			fruit_count[random_number]++;
		}
		
		System.out.println("### 과일 등장 횟수 ###");
		
		for(int i = 0; i < fruits.length; i++) {
			System.out.printf("%s는 %d번 등장했습니다.\n", fruits[i], fruit_count[i]);
		}
		*/
		
		
		
		
	}

}









