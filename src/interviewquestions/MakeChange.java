package interviewquestions;

public class MakeChange {

    public static void main(String[] args) {
        int[] coins = new int[] { 25, 10, 5, 1 };
        int sum = 100;

        int ways = makeChangeRecursive(sum, coins, 0);
        System.out.println(ways);

        int[][] map = new int[sum + 1][coins.length + 1];
        ways = makeChangeDynamic(sum, coins, 0, map);
        System.out.println(ways);
    }

    private static int makeChangeRecursive(int sum, int[] coins, int index) {
        if (index >= coins.length - 1)
            return 1;

        int ways = 0;
        int value = coins[index];
        for (int i = 0; i * value <= sum; i++) {
            int rest = sum - i * value;
            ways += makeChangeRecursive(rest, coins, index + 1);
        }

        return ways;
    }

  private static int makeChangeDynamic(int sum, int[] coins, int index, int[][] map) {
      if (map[sum][index] > 0)
          return map[sum][index];
      
      if (index >= coins.length - 1)
          return 1;

      int ways = 0;
      int value = coins[index];
      for (int i = 0; i * value <= sum; i++) {
          int rest = sum - i * value;
          ways += makeChangeDynamic(rest, coins, index + 1, map);
      }

      map[sum][index] = ways;
      return ways;
  }
  
}
