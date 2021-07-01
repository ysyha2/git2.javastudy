package myobj.blackjack;

import java.util.Scanner;

public class Blackjack {
	
	Scanner sc;
	Cards cards;
	Player player;
	Dealer dealer;

	public Blackjack() {
		cards = new Cards();
		player = new Player();
		dealer = new Dealer();
		sc= new Scanner(System.in);

	}
	
	public void new_game() {
		
		dealer.add(cards.next());
		dealer.add(cards.next());
		
		player.add(cards.next());
		player.add(cards.next());
		int pv = -1;
		while(choice()) {
			player.add(cards.next());
			
			pv = player.calc();
			if(pv >= 21)
			{
				break;
			}
		}
		
		if(pv <= 21) 
		{
			// 딜러가 마저 카드를 여는 로직
			open();
		}
		else
		{
			System.out.println("플레이어 버스트!!!");
		}
		last_info();
		whowin();
		
	}
	
	private void whowin() {
		int dv = dealer.calc();
		int pv = player.calc();
		
		if(dv == pv) 
		{
			System.out.println("무승부!");
		}
		else if(dv > 21 && pv <= 21) 
		{
			System.out.println("플레이어 승리!");
		}
		else if(pv > 21 && dv <= 21)
		{
			System.out.println("딜러의 승리!");
		}
		else if (pv > dv)
		{
			System.out.println("플레이어의 승리!");
		}
		else
		{
			System.out.println("딜러의 승리!");
		}
	}
	
	private void open() {
		int dv = 0;
		while (dealer.calc() <17) {
			dealer.add(cards.next());
		}
		dealer.tables[0].hidden = false;
	}
	
	private void info() {
		System.out.println("딜러의 카드: " + dealer);
		System.out.println("플레이어: " +player + "의 value: " + player.calc());
		
	}
	
	private void last_info() {
		System.out.println("딜러의 카드: " + dealer + " value : " + dealer.calc());
		System.out.println("플레이어: " +player + "의 value: " + player.calc());
	}
	
	private int input(String notice) {
		System.out.println(notice);
		return sc.nextInt();
	}
	
	private boolean choice() {
		while(true) {
			info();
			int choice = input("1. hit\t2. stand > ");
			
			if (choice == 1) 
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Blackjack().new_game();
	}

}
