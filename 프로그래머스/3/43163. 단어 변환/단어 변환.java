import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Map<String, Integer> wordIndex = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            wordIndex.put(words[i], i);
        }
        
        if (wordIndex.get(target) == null) {
            return 0;
        }
        
        return bfs(toGraph(words, begin), words.length, wordIndex.get(target));
    }
    
    int bfs(List<List<Integer>> graph, int src, int dst) {
        int[] distance = new int[graph.size()];
        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (visited[next]) continue;

                visited[next] = true;
                distance[next] = distance[cur] + 1;

                if (next == dst) return distance[next];

                q.add(next);
            }
        }

        return 0;
    }
    
    List<List<Integer>> toGraph(String[] words, String src) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < words.length + 1; ++i) {
            List<Integer> edges = new ArrayList<>();
            graph.add(edges);
        }
        
        for (int end = 0; end < words.length; ++end) {
            if (canReach(src, words[end])) {
                graph.get(words.length).add(end);
                graph.get(end).add(words.length);
            }
        }
        
        for (int start = 0; start < words.length; ++start) {
            for (int end = start; end < words.length; ++end) {
                if (canReach(words[start], words[end])) {
                    graph.get(start).add(end);
                    graph.get(end).add(start);
                }
            }
        }
        
        return graph;
    }
    
    boolean canReach(String a, String b) {
        int diffCount = 0;
        
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) diffCount++;
            if (diffCount > 1) return false;
        }
        
        return true;
    }
}

/*
1. 그래프로 변환한다.
   - List<Integer>[]
   - (0, 0)부터 (n, n)까지, first >= second
   - 두 단어가 한 글자만 차이나는지 확인
2. 최단 거리 알고리즘
*/