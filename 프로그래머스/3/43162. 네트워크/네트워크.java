import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Set<Integer> notVisited = new HashSet<>();
        for(int i = 0; i < n; i ++) {
            notVisited.add(i);
        }
        
        for(int i = 0; i < n; ++i) {
            if(!notVisited.contains(i)) continue;
            
            // 탐색
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                notVisited.remove(cur);
                for(int dest = 0; dest < n; ++dest) {
                    if(!notVisited.contains(dest)) continue;
                    
                    int connected = computers[cur][dest];
                    if (connected == 1) {
                        q.add(dest);
                    }
                }
            }
            
            answer++;
        }

        return answer;
    }
}