import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] str = new String[numbers.length];
        int index=0;
        for(int n : numbers){
            str[index++] = n+""; 
        }
        Arrays.sort(str, (a,b)->(b+a).compareTo(a+b));
        for(String s : str){
            answer.append(s);
        }
        if(answer.charAt(0) == '0'){
            return "0";
        }
        return answer.toString();
    }


}
