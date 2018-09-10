import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] minSteps = new int[n+1];
        minSteps[0] = 0;
        minSteps[1] = 1;
        for (int m = 2; m <= n; m++)  {
            minSteps[m] = Integer.MAX_VALUE;
            int min = minSteps[m-1] + 1;
            if (min < minSteps[m]) minSteps[m] = min;
            if(m%2 == 0) {
                min = minSteps[m/2] + 1;
                if (min < minSteps[m])minSteps[m] = min;
            }

            if(m%3 == 0) {
                min = minSteps[m/3]+ 1;
                if (min < minSteps[m]) minSteps[m] = min;
            }
        }

        List<Integer> sequence = new ArrayList<Integer>();
        while(n > 0) {
            sequence.add(n);
            if(n%2 != 0 && n%3 != 0) n -= 1;
            else if(n%2 == 0 && n%3 == 0 ) n /=3;
            else if(n%2 == 0) {
                if(minSteps[n-1] < minSteps[n/2]) n -= 1;
                else n /= 2;
            } else if(n%3 == 0) {
                if(minSteps[n-1] < minSteps[n/3]) n -= 1;
                else n /= 3;
            }
        }

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (int x : sequence) {
            System.out.print(x + " ");
        }
    }
}

