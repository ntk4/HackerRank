package interviewquestions;

/**
 * http://www.geeksforgeeks.org/longest-common-substring/
 * http://www.geeksforgeeks.org/suffix-tree-application-5-longest-common-substring-2/
 * 
 * @author ntk4
 *
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "GeeksforGeeks";
        String s2 = "GeeksQuiz";

        System.out.println(lcaDynamic(s1, s2));
    }

    private static int lcaDynamic(String s1, String s2) {

        int LCA[][] = new int[s1.length() + 1][s2.length() + 1];
        int result = 0;

        for (int i = 0; i <= s1.length(); i++) {
            
            for (int j = 0; j <= s2.length(); j++) {
                
                if (i == 0 || j == 0)
                    LCA[i][j] = 0;
                
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    
                    LCA[i][j] = LCA[i - 1][j - 1] + 1;
                    result = Math.max(LCA[i][j], result);
                }

            }
        }

        return result;
    }

}
