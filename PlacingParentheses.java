import java.util.Scanner;

public class PlacingParentheses {

    private static int[] minMax(int i, int j, char[] ops, int[][] max, int[][] min) {
        int minT = Integer.MAX_VALUE;
        int maxT = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            int a = eval(max[i][k], max[k+1][j], ops[k]);
            int b = eval(max[i][k], min[k+1][j], ops[k]);
            int c = eval(min[i][k], max[k+1][j], ops[k]);
            int d = eval(min[i][k], min[k+1][j], ops[k]);
            minT = Math.min(minT,Math.min(a,Math.min(b,Math.min(c,d))));
            maxT = Math.max(maxT,Math.max(a,Math.max(b,Math.max(c,d))));
        }

        int[] res = new int[]{minT, maxT};
        return res;
    }
    private static long getMaximValue(String exp) {
        int[] digits = new int[exp.length()/2+1];
        char[] ops = new char[digits.length-1];
        
        for(int i = 0; i < exp.length(); i++) {
            if(i%2 != 0)
                ops[i/2] = exp.charAt(i); 
            else
                digits[i/2] = Character.getNumericValue(exp.charAt(i));
        }
       
        int n = digits.length;
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        for(int i = 0; i < n; i++) {
            max[i][i] = digits[i];
            min[i][i] = digits[i];
        }
        for (int s = 0; s < n-1; s++) {
            for(int i = 0; i < n-s-1; i++){
                int j = i + s + 1;
                int[] values = minMax(i, j, ops, max, min);
                min[i][j] = values[0];
                max[i][j] = values[1];
            }
        }
      
        return max[0][n-1];
    }

    private static int eval(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

