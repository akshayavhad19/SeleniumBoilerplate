package basics;

public class StringManupulation {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hi");
		sb.append("Bro");
		sb.insert(2, ",");
		sb.insert(6, 4);
		sb.reverse();
		System.out.println(sb.toString());
		System.out.println(sb.capacity());
		//sb.delete(3, 10);
		System.out.println(sb.toString());
	}
}
