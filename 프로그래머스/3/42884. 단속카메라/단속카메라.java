import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 진출 지점 기준 오름차순 정렬
        Arrays.sort(routes, (a, b) -> (a[1] - b[1]));
        
        int greedyEnd = -30001;
        for (int i = 0; i < routes.length; ++i) {
            int start = routes[i][0], end = routes[i][1];
            
            if (start <= greedyEnd) continue;
            
            greedyEnd = end;
            answer++;
        }
        
        return answer;
    }
}

/*
1 -----------
2       -----------------
3   ------------
4       --------------------
5               ------

- 가장 먼저 나가는 차의 끝지점에 카메라를 설치한다. → 끝시간으로 정렬
- 겹치는 구간이 있는 차들은 모두 제외한다. → 다음 확인할 때 시작지점이 현재 마지막보다 적은지만 보면 된다.
- 반복

*/