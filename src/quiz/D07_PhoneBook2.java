package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class D07_PhoneBook2 {
	
	public static class Info implements Comparable<Info> {
		// 내용은 양심껏
		String name;
		int age;
		int height;
		
		
		@Override
		public int compareTo(Info o) {
			return Integer.compare(age, o.age) != 0 ?
					Integer.compare(age, o.age) : Integer.compare(height, o.height);
		}
		
		@Override
		public String toString() {
			return String.format("이름 : %s, 나이: %d, 키: %d", name, age, height);
		}
		
		
	}
	
	HashMap<String, HashMap<String, Info>> phonebook;
	public D07_PhoneBook2(){
		phonebook = new HashMap<>();
//		System.out.println("2!!");
	}
	
//	static{
//		System.out.println("static block!!");
//	}
//	
//	{
//		System.out.println("1!!");
//	}
	
	
	
	/*
		# HashMap을 이용해 전화번호부를 구현해보세요
		
		 1. phonebook에는 그룹/전화번호/정보를 저장할 수 있다
		 2. 그룹명을 키값으로 넣으면 해당 그룹에 해당하는 HashMap을 꺼낼 수 있다
		 3. 꺼낸 HashMap에 전화번호를 넣으면 이름을 꺼낼 수 있다
		 
		 # 구현해야 할 메서드
		 
		  1. 새로운 그룹을 추가하는 메서드
		  2. 그룹에 새로운 전화번호를 등록하는 메서드
		  3. 등록된 모든 번호를 선택한 항목 기준으로 오름/내림차순으로 보여주는 메서드
		  4. 이름의 일부를 입력하면 해당하는 모든 정보가 출력되는 메서드
		  5. 전화번호의 일부를 입력하면 일치하는 모든 정보가 출력되는 메서드
	 */
	
	public static void group_create(HashMap<String, HashMap<String, Info>> hash ,String group){
		hash.put(group, new HashMap<String, Info>());
	}
	
	public static void add_number(HashMap<String, HashMap<String, Info>> hash, String group ,String number, String name, int age, int height){
		Info info = new Info();
		info.name = name;
		info.age = age;
		info.height = height;

		if(hash.get(group) != null)
		{
			hash.get(group).put(number, info);
		}
		else
		{
			System.out.println("없는 그룹입니다.");
		}

	}
	
	public static void sort_number_age(HashMap<String, HashMap<String, Info>> hash, int count) {
		int[] age_check = new int[count];
		int j = 0;
		for(String key : hash.keySet()) {
			for(Entry<String, Info> entry : hash.get(key).entrySet()) {
				if(j == count - 1) {
					age_check[j] = entry.getValue().age;
					break;
				}
				age_check[j++] = entry.getValue().age;
			}
		}
		
		Arrays.sort(age_check);
		for(int i = 0; i < age_check.length; i++) {
			for(String key : hash.keySet()) {
				for(Entry<String, Info> entry : hash.get(key).entrySet()) {
					if(age_check[i] == entry.getValue().age)
					{
						System.out.print("전화번호: " +  entry.getKey()+ "  ");
						System.out.println(entry.getValue());
					}
					
				}
			}
		}
		
		
	}
	
	public static void name_search(HashMap<String, HashMap<String, Info>> hash, String search_name) {
		for(String key : hash.keySet()) {
			for(Entry<String, Info> entry : hash.get(key).entrySet()) {
				if(entry.getValue().name.contains(search_name))
				{
					System.out.print("전화번호: " +  entry.getKey()+ "  ");
					System.out.println(entry.getValue());
				}
			}
		}
		
	}
	
	public static void number_search(HashMap<String, HashMap<String, Info>> hash, String search_number) {

		String[] number_check = new String[3];
		String number_check2;

		for(String key : hash.keySet()) {
			for(Entry<String, Info> entry : hash.get(key).entrySet()) {
				number_check = entry.getKey().split("-");
				number_check2 = number_check[0].concat(number_check[1]).concat(number_check[2]);
				if(number_check2.contains(search_number))
				{
					System.out.print("전화번호: " +  entry.getKey()+ "  ");
					System.out.println(entry.getValue());
				}
			}
		}

	}
	
	public static void main(String[] args) {
		D07_PhoneBook2 my = new D07_PhoneBook2();
		group_create(my.phonebook , "가족");
		group_create(my.phonebook , "친구");
		add_number(my.phonebook, "친구", "010-5123-1111", "황민수", 24, 171);
		add_number(my.phonebook, "친구", "010-4517-1111", "이민수", 25, 190);
		add_number(my.phonebook, "가족", "010-1111-3333", "김민수", 23, 170);
		add_number(my.phonebook, "가족", "010-1111-1112", "김철수", 21, 180);
		add_number(my.phonebook, "가족", "010-5678-3456", "김영희", 18, 175);
		add_number(my.phonebook, "친구", "010-3178-1111", "김영희", 28, 160);
		number_search(my.phonebook, "1111");
		System.out.println("--------------------");
		name_search(my.phonebook, "수");
		System.out.println("--------------------");
		sort_number_age(my.phonebook, 6);



	}
	


}


















