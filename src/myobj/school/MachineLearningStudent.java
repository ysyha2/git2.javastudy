package myobj.school;

public class MachineLearningStudent extends Student {
	int math;
	int st;
	int pl;

	
	public MachineLearningStudent() {
		math = generateRandomScore();
		st = generateRandomScore();
		pl = generateRandomScore();
	}
	int getSum() {
		return (kor + eng + math + st + pl);
	}
	
	double getAverage() {
		return  (kor + eng + math + st + pl) / 5.0;
	}
	

	@Override
	public void printGradeCard() {
		System.out.println("┌────────────────────────────────────────────┐");
		System.out.printf("│이름 : %-5s 총점: %-4d 평균 %-5.2f \t     │\n", name, getSum(), getAverage());
		System.out.println("│국어\t영어\t수학\tST\tPL\t     │");
		System.out.println("│--------------------------------------------│");
		System.out.printf("│%-3d\t%-3d\t%-3d\t%-3d\t%-3d\t     │\n", kor, eng, math, st, pl);
		System.out.println("└────────────────────────────────────────────┘");
	}
}
