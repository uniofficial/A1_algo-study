package com.AlgoStudy.A1;
/*
 * bitmask
 * skip 에 포함된 알파뱃의 비트마스크를 1로 킨다
 * 
 * */
public class Solution_155652 {
	public String solution(String s, String skip, int index) {
		int skipMask = 0;
		//skip 에 포함된 알파뱃의 비트마스크를 1로 킨다
		for (int i = 0; i < skip.length(); i++) {
			skipMask |= (1 << (skip.charAt(i) - 'a'));
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			int current = s.charAt(i) - 'a';
            int steps = 0;
            
            while (steps<index) {
            	//index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
            	current = (current + 1) % 26;
            	
            	if ((skipMask & (1 << current)) != 0) {
					//켜져있으면 넘어간다
            		continue;
				}
            	steps++;
            	
			}
            sb.append((char)(current + 'a'));
		}
		return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_155652 sol = new Solution_155652();
        
        String result = sol.solution("aukks", "wbqd", 5);
        System.out.println(result); 

	}

}
