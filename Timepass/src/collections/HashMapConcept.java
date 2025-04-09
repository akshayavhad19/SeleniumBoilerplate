package collections;

import java.util.HashMap;

public class HashMapConcept {
	public static void main(String[] args) {
		
		//works in K n V pair, Not in order, duplicates not allowed it will override
		//only one null key allowed, many null values allowed
		HashMap<Integer, String> usrMap= new HashMap<Integer, String>();
		usrMap.put(101, "Rodger");
		usrMap.put(102, "Bhai");
		usrMap.put(202, "Bro");
		usrMap.put(103, "Bro");
		usrMap.put(1001, "Patel");
		usrMap.put(null, null);
		usrMap.put(null, "Me");
		// fetch
		System.out.println(usrMap.get(101));
		
		System.out.println(usrMap);
		
	}
}
