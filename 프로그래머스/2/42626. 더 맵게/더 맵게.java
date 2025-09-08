import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            minHeap.offer(scoville[i]);
        }

        while(!minHeap.isEmpty()) {
            int minScoville = minHeap.poll();

            if(minScoville >= K) {
                break;
            }

            if(minHeap.isEmpty()) {
                return -1;
            }

            int secondMinScoville = minHeap.poll();
            minHeap.offer(minScoville + secondMinScoville * 2);
            count++;
        }

        return count;
    }
}