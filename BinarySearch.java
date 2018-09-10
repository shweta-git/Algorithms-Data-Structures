import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(long[] a, long x) {
        int left = 0, right = a.length - 1;
       
        /*while(left <= right) {
            int mid  = left + (right-left)/2;
            if (a[mid] == x) return mid;
            if(x < a[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;*/

        return binarySearch(a, x, left, right);
    }

    static int binarySearch(long[]a, long x, int left, int right) {
        if(right < left) return -1;
        int mid = left + (right-left)/2;
        if(x == a[mid]) return mid;
        if(x < a[mid]) return binarySearch(a, x, left, mid-1);
        else return binarySearch(a, x, mid+1, right);
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        long[] b = new long[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
