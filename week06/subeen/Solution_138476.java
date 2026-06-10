import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int t : tangerine){
            hm.put(t, hm.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(hm.values());
        list.sort(Collections.reverseOrder());  
        
        for(int l : list) {
            k -= l;
            answer++;
            
            if(k <= 0) break;
            
        }
        return answer;
    }

    public static void main(String[] args){
        Solution_138476 s = new Solution_138476();
        System.out.println(s.solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(s.solution(4, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(s.solution(2, new int[] {1, 1, 1, 1, 2, 2, 2, 3}));
    }
}