import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int sum = 0;
        
        Queue<Job> q = new PriorityQueue<Job>((a, b) -> {
            if (a.cost != b.cost) return a.cost - b.cost;
            
            if (a.requestedAt != b.requestedAt) return a.requestedAt - b.requestedAt;
            
            return a.number - b.number;
        });
        
        // 다음 추가할 Job을 구하기 위해 요청시각 순으로 정렬
        List<Job> jobList = new ArrayList<>();
        for (int i = 0; i < jobs.length; ++i) {
            jobList.add(new Job(jobs[i][1], jobs[i][0], i));    
        }
        jobList.sort((a, b) -> (a.requestedAt - b.requestedAt));
        
        // 초기 요청 추가
        int minRequestTime = jobList.get(0).requestedAt;
        int firstToAddIndex = 0;
        for (int i = 0; i < jobList.size(); ++i, firstToAddIndex++) {
            Job job = jobList.get(i);
            if (job.requestedAt > minRequestTime) break;
            
            q.add(job);
        }
        
        int time = minRequestTime;
        while(!q.isEmpty()) {
            Job cur = q.poll();
            
            // System.out.println("no." + cur.number + " takes " + cur.cost + " and requested at " + cur.requestedAt);
            
            int delay = (time + cur.cost) - cur.requestedAt;
            sum += delay;
            time += cur.cost;
            
            // 요청이 끝나기 전에 제출되는 경우: requestedAt <= time
            for (int i = firstToAddIndex; i < jobList.size(); ++i) {
                Job nextJob = jobList.get(i);
                if (nextJob.requestedAt <= time) {
                    q.add(nextJob);
                    firstToAddIndex++;
                }
            }
            
            // 다음 작업까지 대기가 있는 경우
            if (q.isEmpty() && firstToAddIndex < jobList.size()) {
                time = jobList.get(firstToAddIndex).requestedAt;
                for (int i = firstToAddIndex; i < jobList.size(); ++i) {
                    Job nextJob = jobList.get(i);
                    if (nextJob.requestedAt == time) {
                        q.add(nextJob);
                        firstToAddIndex++;
                    }
                }
            }
        }
        
        return sum / jobList.size();
    }
    
    static class Job {
        int cost, requestedAt, number;
        
        Job (int cost, int requestedAt, int number) {
            this.cost = cost;
            this.requestedAt = requestedAt;
            this.number = number;
        }
    }
}