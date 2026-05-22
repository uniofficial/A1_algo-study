package com.AlgoStudy.A1;
/*
 * greedy
 * if(이전<현재)
 * max=현재
 * 
 *가장 앞의 숫자가 가장 클때까지 k개에서 뺀다
 *뒤에 숫자가 앞에 숫자보다 크면 앞에거 제거 -> Stack-> StringBuilder
 * */
public class Solution_42883 {
	 public String solution(String number, int k) {
		 StringBuilder sb = new StringBuilder();
		 
		 for (int i = 0; i < number.length(); i++) {
			 char current = number.charAt(i);
			 //뒤에 숫자가 앞에 숫자보다 크면 앞에거 제거
			 while (sb.length()>0 && k > 0 && sb.charAt(sb.length() - 1) < current) {
				sb.deleteCharAt(sb.length() - 1);
				k--;
			}
			 sb.append(current);
		}
		 //처음부터 내림차순이면 뒤부터 자르기
		 return sb.substring(0, sb.length() - k);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_42883 solver = new Solution_42883();
        
        // 테스트 케이스 확인
        System.out.println(solver.solution("1924", 2));       // "94"
        System.out.println(solver.solution("1231234", 3));    // "3234"
        System.out.println(solver.solution("4177252841", 4)); // "775841"

	}

}
