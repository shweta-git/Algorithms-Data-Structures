import java.util.Scanner;

public class FractionalKnapsack {
    
    private static int findMax(long[] values, long[] weights) {
        int index = -1;
        double max = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > 0 && ((values[i] * 1.0 )/weights[i]) > max) {
                max = (values[i] * 1.0)/weights[i];
                index = i;
            }
        }
        return index;
    }
    private static double getOptimalValue(long capacity, long[] values, long[] weights) {
        if (capacity == 0) return 0;
        double value = 0;
        int n = values.length;
        
        for (int i = 0; i < n; i++) {
            if (capacity == 0) return value;
            int index = findMax(values, weights);
            if(index >= 0) {
                double a = Math.min(weights[index], capacity);
                value += a * (((values[index] * 1.0)/weights[index]));
                weights[index] -= a;
                capacity -= a;
            }

        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long capacity = scanner.nextInt();
        long[] values = new long[n];
        long[] weights = new long[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f", getOptimalValue(capacity, values, weights));
    }
} 
