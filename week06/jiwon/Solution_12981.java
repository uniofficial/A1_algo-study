package com.AlgoStudy.A1;

import java.util.HashSet;

/*
 * 중복이 안되는 단어 and 앞사람이 말한 단어
 * 탈락조건: 중복 or 앞사람이 말한단어랑 다름
 * 탈락자 번호 (i % n) + 1
 * 탈락 차례 (i / n) + 1
 * 등장한 단어를 hashset에 저장
 * */
public class Solution_12981 {
	public int[] solution(int n, String[] words) {
		HashSet<String> usedWords = new HashSet<>();
		
		usedWords.add(words[0]);
		
		for (int i = 1; i < words.length; i++) {
			String prevWord = words[i-1];
			String curWord = words[i];
			
			char lastWord = prevWord.charAt(prevWord.length() - 1);
			char firstWord = curWord.charAt(0);
			
			if (lastWord!=firstWord || usedWords.contains(curWord)) {
				int person = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[]{person, turn};
			}
			usedWords.add(curWord);
		}



        return new int[]{0, 0};
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_12981 sol = new Solution_12981();
        
        // 예시 테스트
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        
        int[] result = sol.solution(n, words);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

	}

}
