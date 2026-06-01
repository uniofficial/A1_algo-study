import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        int answer = 0;
        int idx = 0;
        
        for (int i = 0; i <= citations[n - 1]; i++) {
            while (idx < n && i > citations[idx]) {
                idx++;
            }

            if (i <= n - idx) {
                answer = i;
            } else {
                break;
            }
        }

        return answer;
    }
}