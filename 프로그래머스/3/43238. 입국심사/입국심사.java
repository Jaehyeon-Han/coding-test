class Solution {
    public long solution(int n, int[] times) {
        long left = 0, right = (long) n * 10_0000_0000;
        
        while (left < right) {
            long middle = (left + right) / 2;
            if (canComplete(middle, n, times)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        
        return left;
    }
    
    boolean canComplete(long time, int n, int[] times) {
        long completed = 0;
        for (int i = 0; i < times.length; ++i) {
            completed += time / times[i];
        }
        
        return completed >= n;
    }
}

/*
1 (7분)  |
2 (1분)  | 
3 (10분) |    ← o-o-o-o-o-o-o-o-o...
4 (3분)  |

어느 시점까지는 그냥 비어있는 곳에 가는 게 가장 처리량이 높다.
마지막에만 기다렸다가 받는 거다.

특정 시점 t에서 각 심사관이 처리할 수 있는 최대 인원 수는 (t / 소요 시간) 이다.
0을 시작점, (인원 수/최소 처리 시간 + 1) 을 끝점으로 두고 이분탐색한다.

■ Parametric Search가 잘 동작하는 상황?


*/