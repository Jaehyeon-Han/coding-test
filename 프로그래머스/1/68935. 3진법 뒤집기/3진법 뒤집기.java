class Solution {
    public int solution(int n) {
        String reversedTernary = toReversedTernary(n);
        int decimal = toDecimal(reversedTernary);
        
        return decimal;
    }
    
    String toReversedTernary(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n >= 3) {
            sb.append(n % 3);
            n /= 3;
        }
        sb.append(n);
        
        return sb.toString();        
    }
    
    int toDecimal(String ternary) {
        int num = 0;
        int weight = 1;
        for (int i = ternary.length() - 1; i >= 0; --i, weight *= 3) {
            char ch = ternary.charAt(i);
            num += Integer.valueOf(ch - '0') * weight;
        }
        
        return num;
    }
}