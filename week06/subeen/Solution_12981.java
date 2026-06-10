import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> used = new HashSet<>();
        
        used.add(words[0]);
        String prev = words[0].substring(words[0].length() - 1);
        
        for(int i = 1; i < words.length; i++){
            if(!prev.equals(words[i].substring(0, 1)) || used.contains(words[i])){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            } 
            
            used.add(words[i]);
                
            prev = words[i].substring(words[i].length() - 1);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution_12981 s = new Solution_12981();
        System.out.println(Arrays.toString(s.solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(s.solution(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(s.solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}