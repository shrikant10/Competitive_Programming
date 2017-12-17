package Algorithms;

import java.lang.*;
import java.util.*;

public class Dijkstra {

    static int n = 9;
    static int inf = -1;

    static void dijkstra(int edge[][], int s) {
        int dist[] = new int[n];
        int path[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        path[s] = -1;
        HashSet<Integer> visited = new HashSet<Integer>();
        int u = -1;
        while (visited.size() < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }
            visited.add(u);
            for (int v = 0; v < n; v++) {
                if (edge[u][v] != inf) {
                    if (dist[v] > dist[u] + edge[u][v]) {
                        dist[v] = dist[u] + edge[u][v];
                        path[v] = u;
                    }
                }
            }
        }
        print_dist(dist);
        print_path(path);
    }

    static void print_dist(int dist[]) {
        for (int i = 0; i < n; i++) {
            System.out.println("Dist of node " + i + " : " + dist[i]);
        }
    }

    static void print_path(int path[]) {
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int parent = path[i];
            int count = 1;
            list.add(i);
            while (parent != -1) {
                list.add(parent);
                parent = path[parent];
                count++;
            }
            //Iterator itr = list.iterator();
            while (count > 0) {
                count--;
                System.out.print(" -> " + list.get(count));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        int edge[][] = {
                {inf, 4, inf, inf, inf, inf, inf, 8, inf},
                {4, inf, 8, inf, inf, inf, inf, 11, inf},
                {inf, 8, inf, 7, inf, 4, inf, inf, 2},
                {inf, inf, 7, inf, 9, 14, inf, inf, inf},
                {inf, inf, inf, 9, inf, 10, inf, inf, inf},
                {inf, inf, 4, 14, 10, inf, 2, inf, inf},
                {inf, inf, inf, inf, inf, 2, inf, 1, 6},
                {8, 11, inf, inf, inf, inf, 1, inf, 7},
                {inf, inf, 2, inf, inf, inf, 6, 7, inf},
        };
        dijkstra(edge, 0);
    }
}