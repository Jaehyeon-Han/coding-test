import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                stack.push('(');
            } else {
                if(stack.isEmpty()) return false;
                
                Character popped = stack.pop();
                if(popped != '(') return false;
            }
        }

        return stack.isEmpty();
    }
}