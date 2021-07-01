package myinterface;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
//		Bus bus = new Bus();
//		test(bus);
		
		Student students = new Student();
		students.create_student();
//		print_grade_card(students);
		
		// Vehicle 인터페이스를 구현한 무언가를 만들고 테스트해보세요
	}
	
	public static void print_grade_card(GradeCard gradeCard) {
		gradeCard.sum_score();
		gradeCard.avg_score();
		gradeCard.pass_fail();

	}
	
	public static void test(Vehicle vehicle) {
		for (int i = 0; i < 100; i ++) {
			System.out.println("속도를 더 냈습니다.");
			System.out.println("현재 속도는 " + vehicle.acceleration() + "km/h 입니다.");
		}
		
		System.out.println("무서워서 속도를 감속합니다.");
		for (int i = 0; i < 30; i++) {
			System.out.println("현재 속도는 " + vehicle.deceleration() + "km/h 입니다.");
		}
		
		for (int i = 0; i < 15; i++) {
			if (vehicle.ride()) 
			{
				System.out.println("더 이상 탈 수 없습니다.");
			}
			else
			{
				System.out.println("한명이 더 탔습니다.");
			}
		}
	}

}












