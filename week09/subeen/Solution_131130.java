import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_131130 {
    boolean[] visited; 
    
    public int solution(int[] cards) {
        int answer = 0;
        int size = cards.length; 
        visited = new boolean[size];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            if(!visited[i]){
                list.add(dfs(i, cards));
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        answer = (list.size() < 2) ? 0 : list.get(0) * list.get(1);
        
        return answer;
    }
    
    private int dfs(int cur, int[] cards){
        
        if(visited[cur])
            return 0;
        
        visited[cur] = true; 
        int next = cards[cur] - 1;
        
        return 1 + dfs(next, cards);
    }

    public static void main(String[] args) {
        Solution_131130 s = new Solution_131130();
        System.out.println(s.solution(new int[] {8,6,3,7,2,5,1,4}));
    }
}