import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long gcd_euclid(long a, long b) {
    if (b==0) return a;
    a = a%b;

    return gcd_euclid(b, a);
  }

  private static long lcm(long a, long b) {
    if(a==0 && b==0) return 0;
    long gcd = gcd_euclid(a,b);
    
    return (a * b)/gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
