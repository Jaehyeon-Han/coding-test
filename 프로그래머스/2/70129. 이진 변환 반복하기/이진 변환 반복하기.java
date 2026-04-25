import java.util.*;

class Solution {
    public int[] solution(String s) {
        int removedZeroCount = 0, steps = 0;
        
        while (!s.equals("1")) {
            Result result = convert(s);
            removedZeroCount += result.removedZeros;
            s = result.converted;
            steps++;
        }
        
        int[] answer = {steps, removedZeroCount};
        return answer;
    }
    
    Result convert(String s) {
        int oneCount = countOnes(s);
        String binary = toBinary(oneCount);
        
        return new Result(s.length() - oneCount, binary);
    }
    
    String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        
        return sb.reverse().toString();
    }
    
    int countOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }
    
    static class Result {
        int removedZeros;
        String converted;
        
        Result (int a, String b) {
            this.removedZeros = a;
            this.converted = b;
        }
    }
}