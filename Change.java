import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int[] coins = {4, 3, 1};
        int min = 0;
        for (int i = 0; i < 3; i++) {
            int c = coins[i];
            while(m / c > 0) {
                m -= c;
                min++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

