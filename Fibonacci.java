import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long calc_fib_table(int n) {
    if (n <= 1)
      return n;
    long[] fib = new long[n+1];
    fib[0] = 0;
    fib[1] = 1;
   for (int i = 2; i <= n; i++)
    fib[i] = fib[i-1] + fib[i-2];

    return fib[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_table(n));
  }
}
