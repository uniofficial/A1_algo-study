package com.AlgoStudy.A1;

import java.util.Iterator;

/*
 * 지도1 or 지도2 
 * 10진수 -> 2진수
 * 벽부분# 1
 * */
public class Solution_17681 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            int val1 = arr1[i];
            int val2 = arr2[i];
            
            String binary = Integer.toBinaryString(val2|val1);
            
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
            	if (binary.charAt(j) == '1') {
            		row.append('#');
            	}else {
            		row.append(' ');
				}
            
        }
            answer[i] = row.toString();
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_17681 sol = new Solution_17681();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        
        String[] result = sol.solution(n, arr1, arr2);
        
        // 결과 출력해보기
        for (String s : result) {
            System.out.println("\"" + s + "\"");
        }

	}

}
