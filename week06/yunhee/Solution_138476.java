// 비밀지도

package com.Algo.week06;

class Solution_13847 {

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
        	// 두 지도 or 연산. 둘 중 하나라도 벽이면 1 
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);

            // 이진수 길이가 n보다 작을 수도 있음. 앞에 0 붙여주기 
            binary = "0".repeat(n - binary.length()) + binary;

            // 1 -> '#', - -> ' '로 변환
            answer[i] = binary.replace('1', '#')
                              .replace('0', ' ');
        }

        return answer;
    }
}