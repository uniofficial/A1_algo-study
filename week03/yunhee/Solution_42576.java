// 완주하지 못한 선수 

package com.Algo.week03;
import java.util.HashMap;

public class Solution_42576 {
    public String solution(String[] participant, String[] completion) {
        
        // 선수 이름별 참가 횟수 저장
        HashMap<String, Integer> map = new HashMap<>();
        
        // participant에 있는 선수들 카운트
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // completion에 있는 선수들 뺌 
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        // 값이 1인 선수 -> 완주 못한 선수
        for (String name : map.keySet()) {
            if (map.get(name) > 0) {
                return name;
            }
        }
        
        return "";
    }
}