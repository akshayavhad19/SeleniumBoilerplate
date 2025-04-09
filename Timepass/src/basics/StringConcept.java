package basics;

import java.util.Arrays;

public class StringConcept {

	public static String revString(String s2) {

		String []s= s2.split(" ");
		//System.out.println(s[1]);

		String rev1="";
		for (int d=0;d<s.length;d++) {
			String rev2 = "" ;

			for (int j=s[d].length()-1;j>=0;j--) {
				rev2=rev2+s[d].charAt(j);
			}
			System.out.println(rev2);
			rev1=rev1+rev2+" ";
		}
		return rev1;

//		String r1 = ""; // to append the each array words finally
//
//		for (String d : t) {// store the splitted words in d
//			String r2 = ""; // to store each splitted word
//			for (int e = d.length() - 1; e >= 0; e--) {
//				r2 = r2 + d.charAt(e);
//			}
//
//			System.out.println(r2);
//
//			r1 = r1 + r2 + " ";


		//	  int len= s2.length();
		//	  String revS = "" ;
		//	  for (int j=len-1;j>=0;j--) {
		//		  revS=revS+s2.charAt(j);  
		//	  }
		//		
		//		return revS;
	}

	public static void main(String[] args) {
		//		String str= "Hi i am Tory iWega";
		//		System.out.println(str.charAt(3));
		//		System.out.println(str.indexOf("T"));
		//		System.out.println(str.indexOf("i"));// 1st occ of i
		//		System.out.println(str.indexOf("i", str.indexOf("i")+1));//2nd occ
		//		int i= str.indexOf("i", str.indexOf("i")+1);
		//		System.out.println(str.indexOf("i", i+1));
		//
		//		String[] str1= str.split(" ");
		//
		//		System.out.println(Arrays.toString(str1));
		//
		//		String s1= "Akshay";
		//		System.out.println(s1.concat("2"));
		//		System.out.println(s1);
		//
		//		//  int to string
		//		int age=30;
		//		String ageval= String.valueOf(age);
		//		System.out.println(ageval.charAt(0));

		String s2= "Selenium is good";
		String value= StringConcept.revString(s2);
		System.out.println(value);


	}


}
