class Solution {
    public int solution(int n, int[][] results) {
        // 패자 -> 승자로 간선
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == j) {
                    distance[i][j] = 0;
                    continue;
                }
                distance[i][j] = 9999;
            }
        }
        for (int i = 0; i < results.length; ++i) {
            int[] result = results[i];
            distance[result[1]][result[0]] = 1;
        }
        
        // floyd-warshall
        for (int k = 1; k <= n; ++k) {
            for (int start = 1; start <= n; ++start) {
                for (int end = 1; end <= n; ++end) {
                    distance[start][end] = Math.min(distance[start][end], distance[start][k] + distance[k][end]);
                }
            }
        }
        
        // 도달 가능성 판단 (distance < 1000)
        // 해당 노드에서 모든 노드를 방문할 수 있거나, 방문하지 않은 노드로부터 도달 가능해야 순위가 결정된다.
        int count = 0;
        for (int node = 1; node <= n; ++node) {
            boolean can = true;
            for (int end = 1; end <= n; ++end) {
                if (distance[node][end] == 9999 && distance[end][node] == 9999) {
                    can = false;
                    break;
                }
            }
            if (can) count++;
        }
        
        return count;
    }
}


/*
4 <- 3 <- 2 -> 1
  <- 2 <- 5

1. 순위를 결정할 수 있다.
2. 순위가 결정되는 노드의 특징을 계산할 수 있다.

*/