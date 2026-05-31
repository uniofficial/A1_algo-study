class Solution_42883 {
    public String solution(String number, int k) {
        int l = number.length();
        char[] ch = new char[l];
        int top = -1;    
        
        for(int i = 0; i < l; i++){
            char c = number.charAt(i);
            
            while(top >= 0 && k > 0 && ch[top] < c){
                top--;
                k--;
            }
            ch[++top] = c;
        }
        
        top -= k;
        
        return new String(ch, 0, top + 1);
    }

    public static void main(String[] args){
        Solution_42883 s = new Solution_42883();
        System.out.println(s.solution("1924", 2));
        System.out.println(s.solution("1231234", 3));
        System.out.println(s.solution("4177252841", 4));
    }
}