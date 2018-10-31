import java.util.*;
import java.text.DecimalFormat;

import javax.lang.model.util.ElementScanner6;

public class ConnectingPoints {
    private static class Edge {
        int u;
        int v;
        double w;
        
        Edge(int u, int v, double w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static class DisjointSets {
        int[] parent;
        int[] rank;

        public DisjointSets(int n){
            parent = new int[n];
            rank = new int[n];
        }    

        public void makeSet(int i){
            parent[i] = i;
            rank[i] = 1;
        }

        public int find(int i){
            if(parent[i] == i) return i;
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int i, int j){
            int ri = find(i);
            int rj = find(j);
            if(ri == rj) return;
            if(rank[ri] < rank[rj])
                parent[ri] = rj;
            else if (rank[ri] > rank[rj])
                parent[rj] = ri;
            else{
                parent[rj] = ri;
                rank[ri]++;
            }
        }
    
    }
    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        DisjointSets s = new DisjointSets(x.length);
        Queue<Edge> q = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.w < e2.w ? -1 : 1;
            }
        });
        
        for(int i = 0; i < x.length; i++) s.makeSet(i);
        
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x.length; j++){
                q.offer(new Edge(i, j, Math.sqrt(Math.pow((x[i] - x[j]), 2) + Math.pow((y[i] - y[j]), 2))));
            }
        }
        while(!q.isEmpty()){
            Edge e = q.poll();
            if(s.find(e.u) != s.find(e.v)) {
                s.union(e.u, e.v);
                result += e.w;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(new DecimalFormat("#0.0000000").format(minimumDistance(x, y)));
    }
}

