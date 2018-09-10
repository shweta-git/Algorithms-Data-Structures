import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int[][] d = new int[s.length() + 1][t.length() + 1];
    for (int i = 0 ; i <= s.length(); i++) d[i][0] = i;
    for (int j = 0 ; j <= t.length(); j++) d[0][j] = j;

    for (int j = 1; j <= t.length(); j++) {
      for(int i = 1; i <= s.length(); i++) {
        int insertion = d[i][j-1] + 1;
        int deletion = d[i-1][j] + 1;
        int match = d[i-1][j-1];
        int mismatch = d[i-1][j-1] + 1;
        if(s.charAt(i-1) == t.charAt(j-1)) 
          d[i][j] = Math.min(insertion, Math.min(deletion, match));
        else
          d[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
      }
    }
    return d[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
