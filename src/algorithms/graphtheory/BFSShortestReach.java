package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestReach {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCaseIndex=0; testCaseIndex < testCases; testCaseIndex++) {
            int numNodes = scanner.nextInt();
            int numEdges = scanner.nextInt();
            //System.out.println("Nodes=" + numNodes +", edges=" + numEdges);
            //int[][] edges = new int[numEdges][2];
            @SuppressWarnings("unchecked")
            List<Integer>[] adjList = (List<Integer>[])new List[numNodes];
            
            for (int edgeIndex=0;edgeIndex < numEdges; edgeIndex++) {
                int from = scanner.nextInt() - 1;
                int to = scanner.nextInt() - 1;
                
                //System.out.println("from=" + from + ", to=" + to + ", adjList length=" + adjList.length);
                
                if (from >= 0 && adjList[from] == null)
                    adjList[from] = new ArrayList<Integer>();
                adjList[from].add(new Integer(to));
                
                
                if (to >= 0 && adjList[to] == null)
                    adjList[to] = new ArrayList<Integer>();
                adjList[to].add(new Integer(from));
                
                //System.out.println(""+ edgeIndex + "="+edges[edgeIndex][0] +","+edges[edgeIndex][1]);
            }
            
            int start = scanner.nextInt() - 1;
            //System.out.println("start=" +start);
            
            for (int nodeIndex=0; nodeIndex < numNodes; nodeIndex++) {
                if (nodeIndex != start) {
                    int cost = findPath(start, nodeIndex, adjList);
                    System.out.print(/*"cost for " + nodeIndex + "=" + */cost + " ");
                }
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    
    
    
    
    
    
    
    private static int findPath(int start, int end, List<Integer>[] adjList) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // The cost map acts also as "visited" information. Contains the cost to reach a node
        Map<Integer, Integer> cost = new HashMap<Integer, Integer>(); 
        
        queue.add(start);
        cost.put(start, 0);
        int runningCost = 0;
        
        while (!queue.isEmpty()) {
            int value = queue.poll();
            runningCost = cost.get(value);
            
            if (value == end) {
                return runningCost;
            }

            runningCost += 6;
            
            if (adjList.length > value && value >= 0 && adjList[value] != null)
                for (int edge: adjList[value]) {
                    if (cost.get(edge) == null) {
                        cost.put(edge, runningCost);
                        queue.add(edge);
                    }
                }
            
        }
        
        return -1;

    }
}