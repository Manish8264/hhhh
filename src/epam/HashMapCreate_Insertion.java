package epam;

import java.util.HashMap;

public class HashMapCreate_Insertion {
	public static void main(String[] args) {
		
		//syntax to create HashMap
		
		HashMap<String, Integer> country= new HashMap<String, Integer>();
		
		//put: used to add key values in HashMap
		
		country.put("India", 150);
		country.put("China", 100);
		country.put("USA", 200);
		
		System.out.println(country);
		
		//put():if key exists then it will update the value or else create new pair
		System.out.println("key exists");
		country.put("China", 158);
		System.out.println(country);
	}
	
	

}
