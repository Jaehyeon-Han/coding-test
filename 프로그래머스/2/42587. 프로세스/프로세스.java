import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Job> jobs = new ArrayDeque<>();
        Job targetJob = null;
        int count = 0;

        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            Job job = new Job(priority);
            jobs.offer(job);
            if (i == location) {
                targetJob = job;
            }
        }

        Arrays.sort(priorities); // 마지막부터 뺄수록 index 감소
        int topPriorityIndex = priorities.length - 1;
        while (!jobs.isEmpty()) {
            Job toProcess = jobs.poll();
            if (toProcess.getPriority() == priorities[topPriorityIndex]) {
                count++;
                topPriorityIndex--;

                if (toProcess == targetJob) {
                    break;
                }
                
                continue;
            }


            jobs.offer(toProcess);
        }

        return count;
    }
    
        private static class Job {
        private int priority;

        public Job(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }
    }
}