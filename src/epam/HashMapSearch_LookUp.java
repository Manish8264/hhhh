package epam;

import java.util.HashMap;

public class HashMapSearch_LookUp {
	public static void main(String[] args) {
		HashMap<String, Integer> student = new HashMap<String, Integer>();
		
		student.put("Manish", 50);
		student.put("Anish", 25);
		student.put("Rakesh", 45);
		
		System.out.println(student);
		
		System.out.println(student.containsKey("Manish"));
		System.out.println(student.get("Manish"));
		
		if (student.containsKey("Manish")) {
			System.out.println("Present");
		}else {
			System.out.println("absents");
		}
		
		
	
	}
	
	
	
	

}
