import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int max = Arrays.stream(sizes).flatMapToInt(Arrays::stream).max().getAsInt();
        int anotherMax = 0;

        for (int i = 0; i < sizes.length; i++) {
            int first = sizes[i][0];
            int second = sizes[i][1];

            if (first >= second) {
                anotherMax = Math.max(anotherMax, second);
            } else {
                anotherMax = Math.max(anotherMax, first);
            }
        }

        return max * anotherMax;
    }
}