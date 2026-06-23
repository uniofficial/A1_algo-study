import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] list = s.split("}");
        int[] answer = new int[list.length];
        boolean[] arr = new boolean[1000001];
         Arrays.sort(list, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
        int idx = 0;
        for(String num:list){
            String n = "";
            int k = 0;
            for(int i=0;i<num.length();i++){
                char ch = num.charAt(i);
                if('0'<=ch&&ch<='9'){
                    n+=ch;
                }else{
                    if(n.length()<=0)continue;
                    int in = Integer.parseInt(n);
                    if(!arr[in]){
                        arr[in] = true;
                        answer[idx] = in;
                    }
                    n="";
                }
            }
            if(n.length()>0){
                int in = Integer.parseInt(n);
                    if(!arr[in]){
                        arr[in] = true;
                        answer[idx] = in;
                    }
            }
            idx++;
        }

        return answer;
    }
}