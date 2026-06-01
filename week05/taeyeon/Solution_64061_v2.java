import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int height = board.length;
        Stack<Integer> bagooni = new Stack<>();
        int disappeared = 0;
        for (int move : moves) {
            int bbob = move - 1;
            for (int y = 0 ; y < height ; y++){
                if (board[y][bbob] == 0) continue;
                int doll = board[y][bbob];
                board[y][bbob] = 0;
                if (bagooni.isEmpty() || bagooni.peek() != doll){
                    bagooni.push(doll);
                } else {
                    bagooni.pop();
                    disappeared += 2;
                }
                break;
            }
        }
        return disappeared;
    }
}