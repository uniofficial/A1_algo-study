// 둘만의 암호 

/* 문자열 s의 각 문자 이동시키는데, 
 * skip에 있는 문자는 건너뛰면서 
 * index번 이동 
 * -> skip 빼고 사용 가능한 문자만 모아놓은 문자열 available 만들고
 * (현재 위치 + index) % available.length 위치 문자 찾기 
 */

package com.Algo.week05;

class Solution_155652 {
	public String solution(String s, String skip, int index) {

        StringBuilder available = new StringBuilder(); // skip에 없는 문자들만 저장

        for (char c = 'a'; c <= 'z'; c++) {
            if (skip.indexOf(c) == -1) {
                available.append(c);
            }
        }

        StringBuilder answer = new StringBuilder();

        // s의 각 문자 변환
        for (char c : s.toCharArray()) {
            int pos = available.indexOf(String.valueOf(c)); // 현재 문자의 위치
            int newPos = (pos + index) % available.length(); // index만큼 이동
            answer.append(available.charAt(newPos));
        }
        return answer.toString();
    }
}