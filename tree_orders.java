import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
            inOrder(result, 0);
			return result;
		}

		void inOrder(List<Integer> result, int l) {
			if(l < n) {
				if(this.left[l] != -1)
					inOrder(result, this.left[l]);
				result.add(this.key[l]);
				if(this.right[l] != -1)
				inOrder(result, this.right[l]);	
				l++;
			} else
				return;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
            preOrder(result, 0);
			return result;
		}

		void preOrder(List<Integer> result, int l) {
			if(l < n) {
				result.add(this.key[l]);
				if(this.left[l] != -1)
					preOrder(result, this.left[l]);
				if(this.right[l] != -1)
				preOrder(result, this.right[l]);	
				l++;
			} else
				return;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
            postOrder(result, 0);          
			return result;
		}

		void postOrder(List<Integer> result, int l) {
			if(l < n) {
				if(this.left[l] != -1)
					postOrder(result, this.left[l]);
				if(this.right[l] != -1)
				postOrder(result, this.right[l]);
				result.add(this.key[l]);	
				l++;
			} else
				return;
		}		
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
