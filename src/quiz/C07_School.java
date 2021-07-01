package quiz;

import myobj.school.MachineLearningStudent;
import myobj.school.NetworkStudent;
import myobj.school.ProgrammingStudent;
import myobj.school.Student;

public class C07_School {
	
	/*
		1. 각 반의 정원은 30명이다.
		
		2-1. 프로그래밍 반 학생들은 각자의 국어, 영어, 수학, 프로그래밍 언어, 알고리즘, 자료구조 점수가 있다
		
		2-2. 네트워크 반 학생들은 각자의 국어, 영어, 리눅스, 네트워크, CCNA 점수가 있다
		
		2-3. 머신러닝 반 학생들은 각자의 국어, 영어, 수학, 통계학, 프로그래밍 언어 점수가 있다
		
		3. 모든 학생의 과목별 점수와 이름을 랜덤으로 생성한다.
		   학번은 중복없이 순차적으로 생성되어야 한다. (또는 중복없이 랜덤도 가능)
		   
		4. 각 학생의 성적표 메서드를 통해 각 학생의 이름/총점/평균점수를 볼 수 있어야 한다.	
	 */
	
/* 해설
	public static void main(String[] args) {
		ProgrammingStudent pro = new ProgrammingStudent();
		
		Student[] school = new Student[30];
		Student[] school2 = new Student[30];
		Student[] school3 = new Student[30];
		
		for (int i = 0; i < school.length; i++) {
			school[i] = new ProgrammingStudent();
			school[i].printGradeCard();
		}
		for (int i = 0; i < school2.length; i++) {
			school2[i] = new NetworkStudent();
			school2[i].printGradeCard();
		}
		for (int i = 0; i < school3.length; i++) {
			school3[i] = new MachineLearningStudent();
			school3[i].printGradeCard();
		}

	}
}*/
	
	public static void main(String[] args) {
		int student_id = 0;
		Students[] programming = new Programming[30];
		Students[] network = new Network[30];
		Students[] machine_learning = new Machine_learning[30];
		
		for(int i = 0; i < programming.length; i ++) {

			programming[i] = new Programming();
			programming[i].student_id = student_id++;
			programming[i].grade_card();
		}
		for(int i = 0; i < network.length; i ++) {

			network[i] = new Network();
			network[i].student_id = student_id++;
			network[i].grade_card();
		}
		for(int i = 0; i < machine_learning.length; i ++) {

			machine_learning[i] = new Machine_learning();
			machine_learning[i].student_id = student_id++;
			machine_learning[i].grade_card();
		}

	}
}

abstract class Students{
	
	int name;
	int student_id;
	int random_score = (int)(Math.random()*101);
	int kor;
	int english;
	Students(){
		name = (int)(Math.random()*1000);
		kor = random_score;
		english = random_score;
	}
	int sum_score = kor + english;
	abstract void grade_card();

}

class Programming extends Students{
	int math = random_score;
	int programming = random_score;
	int algorithm = random_score;
	int data_structure = random_score;
	int sum_score = super.sum_score + math + programming + algorithm + data_structure;
	double average_score = sum_score/(double)6;
	@Override
	void grade_card() {
		System.out.println("반: 프로그래밍");
		System.out.printf("이름: %d / 총점: %d / 평균점수: %.2f \n" ,
				name, sum_score, average_score  );
	}
	
}

class Network extends Students{
	int linux = random_score;
	int network = random_score;
	int ccna = random_score;
	int sum_score = super.sum_score + linux + network + ccna;
	double average_score = sum_score/(double)5;
	@Override
	void grade_card() {
		System.out.println("반: 네트워크");
		System.out.printf("이름: %d / 총점: %d / 평균점수: %.2f \n" ,
				name, sum_score, average_score  );
	}
	
}

class Machine_learning extends Students{
	int math = random_score;
	int statistics = random_score;
	int programming = random_score;
	int sum_score = super.sum_score + math + statistics + programming;
	double average_score = sum_score/(double)5;
	@Override
	void grade_card() {
		System.out.println("반: 머신러닝");
		System.out.printf("이름: %d / 총점: %d / 평균점수: %.2f \n" ,
							name, sum_score, average_score  );
		
	}
	
}


