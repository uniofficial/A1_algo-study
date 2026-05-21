import java.util.Arrays;
import java.util.HashSet;

class Solution_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int r : reserve)
            set.add(r);
        
        for(int i = 0; i < lost.length; i++){
            if(set.contains(lost[i])){
                set.remove(lost[i]);
                lost[i] = -1;
            }
        }
        
        for(int l : lost){
            if(l == -1) continue;
            
            if(set.contains(l - 1))
                set.remove(l - 1);
            
            else if(set.contains(l + 1))
                set.remove(l + 1);
            else 
                answer--;
        }
        
        return answer;
    }

    public static void main(String[] args){
        Solution_42862 s = new Solution_42862();
        System.out.println(s.solution(3, new int[] {3}, new int[]{1}));
    }
}

