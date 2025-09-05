import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> typeSet = new HashSet<>();

        for (int num : nums) {
            typeSet.add(num);
        }

        return Integer.min(nums.length / 2, typeSet.size());
    }
}