package com.AlgoStudy.A1;
import java.util.*;
/*
 * 
 * Hashmap
 * map.getOrDefault(찾는_Key, Key가_없을_때_반환할_기본값)
 * */
public class Solution_42576 {
	
	 public String solution(String[] participant, String[] completion) {
		 String answer = "";
		 HashMap<String, Integer> map = new HashMap<>();
		 //선수등록, 동명이인이면 +1
		 for (String player : participant) {
			map.put(player, map.getOrDefault(player, 0)+1);
		}
		 //완주하면 -1
		 for (String player : completion) {
			 map.put(player, map.get(player)-1);
		}
		 
		 for (String k : map.keySet()) {
			if (map.get(k)!=0) {
				answer = k;
				break;
			}
		}
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_42576 s = new Solution_42576();

        String[] p1 = {"leo", "kiki", "eden"};
        String[] c1 = {"eden", "kiki"};

        String[] p2 = {"mislav", "stanko", "mislav", "ana"};
        String[] c2 = {"stanko", "ana", "mislav"};

        System.out.println(s.solution(p1, c1));
        System.out.println(s.solution(p2, c2));

	}

}
