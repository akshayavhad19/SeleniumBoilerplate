package basics;

public class ExceptionHandling {
	   public static void validate(int age) {
           if (age < 18) {
                        // throw Arithmetic exception if not eligible to vote
              throw new ArithmeticException("Person is not eligible to vote");
             } 
                   else {
                        System.out.println("Person is eligible to vote!!");
                    }
        }
        
        public static void main(String[] args) {
                
                System.out.println("11");
                System.out.println("Before divide");
                validate(20);
                
                try {
                        int x = 1 / 0;
                        System.out.println("After divide");
                } 
                
                catch (ArithmeticException e) 
                // Here, e is a reference variable of exception object.
                {
                        System.out.println("A number cannot be divided by zero");
                }
                finally  
                // Here, e is a reference variable of exception object.
                {
                        System.out.println("I'm Finally");
                }
                
                System.out.println("22");
        }
}


