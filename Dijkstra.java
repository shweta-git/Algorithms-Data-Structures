import java.util.*;

public class Dijkstra {
    
    private class Node {
        int vertex;
        long distance;
        int previous;
        Node(int v, long d, int p) {
            this.vertex = v;
            this.distance = d;
            this.previous = p;
        }
    }
    private static int shortestDistance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        
        Node[] nodes = new Node[adj.length];
        for(int i = 0; i < adj.length; i++){
            Dijkstra dijkstra = new Dijkstra();
            nodes[i] = dijkstra.new Node(i,Long.MAX_VALUE - 2000, -1);
        }
        
        nodes[s].distance = 0;
        Queue<Node> q = new PriorityQueue<Node>(adj.length, new Comparator<Node>() {
            @Override
            public int compare(Node v, Node u){
                return (int)(v.distance - u.distance);
            }
        });
        
        for (int i = 0; i < adj.length; i++) {
            q.offer(nodes[i]);
        }
       
        while(!q.isEmpty()){
            int u = q.poll().vertex;
            for(int i = 0; i < adj[u].size(); i++){
                int v = adj[u].get(i);
                if(nodes[v].distance > nodes[u].distance + cost[u].get(i)){
                    nodes[v].distance = nodes[u].distance + cost[u].get(i);
                    nodes[v].previous = u;
                    q.offer(nodes[v]);
                }
            }
        }
        return nodes[t].distance == Long.MAX_VALUE - 2000 ? -1 :(int)nodes[t].distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(shortestDistance(adj, cost, x, y));
    }
}

