class Solution_12951 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean isFirst = true; 
        
        for(char c : s.toCharArray()){
            sb.append(isFirst ? Character.toUpperCase(c) : Character.toLowerCase(c));
            isFirst = (c ==' ');
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_12951 s = new Solution_12951();
        System.out.println(s.solution("3people unFollowed me"));
        System.out.println(s.solution("for the last week"));
    }
}

