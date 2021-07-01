package myobj.school;

public class ProgrammingStudent extends Student {
	
	int math;
	int pl;
	int al;
	int ds;
	
	public ProgrammingStudent() {
		math = generateRandomScore();
		pl = generateRandomScore();
		al = generateRandomScore();
		ds = generateRandomScore();
	}
	int getSum() {
		return (kor + eng + math + pl + al + ds);
	}
	
	double getAverage() {
		return (kor + eng + math + pl + al + ds) / 6.0;
	}
	

	@Override
	public void printGradeCard() {
		System.out.println("┌────────────────────────────────────────────┐");
		System.out.printf("│이름 : %-5s 총점: %-4d 평균 %-5.2f \t     │\n", name, getSum(), getAverage());
		System.out.println("│국어\t영어\t수학\tPL\tAL\tDS   │");
		System.out.println("│--------------------------------------------│");
		System.out.printf("│%-3d\t%-3d\t%-3d\t%-3d\t%-3d\t%-3d  │\n", kor, eng, math, pl, al, ds);
		System.out.println("└────────────────────────────────────────────┘");
	}

}
