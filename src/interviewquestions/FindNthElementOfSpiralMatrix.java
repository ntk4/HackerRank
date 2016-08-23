package interviewquestions;

public class FindNthElementOfSpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int k = 4;

        System.out.println(new FindNthElementOfSpiralMatrix().findK(matrix, 3, 3, k));
    }

    public int findK(int A[][], int n, int m, int k) {
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                k--;
                
                if (k == 0) {
                
                    if (i % 2 == 0) {
                        return A[i][j];
                    } else return A[i][A[i].length - 1 - j];
                }
            }
        }

        // TODO: change
        return 0;
    }
}
