package interviewquestions;

/**
 * 
 * @author ntk4
 *
 */
public class MatrixRotation {

    private final int MATRIX_SIZE = 4;

    private final int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];

    public static void main(String[] args) {
        
        MatrixRotation mr = new MatrixRotation();
        mr.populateArray();
        mr.printArray();
        
        mr.rotate();
        mr.printArray();

    }
    
    private void populateArray() {
        int val = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                matrix[i][j] = val++;
            }
            System.out.println();
        }

    }

    private void printArray() {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void rotate() {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length)
            return;

        int n = matrix.length; // should be MATRIX_SIZE
        int temp = 0;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            
            for (int index = first; index < last; index++) {
                temp = matrix[first][index];
                int offset = index - first;
                
                // left -> top
                matrix[first][index] = matrix[last - offset][first];
                
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                
                // right -> bottom
                matrix[last][last - offset] = matrix[index][last];
                
                // top -> right
                matrix[index][last] = temp;
            }
        }

    }
}
