package myobj.studentlist;

import java.util.Random;

public class Student implements Comparable<Student> {
	public int name;
	public int kor;
	public int eng;
	public int math;
	public double avg;
	public double total_avg;
	Random random = new Random();
	public Student(int num) {
		name = num;
		kor = random.nextInt(101);
		eng = random.nextInt(101);
		math = random.nextInt(101);
		avg = (double)(kor + eng + math) / 3;
		total_avg += avg;
	}
	
	public int printname() {
		return name;
	}
	
	public int kor_score() {
		return kor;
	}
	
	public int eng_score() {
		return eng;
	}
	
	public int math_score() {
		return math;
	}
	
	public double avg_score() {
		return avg;
	}
	
	public double total_avg_score() {
		return total_avg;
	}

	@Override
	public int compareTo(Student o) {
		if(this.avg > o.avg)
		{
			return 1;
		}
		
		else if(this.avg == o.avg) 
		{
			return 0;
		}
		else
		{
			return -1;
		}
		
	}
	/* 해설
	@Override
	public int compareTo(Student o) {
		return Double.compare(avg, o.avg) != 0 ?
				Double.compare(avg, o.avg) : Integer.compare(name, o.name);
	}
	*/
	
	@Override
	public String toString() {
		return String.format("%.2f", avg);
	}

	

}
