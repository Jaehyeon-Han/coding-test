import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 인접행렬 표현
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                graph[i][j] = -1;
            }
        }
        for (int i = 0; i < wires.length; ++i) {
            int begin = wires[i][0], end = wires[i][1];
            
            graph[begin][end] = graph[end][begin] = 1;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; ++i) {
            int begin = wires[i][0], end = wires[i][1];
            graph[begin][end] = graph[end][begin] = -1;
            
            min = Math.min(count(graph), min);
            
            graph[begin][end] = graph[end][begin] = 1;
        }
        
        return min;
    }
    
    // 두 트리 크기의 차이값 반환
    int count(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int count = 1;
        
        // bfs
        Queue<Integer> toVisit = new ArrayDeque<>();
        toVisit.add(1);
        visited[1] = true;
        while(!toVisit.isEmpty()) {
            int here = toVisit.poll();
            
            for (int there = 1; there < graph.length; ++there) {
                if (graph[here][there] == 1 && !visited[there]) {
                    visited[there] = true;
                    toVisit.add(there);
                    count++;
                }
            }
        }
        
        return Math.abs(graph.length - 1 - 2 * count);
    }
}