import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; ++i) {
            map.put(i, new ArrayList<Integer>());
        }
        
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        for(int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> toVisit = new ArrayDeque<>();
        toVisit.add(1);
        visited[1] = true;
        
        while(!toVisit.isEmpty()) {
            int cur = toVisit.poll();
            
            List<Integer> dsts = map.get(cur);
            for(int dst : dsts) {
                if (visited[dst]) continue;
                
                visited[dst] = true;
                distance[dst] = distance[cur] + 1;
                toVisit.add(dst);
            }
        }
        
        int maxValue = 0;
        int maxCount = 0;
        for (int i = 2; i <= n; ++i) {
            if (distance[i] == maxValue) maxCount++;
            else if (distance[i] > maxValue) {
                maxValue = distance[i];
                maxCount = 1;
            }
        }
        
        return maxCount;
    }
}


/*
- 입력: 노드 개수 n, 간선 edges
- 출력: 1번 노드에서 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드 = BFS에서 마지막에 방문하는 노드

- 각 노드에서 갈 수 있는 간선 목록을 정리
- 1번에서부터 시작
- distance를 저장하면서 BFS
- 마지막 distance도 저장
*/