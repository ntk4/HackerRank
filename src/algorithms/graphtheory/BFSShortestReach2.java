package algorithms.graphtheory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Just experimenting, do not use this code!
 * @param args
 */
public class BFSShortestReach2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCaseIndex = 0; testCaseIndex < testCases; testCaseIndex++) {
            int numNodes = scanner.nextInt();
            int numEdges = scanner.nextInt();
            // System.out.println("Nodes=" + numNodes +", edges=" + numEdges);
            // int[][] edges = new int[numEdges][2];
            @SuppressWarnings("unchecked")
            List<Integer>[] adjList = (List<Integer>[]) new List[numNodes];

            for (int edgeIndex = 0; edgeIndex < numEdges; edgeIndex++) {
                int from = scanner.nextInt() - 1;
                int to = scanner.nextInt() - 1;

                // System.out.println("from=" + from + ", to=" + to + ", adjList length=" + adjList.length);

                if (from >= 0 && adjList[from] == null)
                    adjList[from] = new ArrayList<Integer>();
                adjList[from].add(new Integer(to));

                if (to >= 0 && adjList[to] == null)
                    adjList[to] = new ArrayList<Integer>();
                adjList[to].add(new Integer(from));

                // System.out.println(""+ edgeIndex + "="+edges[edgeIndex][0] +","+edges[edgeIndex][1]);
            }

            int start = scanner.nextInt() - 1;
            // System.out.println("start=" +start);
            short[] distancesFromStart = new short[numNodes];
            short[] visited = new short[numNodes];

            for (int i = 0; i < numNodes; i++) {
                distancesFromStart[i] = -1;
                visited[i] = -1;
            }

            distancesFromStart[start] = 0;

            populateDistances(start, adjList, distancesFromStart, visited);

            for (int index = 0; index < distancesFromStart.length; index++) {
                if (index != start)
                    System.out.print((distancesFromStart[index] == -1 ? -1 : distancesFromStart[index] * 6) + " ");
            }

            /*
             * for (int nodeIndex=0; nodeIndex < numNodes; nodeIndex++) { if (nodeIndex != start) { int cost =
             * findPath2(start, nodeIndex, adjList, new ArrayList<Integer>()); System.out.print("cost for " + nodeIndex
             * + "=" + cost + " "); } }
             */

            System.out.println();
        }
        
        scanner.close();
    }

    private static void populateDistances(int start, List<Integer>[] adjList, short[] distances,
            short[] visited) {
        if (adjList[start] == null)
            return;
        if (visited[start] != -1)
            return;

        // System.out.println("start="+start);
        visited[start] = 1;
        for (int currNode : adjList[start]) {
            if (distances[currNode] == -1 || distances[currNode] > distances[start] + 1) {
                distances[currNode] = (short)(distances[start] + 1);
            }
        }
        for (int currNode : adjList[start]) {
            if (distances[currNode] != 0)
                populateDistances(currNode, adjList, distances, visited);
        }
    }

}