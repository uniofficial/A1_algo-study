import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] a = new int[n + 1];
        Arrays.fill(a, 1);

        for (int i = 0; i < lost.length; i++) {
            a[lost[i]]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            a[reserve[i]]++;
        }

        for (int i = 0; i <= n; i++) {
            if (a[i] == 0) {
                if (i > 1 && a[i - 1] == 2) {
                    a[i]++;
                    a[i - 1]--;
                } else if (i < n && a[i + 1] == 2) {
                    a[i]++;
                    a[i + 1]--;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <=n; i++) {
            if (a[i] > 0) {
                answer++;
            }
        }
        return answer;
    }
}