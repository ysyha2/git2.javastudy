package myobj;

import java.util.Scanner;

public class Weapon_method {
	
	Weapon sword;
	
	void create_weapon() {
		Scanner sc = new Scanner(System.in);
		System.out.print("무기의 공격력을 입력하세요: ");
		int attack = sc.nextInt();
		System.out.print("현재 강화등급을 입력하세요: ");
		int level = sc.nextInt();
		if(level >20 || level < 0)
		{
			System.out.println("존재하지 않는 강화등급입니다");
		}
		sword = new Weapon(attack,level);
		
	}
	
	
	void reinforcement() {
		if(sword.level ==20)
		{
			System.out.println("강화등급이 최고치입니다. 더이상 강화 할 수없습니다");
		}
		if(sword.percent > (int)(Math.random()*101))
		{
			System.out.println("강화에 성공하셨습니다.");
			sword.attack += sword.plus_attack;
			sword.level++;			
		}
		else
		{
			System.out.println("강화에 실패하셨습니다.");
		}
		
		
		
	}
	
	void attack() {
		System.out.println("무기의 공격력은 " + sword.attack + "입니다");
	}
	
	

}
