package myobj.school;

public class NetworkStudent extends Student {
	int li;
	int net;
	int ccna;
	
	public NetworkStudent() {
		li = generateRandomScore();
		net = generateRandomScore();
		ccna = generateRandomScore();
	}
	int getSum() {
		return (kor + eng + li + net + ccna);
	}
	
	double getAverage() {
		return (kor + eng + li + net + ccna) / 5.0;
	}
	

	@Override
	public void printGradeCard() {
		System.out.println("┌────────────────────────────────────────────┐");
		System.out.printf("│이름 : %-5s 총점: %-4d 평균 %-5.2f \t     │\n", name, getSum(), getAverage());
		System.out.println("│국어\t영어\tLI\tNET\tCCNA\t     │");
		System.out.println("│--------------------------------------------│");
		System.out.printf("│%-3d\t%-3d\t%-3d\t%-3d\t%-3d\t     │\n", kor, eng, li, net, ccna);
		System.out.println("└────────────────────────────────────────────┘");
	}
}
