package myobj;

public class Basket {
	
	int MAX_ROOM_SIZE = 10;
	Fruit[] fruits;
	int index;
	int sum = 0;
	
	Basket(){
		fruits = new Fruit[MAX_ROOM_SIZE];
	}
	
	boolean checkMaxBasket() {
		return index == MAX_ROOM_SIZE;
	}
	void enterApple() {
		if(checkMaxBasket()) {
			System.out.println("바구니가 꽉차서 더는 사과를 담을 수 없습니다");
			System.out.println("현재 바구니의 총 가격은 " + sum + "입니다");
			return;
		}
		fruits[index++] = new Fruit("사과", 500);
		sum += fruits[index - 1].price;
		
	}
	
	void enterBanana() {
		if(checkMaxBasket()) {
			System.out.println("바구니가 꽉차서 더는 바나나를 담을 수 없습니다");
			System.out.println("현재 바구니의 총 가격은 " + sum + "입니다");
			return;
		}
		fruits[index++] = new Fruit("바나나", 1000);
		sum += fruits[index - 1].price;
	}
	
	void enterOrange() {
		if(checkMaxBasket()) {
			System.out.println("바구니가 꽉차서 더는 오렌지를 담을 수 없습니다");
			System.out.println("현재 바구니의 총 가격은 " + sum + "입니다");
			return;
		}
		fruits[index++] = new Fruit("오렌지", 1200);
		sum += fruits[index - 1].price;
	}
	
	
	

}
