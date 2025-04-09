package basics;
public class CondOperator {
 public static void main(String[] args) {
	int x=700;
	int y=900;
	int z= 450;
	int z1=500;
	
	if(x>y&&x>z&&x>z1) {
		System.out.println(x +" is grater" );
	}
	else if (y>z&&y>z1)	 {
		System.out.println(y+" is greater");
		
	}
	else if (z>z1) {
		System.out.println(z+ " is greater");
		
	}
	else {
		System.out.println(z1+ " is greater");
	}
	
	int j=1;
	while(j<=50) {
		System.out.println(j);
		if (j%5==0) {
			System.out.println("Hi"+j);
		}
		j++;
	}
}
}
