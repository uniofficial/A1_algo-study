import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        
        for (char c : skip.toCharArray()) {
            list.add(c);
        }
        
        for (char x : s.toCharArray()) {
            int temp = index;
            
            for (int i = 0; i < temp; i++) {
                x++;
                if (x > 'z') {
                    x = 'a';
                }

                while (list.contains(x)) {
                    x++;
                    if (x > 'z') {
                        x = 'a';
                    }
                }
            }
            answer += x;
        }
        return answer;
    }
}