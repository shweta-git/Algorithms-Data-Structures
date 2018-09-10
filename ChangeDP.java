import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money) {
        int[] coins = {1, 4, 3};

        int[] minNumCoins = new int[money+1];
        minNumCoins[0] = 0;
        for (int m = 1; m <= money; m++) {
            minNumCoins[m] = money + 1;
            for (int i = 0; i < coins.length; i++) {
                int numCoins = 0;
                if(m >= coins[i]) {
                    numCoins= minNumCoins[m - coins[i]] + 1;
                    if(numCoins < minNumCoins[m])
                        minNumCoins[m] = numCoins;
                }
            }
        }
        
        return minNumCoins[money];
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

