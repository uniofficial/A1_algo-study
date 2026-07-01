
import java.util.Arrays;

class Solution_131129 {
    public int[] solution(int target) {
        
        int[] dart = new int[target + 1];
        int[] single = new int[target + 1];

        Arrays.fill(dart, Integer.MAX_VALUE);
        dart[0] = 0;

        int[][] scores = new int[61][2];
        int idx = 0;

        // 싱글  
        for(int i = 1; i <= 20; i++){
            scores[idx++] = new int[]{i, 1};
        }

        // 더블 
        for(int i = 1; i <= 20; i++){
            scores[idx++] = new int[]{i * 2, 0};
        }

        // 트리플 
        for(int i = 1; i <= 20; i++){
            scores[idx++] = new int[]{i * 3, 0};
        }

        // 불 
        scores[idx++] = new int[]{50, 1};

        // i : 지금 만들 점수 
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < idx; j++){

                // score : 이번에 쏘는 점수 
                int score = scores[j][0];
                int isSingle = scores[j][1];

                if(score > i) continue;

                int prev = i - score;

                int curDart = dart[prev] + 1;
                int curSingle = single[prev] + isSingle;

                if(curDart < dart[i]){
                    dart[i] = curDart;
                    single[i] = curSingle;

                } else if(curDart == dart[i]){
                    single[i] = Math.max(single[i], curSingle);
                }
            }
        }

        return new int[] {dart[target], single[target]};
    }

    public static void main(String[] args) {
        Solution_131129 s = new Solution_131129();
        System.out.println(Arrays.toString(s.solution(21)));
        System.out.println(Arrays.toString(s.solution(58)));
    }
}
