import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StronglyConnected {
    private static int[] visited;
    private static int[] ccnum;
    private static int cc = 0;
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        int n = adj.length;
        
        ArrayList<Integer>[] radj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            radj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < adj.length; i++) {
            for(int j = 0; j < adj[i].size(); j++){
                radj[adj[i].get(j)].add(i);
            }
        }
        ArrayList<Integer> order = toposort(radj);
        visited = new int[n];
        ccnum = new int[n];
        cc = 1;
        for (int x : order) {
            if(visited[x] == 0){
                explore(x, adj);
                cc++;
            }
        }
        Set<Integer> count = new HashSet<>();
        for(int i = 0; i < ccnum.length; i++)
            count.add(ccnum[i]);
        return count.size();
    }
    
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] radj) {
        int used[] = new int[radj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        for(int v = 0 ; v < radj.length; v++) {
            if(used[v] == 0)
                explore(radj, used, order, v);
        }
        Collections.reverse(order);
        return order;
    }

    private static void explore(ArrayList<Integer>[] radj, int[] used, ArrayList<Integer> order, int s) {
        used[s] = 1;
        for(int i = 0; i < radj[s].size(); i++){
            if(used[radj[s].get(i)] == 0)
                explore(radj, used, order, radj[s].get(i));
        }
        order.add(s);
      }

      private static void explore(int v, ArrayList<Integer>[] adj) {
        visited[v] = 1;
        ccnum[v] = cc;
        for(int i = 0; i < adj[v].size(); i++){
            if(visited[adj[v].get(i)] == 0)
                explore(adj[v].get(i), adj);
        }
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

