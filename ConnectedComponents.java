import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int[] visited;
    private static int[] ccnum;
    private static int cc = 0;
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int n = adj.length;
        visited = new int[n];
        ccnum = new int[n];
        cc = 1;
        for(int v = 0; v < n; v++){
            if(visited[v] == 0) {
                explore(v, adj);
                cc++;
            } 
        }
        return --cc;
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
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

