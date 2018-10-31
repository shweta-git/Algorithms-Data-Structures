import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        for(int v = 0 ; v < adj.length; v++) {
            if(used[v] == 0)
                explore(adj, used, order, v);
        }
        Collections.reverse(order);
        return order;
    }

    private static void explore(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
        used[s] = 1;
        for(int i = 0; i < adj[s].size(); i++){
            if(used[adj[s].get(i)] == 0)
                explore(adj, used, order, adj[s].get(i));
        }
        order.add(s);
      }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

