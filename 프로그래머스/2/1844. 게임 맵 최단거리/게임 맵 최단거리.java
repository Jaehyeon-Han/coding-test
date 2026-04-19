import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int distance = 0;
        
        int rows = maps.length;
        int cols = maps[0].length;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        int[][] dist = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc] == 0) continue;
                
                visited[nr][nc] = true;
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
                
                if (nr == rows - 1 && nc == cols - 1) {
                    return dist[nr][nc] + 1;
                }
            }
}
        
        return -1;
    }
    
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}