package part3;

public class t1 {


        public static int factorial(int n) {
            if (n == 0) { // Base case: factorial of 0 is 1
                return 1;
            } else {
                return n * factorial(n - 1); // Recursive call
            }
        }

        public static void main(String[] args) {
            int number = 5;
            int result = factorial(number);
            System.out.println("The factorial of " + number + " is: " + result);
        }


}
