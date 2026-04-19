class Solution {
    public int solution(int[] numbers, int target) {
        int answer = ways(numbers, 0, target);
        return answer;
    }
    
    int ways(int[] numbers, int start, int target) {
        if (start == numbers.length - 1) {
            if (numbers[start] == target || numbers[start] == -target) return 1;
            return 0;
        }
        
        int positiveWays = ways(numbers, start + 1, target - numbers[start]);
        int negativeWays = ways(numbers, start + 1, target + numbers[start]);
        
        return positiveWays + negativeWays;
    }
}