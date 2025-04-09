package basics;

import java.lang.reflect.Array;

public class MainMethodOverloading {
	public static void main(String[] args) {
    System.out.println("Main method");
    // this only the method will get execute due to the signature
    // to run other methods needs to call from here using class name
      //MainMethodOverloading.main(new[] {10,20,30});
      MainMethodOverloading.main ("hehehe");
      
      Array []arr=new Array[4];
	}
	public static void main(String args) {
		System.out.println("Main method1");
	}
	public static void main(int [] args) {
		System.out.println("Main method2");
	}
}
