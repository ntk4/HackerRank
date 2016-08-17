package algorithms.graphtheory;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Not a fully correct solution. Only the 1st test case succeeds on hackerrank
 *
 */
public class DijkstraShortestReach2 {

    static class Edge {
        public int from;
        public int to;
        public int length;

        public Edge(int from, int to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
        }
    }

    private int nodes;
    private Edge[] edges;
    private int start;
    private List<Edge>[] adjList;

    public DijkstraShortestReach2(int nodes, Edge[] edges, int start) {
        this.nodes = nodes;
        this.edges = edges;
        this.start = start;
        constructAdjacencyList();
    }

    @SuppressWarnings("unchecked")
    private void constructAdjacencyList() {
        adjList = (List<Edge>[]) new LinkedList<?>[nodes];

        for (int edgeIndex = 0; edgeIndex < edges.length; edgeIndex++) {
            Edge edge = edges[edgeIndex];

            if (edge.from >= 0 && adjList[edge.from - 1] == null)
                adjList[edge.from - 1] = new LinkedList<Edge>();
            adjList[edge.from - 1].add(edge);

            if (edge.to >= 0 && adjList[edge.to - 1] == null)
                adjList[edge.to - 1] = new LinkedList<Edge>();
            Edge reverse = new Edge(edge.to, edge.from, edge.length);
            adjList[edge.to - 1].add(reverse);
        }
    }

    private Integer[] calculateShortestPaths() {
        Integer[] distTo = new Integer[nodes];
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            distTo[i] = null;
            visited[i] = false;
        }

        Queue<Integer> pQueue = new PriorityQueue<Integer>();
        pQueue.add(start);
        distTo[start - 1] = 0;

        while (!pQueue.isEmpty()) {
            int currentNode = pQueue.poll();
            if (visited[currentNode - 1])
                continue;
            visited[currentNode - 1] = true;

            // relax connected nodes
            for (Edge edge : adjList[currentNode - 1]) {
                if (distTo[edge.to - 1] == null
                        || (distTo[edge.from - 1] != null && distTo[edge.to - 1] > distTo[edge.from - 1] + edge.length)) {
                    distTo[edge.to - 1] = distTo[edge.from - 1] + edge.length;
                }
                pQueue.add(edge.to);
            }
            adjList[currentNode - 1].clear(); // test
        }

        return distTo;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int testcase = 0; testcase < testCases; testcase++) {
            int nodes = in.nextInt();
            int edgeCount = in.nextInt();
            Edge[] edges = new Edge[edgeCount];

            for (int edgeIndex = 0; edgeIndex < edgeCount; edgeIndex++) {
                edges[edgeIndex] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
            }
            int start = in.nextInt();

            DijkstraShortestReach2 dijkstra = new DijkstraShortestReach2(nodes, edges, start);
            Integer[] distances = dijkstra.calculateShortestPaths();

            for (int i = 0; i < distances.length; i++) {
                if (i != start - 1 && distances[i] != null)
                    System.out.print(distances[i] + " ");
                else if (distances[i] == null)
                    System.out.print("-1 ");
            }
        }
        in.close();
    }

}
