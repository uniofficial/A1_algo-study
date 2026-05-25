import java.util.Arrays;

public class Solution_42747 {
    public int solution(int[] citations) {   
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for(int i = 0; i < n; i++){
            int p = n - i; 
            
            if(p <= citations[i])
                return p;
        }
        
        return 0;
    }

    public static void main(String[] args){
        Solution_42747 s = new Solution_42747();
        System.out.println(s.solution(new int[] {3, 0, 6, 1, 5}));
    }
}
