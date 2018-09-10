import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int[][] values = new int[W+1][w.length+1];
        for(int j = 0; j < w.length+1; j++) values[0][j] = 0;
        for(int i = 0; i < W+1; i++) values[i][0] = 0;

        for (int i = 1; i < w.length+1; i++) {
            for(int weight = 1; weight < W+1; weight++) {
                values[weight][i] = values[weight][i-1];
                if(w[i-1] <= weight) {
                    int val = values[weight- w[i-1]][i-1] + w[i-1];
                    if(val > values[weight][i]) values[weight][i] = val;
                }
            }
        }
        return values[W][w.length];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

