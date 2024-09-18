package epam;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

public class HashMapIterate {
	
	static HashMap<String, Integer> country= new HashMap<>();
	
	public static void main(String[] args) {
		country.put("India",15);
		country.put("China", 75);
		
		
		//Iterate over HashMap:Map.Entry<key,value> e: HashMap_name.entrySet()
		
		for (Map.Entry<String, Integer> entry : country.entrySet()) {

			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
		}
		
		//using Set to find only keys
		
		Set<String> keys = country.keySet();
		 for(String key :keys) {
			 System.out.println(key + " " + country.get(key)) ;
		 }
		
		
	}

}
