import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        answer += 2*(r2 - r1 + 1);

        long sr1 = (long)r1*r1;
        long sr2 = (long)r2*r2;

        for(int i=1;i<r1;i++){
            long si = (long)i*i;
            int cnt1 = (int) Math.sqrt(sr2 - si);
            int cnt2 = (int) Math.sqrt(sr1 - si);
            answer += 4*(cnt1 - cnt2);
            if(sr1 - si == (long)cnt2*cnt2) answer += 4;
        }

        for(int i=r1;i<r2;i++){
            long si = (long)i*i;
            int cnt = (int)Math.sqrt(sr2 - si) + 1;
            answer += 4*cnt - 2;
        }

        answer += 2;

        return answer;
    }
}
 
