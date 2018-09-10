import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static long getFibonacciSum(long n) {
        if (n <= 1)
            return n;

        n = n % 60;
        long previous = 0;
        long current  = 1;
      
        for (long i = 0; i < n-1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }
       
        return current;
    }

    private static long getFibonacciPartialSum(long from, long to) {
        if(from <= 1) return getFibonacciSum(to % 60) % 10;

        from %= 60;
        to %= 60;

        if(to < from) to += 60;

        long sum = getFibonacciSum(to) - getFibonacciSum(from - 1);
        System.out.println("Sum = " + sum + " To = " + getFibonacciSum(to) + " From = " + getFibonacciSum(from - 1));
        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

