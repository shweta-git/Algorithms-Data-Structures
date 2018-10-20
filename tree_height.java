import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	
	class TreeNode {
		int node;
		LinkedList<TreeNode> children;

		TreeNode(int node) {
			this.node = node;
			children = new LinkedList<>();
		}

		void addChild(TreeNode child) {
			this.children.add(child);
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight_naive() {
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}

		TreeNode buildTree(int[] parent) {
			TreeNode[] tree = new TreeNode[parent.length];
			for (int vertex = 0; vertex < n; vertex++) {
				tree[vertex] = new TreeNode(vertex);
			}

			TreeNode root = new TreeNode(0);
			for (int vertex = 0; vertex < n; vertex++) {
				if(parent[vertex] == -1) {
					root = tree[vertex];
				} else {
					tree[parent[vertex]].addChild(tree[vertex]);
				}
			}
			return root;
		}
		int computeHeight() {
			int maxHeight = 0;
			TreeNode root = buildTree(parent);
			
			Queue<TreeNode> q = new LinkedList<>(); 
			q.add(root); 
			while (!q.isEmpty()) {
				int count = q.size();
				maxHeight++;
				while (count > 0) {
					TreeNode node = q.peek();
					q.remove();
					while(!node.children.isEmpty()) {
						q.add(node.children.poll());
					}
					count--;
				}
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
