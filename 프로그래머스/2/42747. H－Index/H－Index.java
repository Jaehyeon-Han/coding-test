import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--, h++) {
            int goeCount = citations.length - i;

            if(h > goeCount || h >= citations[i]) {
                break;
            }
        }

        return h;
    }
}