// 같은 숫자는 싫어 

package com.Algo.week03;
import java.util.*;

public class Solution_12906 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        // 첫 번째 숫자는 무조건 
        list.add(arr[0]);
        
        // 이전 숫자와 비교하면서 
        for (int i = 1; i < arr.length; i++) {
            
            // 이전 숫자와 다를 때만 추가
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        
        // List -> int[] 변환
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}