import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int[] visited;
    private static int[] stack;
    private static int acyclic(ArrayList<Integer>[] adj) {
        int n = adj.length;
        visited = new int[n];
        stack = new int[n];
        for(int v = 0; v < n; v++){
            if(explore(v, adj))
                return 1;
        }
        return 0;
    }

    private static boolean explore(int v, ArrayList<Integer>[] adj) {
        if(stack[v] == 1) return true;
        if(visited[v] == 1) return false;
        visited[v] = 1;
        stack[v] = 1;
        for(int i = 0; i < adj[v].size(); i++){
            if(explore(adj[v].get(i), adj))
                return true;;
        }
        stack[v] = 0;
        return false;
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
        System.out.println(acyclic(adj));
    }
}

