import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        long[][] paths = new long[n + 1][m + 1];
        for (int i = 0; i < paths.length; i++) {
            Arrays.fill(paths[i], -2); // 아직 계산 안 한 상태
        }
        for (int i = 0; i < puddles.length; ++i) {
            int[] puddle = puddles[i];
            int row = puddle[1], col = puddle[0];
            paths[row][col] = -1; // 웅덩이
        }
        paths[1][1] = 1;
        
        return (int) (countPath(n, m, paths) % 1_000_000_007);
    }
    
    // 해당 지점까지의 경로의 개수를 구한다.
    long countPath(int row, int col, long[][] paths) {
        if (row <= 0 || col <= 0 || paths[row][col] == -1) return 0;
        
        if (paths[row][col] != -2) return paths[row][col];
        
        long count = countPath(row - 1, col, paths) + countPath(row, col - 1, paths) % 1_000_000_007;
        paths[row][col] = count;
        return count;
    }
}