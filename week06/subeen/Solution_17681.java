
import java.util.Arrays;

class Solution_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            s = String.format("%" + n + "s", s).replace(" ", "0");
            s = s.replace("1", "#");
            s = s.replace("0", " ");
            
            answer[i] = s;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution_17681 s = new Solution_17681();
        System.out.println(Arrays.toString(s.solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(s.solution(6, new int[] {46, 33, 33 ,22, 31, 50}, new int[] {27 ,56, 19, 14, 14, 10})));
    }
}