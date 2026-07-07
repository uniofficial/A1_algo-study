import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set = new HashSet<>();

        char[] spt= skill.toCharArray();
        for(char c: spt) 
            set.add(c);
        for(String sk : skill_trees){
            StringBuilder sb = new StringBuilder();
            for(char s: sk.toCharArray()){
                if(set.contains(s)){
                    sb.append(s);                    
                }
            }
            String word= sb.toString();
            if(word.equals(skill.substring(0,word.length()))){
                answer++;
            }
        }
        return answer;
    }
}
