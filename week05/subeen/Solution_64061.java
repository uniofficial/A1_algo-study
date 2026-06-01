import java.util.Stack;

class Solution_64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        
        Stack<Integer>[] cols = new Stack[size];
        Stack<Integer> sub = new Stack<>();
        
        for(int i = 0; i < size; i++){
            cols[i] = new Stack<>();
        }
        
        for(int i = size - 1; i >= 0; i--){
            int[] row = board[i];
            
            for(int j = 0; j < size; j++){
                if(board[i][j] != 0)
                    cols[j].push(row[j]);
            }
        }
        
        for(int move : moves){
            if(!cols[move - 1].isEmpty()){
                int cur = cols[move - 1].pop();
                if(!sub.isEmpty() && sub.peek() == cur){
                    sub.pop();
                    answer++;
                }
                else {
                    sub.push(cur);
                }
            }
        }
        return answer << 1;
    }

    public static void main(String[] args) {
        Solution_64061 s = new Solution_64061();
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(s.solution(board, moves));
    }
}

