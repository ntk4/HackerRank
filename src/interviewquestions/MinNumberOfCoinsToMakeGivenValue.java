package interviewquestions;

/**
 * See the question on: http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * 
 * @author ntk4
 * 
 */
public class MinNumberOfCoinsToMakeGivenValue {

    static int[] coins = new int[] { 1, 2, 3 };
    static int V = 8;

    public static void main(String[] args) {

        System.out.println(findMinCoins(coins, V));
    }

    private static int findMinCoins(int[] coins, int V) {
        if (V == 0)
            return 0;

        int[] table = new int[V + 1];
        table[0] = 0;
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++) {

            for (int c = 0; c < coins.length; c++) {
                if (coins[c] <= i) {
                    int subRes = table[i - coins[c]];
                    if (subRes != Integer.MAX_VALUE && subRes + 1 < table[i])
                        table[i] = subRes + 1;
                }
            }
            
            printArray(table);

        }

        return table[V];
    }

    private static void printArray(int[] table) {
        for (int i=0;i< table.length;i++) {
            if (table[i] == Integer.MAX_VALUE)
                System.out.print("- ");
            else 
                System.out.print(table[i] + " ");
        }
        System.out.println();
    }
    
    
}
