package basics;

public class RevString {
	public static void main(String[] args) {
		String word = "Selenium the best";
		String t[] = word.split(" ");// split the array into words
		
		String r1 = ""; // to append the each array words finally

		for (String d : t) {// store the splitted words in d
			String r2 = ""; // to store each splitted word
			for (int e = d.length() - 1; e >= 0; e--) {
				r2 = r2 + d.charAt(e);
			}

			System.out.println(r2);

			r1 = r1 + r2 + " ";
		}

		System.out.println(r1);
	}

}
