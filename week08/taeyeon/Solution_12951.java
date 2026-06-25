class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        String pre = "";
        for(int i = 0 ;i <str.length; i++){
            String chs = str[i];
            if(pre.equals(" ") || (!chs.equals(" ") && i == 0)){

                chs = chs.toUpperCase();
            }else{
                chs = chs.toLowerCase();
            }
            answer+=chs;
            pre = chs;

        }

        return answer;
    }
}