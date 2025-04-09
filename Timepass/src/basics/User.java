package basics;

import java.util.Arrays;

public class User {

	String name;
	int age;
	String city;
	
	public static void main(String[] args) {
		
		User u1= new User();
		u1.name="Raju";
		u1.age=20;
		u1.city="Rahata";
		System.out.println(u1.toString());
		
		User u2= new User();
		u2.name="Rastogi";
		u2.age=25;
		u2.city="IIM";
		System.out.println(u2.toString());
		int arr1[]= {10,20,30};
		u1.testData(arr1);
		
	}
	public String toString() {
		String output= "I'm "+ name+ " from "+ city +" hvaing age "+ age ;
		return output ;
	}
   public void testData(int [] arr) {
	   System.out.println("Array= "+ Arrays.toString(arr) );
   }
}
