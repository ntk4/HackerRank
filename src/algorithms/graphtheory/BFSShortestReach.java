package algorithms.graphtheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

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
                    int cost = findPath2(start, nodeIndex, adjList, new ArrayList<Integer>());
                    System.out.print(/*"cost for " + nodeIndex + "=" + */cost + " ");
                }
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    private static int findPath2(int start, int end, List<Integer>[] adjList, List<Integer> path) {
        if (start == end) return 0;
        
        int minCost = Integer.MAX_VALUE;
        
        for (Integer connectedInt: adjList[start]) {
            //System.out.println("start=" + start + ",connectedInt=" + connectedInt);
            if (connectedInt == end) {
                path.add(connectedInt);
                return 6;
            } else if (!path.contains(connectedInt)) {
                path.add(connectedInt);
                int subCost = findPath2(connectedInt, end, adjList, path);
                
                if (subCost <= 0) {
                    continue;
                }
                else if (subCost < minCost) {
                    minCost = 6 + subCost;
                }
            }
        }
        
        if (minCost < Integer.MAX_VALUE) {
            return minCost;
        } else {
            return -1;
        }
    }
    
    
    
    
    
    
    
    
    private static int findPath(int start, int end, int[][] edges) {
        if (start == end) return 0;
        int minCost = Integer.MAX_VALUE;
        
        for (int edgeIndex=0;edgeIndex < edges.length; edgeIndex++) {
            if (edges[edgeIndex][0] == start) {
                if (edges[edgeIndex][1] == end) {
                    return 6;
                } else {
                    int subCost = findPath(edges[edgeIndex][1], end, edges);
                    if (subCost == -1)
                        continue;
                    else if (subCost >= 0 && subCost < minCost) {
                        minCost = subCost;
                    }
                    //else return 6 + subCost;
                }
            }
        }
        
        if (minCost < Integer.MAX_VALUE) {
            return minCost;
        } else {
            return -1;
        }
    }
}