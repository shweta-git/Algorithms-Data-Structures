import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        int total = 0;
        for(int i = 0; i < A.length; i++) total += A[i];
        if(A.length < 3 || total%3 != 0) return 0;
        int third = total/3;
        int[][] table = new int[third+1][A.length+1];
        
        for(int i = 1; i <= third; i++) {
            for(int j = 1; j <= A.length; j++) {
                int k = i - A[j-1];
                if(A[j-1] == i || (k > 0 && table[k][j-1] > 0)) {
                    if (table[i][j-1] == 0) table[i][j] = 1;
                    else table[i][j] = 2;
                } else 
                    table[i][j] = table[i][j-1];
            }
        }
        return table[third][A.length] == 2 ? 1:0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

