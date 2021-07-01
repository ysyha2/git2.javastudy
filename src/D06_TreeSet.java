import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import myobj.studentlist.Student;

public class D06_TreeSet {
	
	/*
		# TreeSet
		
		 - 순서가 있는 Set (순서가 없는 것은 Hash의 특징)
		 - 중복은 허용하지 않는다 (Set의 특징)
		 - 데이터를 추가할 때 값을 정렬해서 넣기 때문에 HashSet에 비해 저장 속도가 느리다
		 - 미리 정렬이 되어 있기 때문에 정렬된 순서로 값을 꺼내기 편리한 Set이다
		 - 해당 TreeSet 인스턴스에서 사용할 Comparator를 지정할 수 있다
		
	 */
	
	public static void main(String[] args) {
		TreeSet<Integer> numbers = new TreeSet<>();
		
		numbers.add(10);
		numbers.add(99);
		numbers.add(86);
		numbers.add(41);
		numbers.add(50);
		numbers.add(13);
		
		System.out.println(numbers);
		
		// TreeSet에 원하는 Comparator를 사용하기 (정수 내림차순)
		TreeSet<Integer> numbers2 = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				/* 
					자리를 바꾸고 싶다면 양수 리턴
					자리를 바꾸기 싫으면 음수 리턴
					두 값이 같은 값이면 0 리턴
				
				*/
				return o2 - o1;
			}

		});
		
		numbers2.addAll(numbers);
		
		System.out.println(numbers2);
		
		// * TreeSet은 Set의 일부분을 리턴하는데 특화된 기능이 많다
		// 44값을기준으로 머리부터 짤라옴
		SortedSet<Integer> head = numbers.headSet(44);
		System.out.println(head);
		
		// 44값을 기준으로 꼬리까지 짤라옴
		SortedSet<Integer> tail = numbers.tailSet(44);
		System.out.println(tail);
		
		// 미리 정렬해놓은 방향과 반대 방향인 Set 인스턴스를 반환한다
		NavigableSet<Integer> desc = numbers.descendingSet();
		System.out.println(desc);
		
		System.out.println("first? " + numbers.first());
		System.out.println("last? " + numbers.last());
		
		System.out.println("pollFirst? " + numbers.pollFirst());
		System.out.println(numbers);
		System.out.println("pollLast? " + numbers.pollLast());
		System.out.println(numbers);
		System.out.println("subSet(30, 70)? " + numbers.subSet(30, 70));
		
		// 이 Set이 어떤 분류기를 사용하는지 보고싶을때 사용한다, 원래 자연스레 사용되는걸 썼다면 null이 나옴
		// 사용자가 익명으로 comparator를 만들어놨을경우 사용할 수 있다(다시는 볼 수 없을줄 알았던걸 다시보게된다)
		System.out.println(numbers.comparator());
		System.out.println(numbers2.comparator());
		
		TreeSet<Integer> number3 = new TreeSet<>(numbers2.comparator());
		
		List<Integer> list = new ArrayList<>(numbers);
		Collections.sort(list, numbers2.comparator());
		
		System.out.println("list: " + list);
		
		System.out.println("contains 41? " + numbers2.contains(41));
		System.out.println("contains 42? " + list.contains(42));
		
		// 아래의 코드가 true가 나오도록 null을 바꿔보세요 (3가지 이상)
		System.out.println(list.containsAll(numbers));
		System.out.println(list.containsAll(list));
		System.out.println(list.containsAll(numbers.subSet(30, 70)));
		System.out.println(list.containsAll(numbers2.subSet(43, 41)));
		
		// 학생 인스턴스를 100개 만들고, TreeSet에 평균 점수 순으로 저장한 후
		// 평균 점수가 50점에서 70점 사이인 학생이 모두 몇명인지 세어보세요
		/* 해설
		TreeSet<Student> stu_set = new TreeSet<>();
		
		for (int i = 0; i < 100; i ++) {
			stu_set.add(new Student(i + 1));
		}
		
		System.out.println(stu_set);
		System.out.println("학생은 총 " + stu_set.size() + "명 입니다.");
		
		Student from = new Student(102);
		Student to = new Student(103);
		
		from.avg = 50.0;
		to.avg = 70.0;
		
		System.out.println(stu_set.subSet(from, to).size());
		*/
		System.out.println();
		Student[] students = new Student[100];
		for(int i = 0; i < students.length; i++) {
			students[i] = new Student(i + 1);
		}
		
		TreeSet<Student> students_treeset = new TreeSet<>();
		int student_count = 0;
		for(int i = 0 ; i < students.length; i++) {
			students_treeset.add(students[i]);
			if(count(students[i]))
			{
				student_count++;
			}
		}
//		System.out.println(students_treeset);
		System.out.println(student_count);
		
		TreeSet<Book> book_set = new TreeSet<>();
		
		for(int i = 0 ; i < 100; i++) {
			book_set.add(new Book(i + 1));
		}
		
		Book subset_from  = new Book(book_set.size() + 1);
		Book subset_to = new Book(book_set.size() + 2);
		subset_from.price = 15000;
		subset_to.price = 30000;
		
		System.out.println("책값이 15000원에서 30000원 사이는 총 " 
		+ book_set.subSet(subset_from, subset_to).size() + "권 있습니다");
		
		


	}
	
	public static boolean count(Student student) {
		if(student.avg_score() >= 50 && student.avg_score() <= 70)
		{
			return true;
		}
		return false;
	}

}

class Book implements Comparable<Book>{
	int book_num;
	int price;
	public Book(int num) {
		price = (int)(Math.random() * 30000 + 5000);
		book_num = num;
	}
	@Override
	public int compareTo(Book o) {
		return Integer.compare(price, o.price) != 0 ?
			Integer.compare(price, o.price) : Integer.compare(book_num, o.book_num);
	}
	
	
	
}
