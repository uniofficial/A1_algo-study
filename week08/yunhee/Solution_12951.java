package com.Algo.week08;
class Solution_12951 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        // 현재 문자가 단어의 첫 글자인지 체크 
        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 공백이면 
            if (ch == ' ') {
                answer.append(ch);
                isFirst = true; // 다음 문자는 단어의 시작
            }
            
            // 단어의 첫 문자
            else if (isFirst) {

                // 첫 문자가 알파벳이면 대문자 변환
                if (Character.isLetter(ch)) {
                    answer.append(Character.toUpperCase(ch));
                } else {
                    answer.append(ch); // 숫자는 그대로 추가
                }

                isFirst = false;
            }
            
            // 단어의 첫 문자가 아님 
            else {
                answer.append(Character.toLowerCase(ch));
            }
        }

        return answer.toString();
    }
}