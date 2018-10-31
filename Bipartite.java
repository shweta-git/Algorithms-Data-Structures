import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int[] distance = new int[adj.length];
        int[] previous = new int[adj.length];
        for(int i = 0; i < adj.length; i++){
            distance[i] = -1;
            previous[i] = -1;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        distance[0] = 0;
        while(!q.isEmpty()){
            int u = q.remove();
            for(int i = 0; i < adj[u].size(); i++){
                if(distance[adj[u].get(i)] == -1){
                    q.add(adj[u].get(i));
                    distance[adj[u].get(i)] = distance[u] + 1;
                    previous[adj[u].get(i)] = u;
                } else if(distance[adj[u].get(i)] == distance[u])
                    return 0;
            }
        }
        return 1;
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
        System.out.println(bipartite(adj));
    }
}

