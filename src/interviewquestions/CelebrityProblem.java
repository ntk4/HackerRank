package interviewquestions;

/**
 * http://www.geeksforgeeks.org/the-celebrity-problem/
 * 
 * @author ntk4
 *
 */
public class CelebrityProblem {

    //@formatter:off
    static boolean [][] matrix = new boolean[][] {
            {false, true, true, true}, // =person 0 knows everyone else
            {false, false, true, false},
            {false, false, false, false},// =person 2 knows nobody
            {false, false, true, false}
        };
    //@formatter:on

    public static void main(String[] args) {

        System.out.println(new CelebrityProblem().findCelebrity(4)); // 4 = total number of people

    }

    private boolean knows(int a, int b) {
        return matrix[a][b];
    }

    public int findCelebrity(int n) {

        int a = 0;
        int b = n - 1;

        while (a < b) {
            if (knows(a, b))
                a++;
            else
                b--;
        }

        for (int i = 0; i < n; i++) {
            if (i != a && (knows(a, i) || !knows(i, a)))
                return -1;
        }

        return a;
    }

}
