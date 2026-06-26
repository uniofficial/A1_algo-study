import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_131130_2 {
    boolean[] visited; 
    
    public int solution(int[] cards) {
        int size = cards.length; 
        visited = new boolean[size];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            if (visited[i]) continue;
            
            int count = 0;
            int cur = i; 
            
            while(!visited[cur]){
                visited[cur] = true;
                
                cur = cards[cur] - 1;
                count++;
            }
            
            list.add(count);
        }
        if(list.size() < 2) return 0;
        
        list.sort(Collections.reverseOrder());
        
        return list.get(0) * list.get(1);
    }

    public static void main(String[] args) {
        Solution_131130 s = new Solution_131130();
        System.out.println(s.solution(new int[] {8,6,3,7,2,5,1,4}));
    }
}

