import java.util.ArrayList;

class Solution_155652 {
    public String solution(String s, String skip, int index) {

        StringBuilder sb = new StringBuilder();
        
        ArrayList<Character> array = new ArrayList<>();
        
        for(int i = 0; i < 26; i++){
            char c = (char)('a' + i);
            if(skip.contains(String.valueOf(c)))
                continue;
            array.add(c);
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int idx = array.indexOf(c) + index;     
            
            idx %= array.size();
            
            sb.append(array.get(idx));
        }
        
        return sb.toString();
    }

    public static void main(String[] args){
        Solution_155652 s = new Solution_155652();
        System.out.println(s.solution("aukks", "wbqd", 5));
    }
}

