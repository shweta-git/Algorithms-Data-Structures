import java.io.*;
import java.util.*;

class Node
{
    public static final int Letters =  4;
    public static final int NA      = -1;
    public int next [];

    Node ()
    {
        next = new int [Letters];
        Arrays.fill (next, NA);
    }
}

public class TrieMatching implements Runnable {
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
    List<Map<Character, Integer>> buildTrie(List <String> patterns) {
        List<Map<Character, Integer>> trie = new ArrayList<Map<Character, Integer>>();
        trie.add(0, new HashMap<Character, Integer>());
        int n = 1;
        for(String pattern : patterns){
            int current = 0;
            for(char c : pattern.toCharArray()){
                if(!trie.get(current).containsKey(c)){
                    trie.get(current).put(c, n);
                    trie.add(n, new HashMap<Character, Integer>());
                    n++;
                }
                current = trie.get(current).get(c);
            }
        }
        return trie;
    }
    
    List <Integer> solve (String text, int n, List <String> patterns) {
        List <Integer> result = new ArrayList <Integer> ();
        List<Map<Character, Integer>> trie = buildTrie(patterns);
        int i = 0;
        while(i<text.length()){
            Map<Character, Integer> root = trie.get(0);
            int j = i;
            while(j < text.length()){
                char symbol = text.charAt(j);
                if(root.containsKey(symbol)){
                    root = trie.get(root.get(symbol));
                    if(root.isEmpty()){
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
        new Thread (new TrieMatching ()).start ();
    }
}
