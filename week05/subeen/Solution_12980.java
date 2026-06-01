class Solution_12980 {
    public int solution(int n) {
        int ans = 0;

        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            }
            
            else {
                n -= 1;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution_12980 s = new Solution_12980();
        System.out.println(s.solution(5));
        System.out.println(s.solution(6));
        System.out.println(s.solution(5000));
    }
}