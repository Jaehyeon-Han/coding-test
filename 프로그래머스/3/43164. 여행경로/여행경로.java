import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        boolean[] used = new boolean[tickets.length];

        List<String> answer = dfs("ICN", used, 0, tickets, new ArrayList<String>());
        
        return answer.stream().toArray(String[]::new);
    }
    
    // 모두 사용했으면 경로를, 아니라면 빈 List를 반환
    List<String> dfs(String cur, boolean[] used, int usedCount, String[][] tickets, List<String> path) {
        if (usedCount == tickets.length) {
            path.add(cur);
            return path;
        }
        
        for (int i = 0; i < tickets.length; ++i) {
            if (!tickets[i][0].equals(cur) || used[i]) continue;
            
            // 현재 사용할 수 있는 티켓
            used[i] = true;
            
            path.add(tickets[i][0]);
            List<String> result = dfs(tickets[i][1], used, usedCount + 1, tickets, path);
            
            if (!result.isEmpty()) return result;
            
            path.remove(path.size() - 1);
            used[i] = false;
        }
        
        return List.of();
    }
}