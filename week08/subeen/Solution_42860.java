public class Solution_42860 {
    public int solution(String name) {
        int answer = 0;

        for(char c : name.toCharArray()){
            answer += (c <= 'N') ? c - 'A' : 'Z' - c  + 1;
        }

        int move = name.length() - 1;

        for(int i = 0 ; i < name.length(); i++){
            int next = i + 1;

            while(next < name.length() && name.charAt(next) == 'A')
                next++; 

            move = Math.min(move, (i * 2) + (name.length() - next));
            move = Math.min(move, (name.length() - next) * 2 + i);
        }

        return answer + move;
    }

    public static void main(String[] args) {
        Solution_42860 s = new Solution_42860();
        System.out.println(s.solution("JEROEN"));
        System.out.println(s.solution("JAN"));
    }
}
