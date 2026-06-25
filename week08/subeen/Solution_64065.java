import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_64065 {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();
        
        String[] str = s.substring(2, s.length() - 2).split("\\},\\{");
        int[] answer = new int[str.length];
        int idx = 0;

        Arrays.sort(str, (s1, s2) -> s1.length() - s2.length());

        for(String S : str){
            String[] arr = S.split(",");

            for(String a : arr){
                int x = Integer.parseInt(a);

                if(!set.contains(x)){
                    set.add(x);
                    answer[idx++] = x;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_64065 s = new Solution_64065();
        System.out.println(Arrays.toString(s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(s.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(s.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(s.solution("{{123}}")));
        System.out.println(Arrays.toString(s.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}