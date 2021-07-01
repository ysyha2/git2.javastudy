package myinterface;

import java.util.Scanner;

public class Student implements GradeCard {	
	String name;
	int math;
	int english;
	int science;
	int korean;
	int sum;
	int rank;

	public void create_student() {
		Student students = new Student();
		Scanner sc = new Scanner(System.in);
		students.name = sc.nextLine();
		System.out.print(students.name + "의 영어 성적은? ");
		students.english = sc.nextInt();
		System.out.print(students.name + "의 수학 성적은? ");
		students.math = sc.nextInt();
		System.out.print(students.name + "의 국어 성적은? ");
		students.korean = sc.nextInt();
		System.out.print(students.name + "의 과학 성적은? ");
		students.science = sc.nextInt();	
//		for (int i = 0; i < students.length; i++) {
//			System.out.print("이름을 입력하세요: ");
//			students[i].name = sc.nextLine();
//			System.out.print(students[i].name + "의 영어 성적은? ");
//			students[i].english = sc.nextInt();
//			System.out.print(students[i].name + "의 수학 성적은? ");
//			students[i].math = sc.nextInt();
//			System.out.print(students[i].name + "의 국어 성적은? ");
//			students[i].korean = sc.nextInt();
//			System.out.print(students[i].name + "의 과학 성적은? ");
//			students[i].science = sc.nextInt();	
//		}
	}
	@Override
	public int sum_score() {
		sum = math + english + science + korean;
		return sum;
	}
	@Override
	public double avg_score() {
		return sum/(double)4;
	}
	@Override
	public boolean pass_fail() {
		if(sum >= 200) 
		{
			return true;
		}
		else
		{
			return false;
		}

	}
//	@Override
//	public int print_rank() {
//		
//	}
	

}
