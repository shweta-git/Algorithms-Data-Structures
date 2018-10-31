import java.io.*;
import java.util.*;

class Node
{
	public static final int Letters =  4;
	public static final int NA      = -1;
	public int next [];
	public boolean patternEnd;

	Node ()
	{
		next = new int [Letters];
		Arrays.fill (next, NA);
		patternEnd = false;
	}
}

public class TrieMatchingExtended implements Runnable {
	int letterToIndex (char letter)
	{
		switch (letter)
		{
			case 'A': return 0;
			case 'C': return 1;
			case 'G': return 2;
			case 'T': return 3;
			default: assert (false); return Node.NA;
		}
	}

	List<Node> buildTrie(List <String> patterns) {
        List<Node> trie = new ArrayList<Node>();
        trie.add(new Node());
        int n = 1;
        for(String pattern : patterns){
            Node current = trie.get(0);
            for(char c : pattern.toCharArray()){
				int j = letterToIndex(c);
                if(current.next[j] == Node.NA){
                    trie.add(new Node());
                    current.next[j] = trie.size() - 1;
                    current = trie.get(trie.size() - 1);
                } else
                	current = trie.get(current.next[j] );
			}
			current.patternEnd = true;
        }
        return trie;
    }

	List <Integer> solve (String text, int n, List <String> patterns) {
		List <Integer> result = new ArrayList <Integer> ();
		List<Node> trie = buildTrie(patterns);
        int i = 0;
        while(i<text.length()){
            Node root = trie.get(0);
            int j = i;
            while(j < text.length()){
                int symbol = letterToIndex(text.charAt(j));
                if(root.next[symbol] != Node.NA){
                    root = trie.get(root.next[symbol]);
                    if(root.patternEnd){
                        result.add(i);
                        break;
                    }
                    j++;  
                } else
                    break;
            }
            i++;
        }
        return result;
	}

	public void run () {
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
			String text = in.readLine ();
		 	int n = Integer.parseInt (in.readLine ());
		 	List <String> patterns = new ArrayList <String> ();
			for (int i = 0; i < n; i++) {
				patterns.add (in.readLine ());
			}

			List <Integer> ans = solve (text, n, patterns);

			for (int j = 0; j < ans.size (); j++) {
				System.out.print ("" + ans.get (j));
				System.out.print (j + 1 < ans.size () ? " " : "\n");
			}
		}
		catch (Throwable e) {
			e.printStackTrace ();
			System.exit (1);
		}
	}

	public static void main (String [] args) {
		new Thread (new TrieMatchingExtended ()).start ();
	}
}
