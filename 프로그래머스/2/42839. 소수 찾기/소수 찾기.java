import java.util.*;

class Solution {
    static Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] used = new boolean[numbers.length()];
        int[] digits = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); ++i) {
            digits[i] = Integer.parseInt(numbers, i, i + 1, 10);
        }
        
        prime(digits, "0", 0, used);
        
        return primes.size();
    }
    
    void prime(int[] digits, String current, int depth, boolean[] used) {
        if (depth == digits.length) {
            int number = Integer.parseInt(current);
            if (isPrime(number))
                primes.add(number);
        }
        
        for (int i = 0; i < digits.length; ++i) {
            if (!used[i]) {
                used[i] = true;
                
                prime(digits, current, depth + 1, used);
                prime(digits, current + digits[i], depth + 1, used);
                
                used[i] = false;
            }
        }
    }
    
    boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) return false;
        } 
        
        return true;
    }
}

/*

*/