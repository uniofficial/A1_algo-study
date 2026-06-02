import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        int[] weights = new int[241];

        for (int w : people) {
            weights[w]++;
        }

        for (int i = 240; i >= 1; i--) {
            while (weights[i] > 0) {
                weights[i]--;

                int startJ = Math.min(240, limit - i);
                for (int j = startJ; j >= 1; j--) {
                    if (weights[j] > 0) {
                        weights[j]--;
                        break;
                    }
                }
                count++;
            }
        }

        return count;
    }
}