class Solution_12977 {
    int answer;
    
    public int solution(int[] nums) {
        answer = 0;
        dfs(nums, 0, 0, 0);
        return answer;
    }
    
    public void dfs(int[] nums, int start, int depth, int sum){
        if(depth == 3){
            if(isPrime(sum))
                answer++;
            return ;
        }
        
        for(int i = start; i < nums.length; i++){
            dfs(nums, i + 1, depth + 1, sum + nums[i]);
        }
    }
    
    public boolean isPrime(int n){
        if(n < 2) return false; 
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_12977 s = new Solution_12977();
        System.out.println(s.solution(new int[] {1,2,3,4}));
        System.out.println(s.solution(new int[] {1,2,7,6,4}));
    }
}