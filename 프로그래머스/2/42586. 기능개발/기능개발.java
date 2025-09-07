import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int currentJobIndex = 0;
        while(currentJobIndex < progresses.length) {
            for (int i = currentJobIndex; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            int completedJobCount = 0;
            for (int i = currentJobIndex; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    break;
                }

                completedJobCount++;
                currentJobIndex++;
            }
            
            if(completedJobCount != 0) {
                answer.add(completedJobCount);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}