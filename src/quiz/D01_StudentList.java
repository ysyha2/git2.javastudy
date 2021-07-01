package quiz;

import java.util.ArrayList;

import myobj.studentlist.Student;
//해설 import myobj.Student;

public class D01_StudentList {
	
	/*
		학생 클래스를 요소로 갖는 ArrayList를 생성하고 학생을 30명 추가해보세요
		
		 1. 각 학생의 점수는 랜덤으로 설정
		 
		 2. 과목은 국/영/수
		 
		 3. 30명의 평균 점수를 출력
		 
		 4. 30명 중 가장 평균 점수가 높은 학생의 성적을 출력 
	 */
	/* 해설
	public static void main(String[] args) {
		ArrayList<Student> student_list = new ArrayList<>();
		
		for(int i = 0; i < 30; i++) {
			student_list.add(new Student());
		}
		
		for(Student student : student_list) {
			System.out.println(student);
		}
		
		System.out.println("가장 높은 점수 : " + Student.best_avg);
		System.out.println("가장 높은 점수인 학생의 학번:  " + Student.best_avg_snum	);
	}*/
	
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		for(int i = 0 ; i < 30; i++) {
			students.add(new Student(i + 1));
		}
		max_avg(students);
		
	}
	
	public static void max_avg(ArrayList<Student> students) {
		double max_avg = 0;
		int number = -1;
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).avg_score() > max_avg)
			{
				max_avg = students.get(i).avg_score();
				number = i;
			}
		}
		
		System.out.printf("평균점수가 제일 높은 학생의 이름은 %d 이다.\n30명의 평균점수는 %.2f 이다\n"
				+ "이학생의 국어점수는 %d, 영어점수는 %d, 수학점수는 %d이고,  평균점수는 %.2f이다.", 
				number + 1, students.get(students.size() - 1).total_avg_score(),  students.get(number).kor_score(), students.get(number).eng_score(), 
				students.get(number).math_score()  ,students.get(number).avg_score());
	}
}
