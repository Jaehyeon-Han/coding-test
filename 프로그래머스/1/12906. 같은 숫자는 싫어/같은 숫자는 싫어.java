import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        int lastNumber = -1; // 불가능한 값
        for (int number : arr) {
            if (number == lastNumber) {
                continue;
            }

            lastNumber = number;
            answer.add(number);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}