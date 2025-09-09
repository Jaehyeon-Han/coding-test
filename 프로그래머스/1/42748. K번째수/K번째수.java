import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int startIndex = commands[i][0] - 1;
            int endIndex = commands[i][1] - 1;
            int targetIndex = commands[i][2] - 1;

            int[] subArray = Arrays.copyOfRange(array, startIndex, endIndex + 1);
            Arrays.sort(subArray);
            answer[i] = subArray[targetIndex];
        }

        return answer;
    }
}