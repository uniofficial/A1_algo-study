// 크레인 인형뽑기 게임 

package com.Algo.week05;

import java.util.*;

class Solution_64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board[0].length;
         Stack<Integer> st = new Stack<>();
         
        for(int mv:moves){
            mv -=1;
            for(int i=0; i<len; i++){  
                if(board[i][mv] != 0){     
                    if(st.size() > 0  && st.peek() == board[i][mv] ){  // 현재 인형과 마지막 인형이 같다면
                        st.pop();
                        answer += 2;
                    }else{
                         st.push(board[i][mv]); // 인형 넣기 
                    }
                    board[i][mv] = 0; 
                    break; 
                }
            }  
        } 
        return answer;
    }
}