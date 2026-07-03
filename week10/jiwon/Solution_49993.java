package com.AlgoStudy.A1;
/*
 * skill_trees에 있는 것중에 skill 만 남겨서본다
 * 앞순서 부터 구성된 부분 집합이면 맞다
 * indexOf()==0
 * c부터 시작하는가
 * */
public class Solution_49993 {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String string : skill_trees) {
			String filtered = string.replaceAll("[^" + skill + "]", "");
			
			if (skill.indexOf(filtered)==0) {
				answer++;
			}
		}
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_49993 sol = new Solution_49993();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        
        System.out.println(sol.solution(skill, skill_trees));

	}

}
