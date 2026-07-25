public class FibonacciCheck {
 public static void main(String[] args) {
  int n = 34;
  if (isFibonacci(n)) {
      System.out.println("Fibonacci");
  } else {
      System.out.println("Not Fibonacci");
  }
   }

   static boolean isFibonacci(int n) {
     return isPerfectSquare(5 * n * n + 4) ||
             isPerfectSquare(5 * n * n - 4);
   }
   static boolean isPerfectSquare(int x) {
       int s = (int) Math.sqrt(x);
       return s * s == x;

   }

}

