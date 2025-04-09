package basics;

import java.util.ArrayList;
import java.util.Arrays;

public class Oppo extends Mob
{
    public int sum() {
    	return 1+1;
    }

	
	  public void spec() { //super.spec();
		  System.out.println("Specs");
	  
	  }
	 
	public static void main(String[] args) {
		Mob obj= new Oppo();
		obj.spec();
		obj.hi();
		//obj.sum();
		int arr[]=new int[4];
		arr[0]=1;
		arr[1]=99;
		arr[2]=21;
		arr[3]=33;
		Arrays.stream(arr);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
		
		ArrayList arrList= new ArrayList();
		arrList.add(0,12);
		arrList.add(0, "Hero");
		arrList.add(0, "Array");
		//arrList.set(1, 24);
		//arrList.remove(0);
     System.out.println(arrList.toString());
		for(int i=0;i<arrList.size();i++){ // 'indexed for loop' to print all the arraylist values
	        System.out.println(arrList.get(i));
	}	
	}

}