import java.util.Stack;

class Solution_131704 {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> sub = new Stack<>();
        int n = order.length + 1;
        int idx = 0;
        
        for(int i = 1; i < n; i++){
            if(order[idx] == i){
                answer++;
                idx++;
                
                while(!sub.isEmpty() && sub.peek() == order[idx]){
                    sub.pop();
                    answer++;
                    idx++;
                }
            } 

            else 
                sub.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution_131704 s = new Solution_131704();
        System.out.println(s.solution(new int[] {4, 3, 1, 2, 5}));
        System.out.println(s.solution(new int[] {5, 4, 3, 2, 1}));
    }
}