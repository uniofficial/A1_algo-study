class Solution_43165 {
    static int answer = 0;
    int t;
    
    public int solution(int[] numbers, int target) {
        t = target;
        dfs(numbers, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int index, int sum){
        if(index == numbers.length){
            if(sum == t)
                answer++;
            return ;
        }
        
        dfs(numbers, index + 1, sum + numbers[index]);
        dfs(numbers, index + 1, sum - numbers[index]);
    }

    public static void main(String[] args){
        Solution_43165 s = new Solution_43165();
        System.out.println(s.solution(new int[] {1, 1, 1, 1, 1}, 3));

        answer = 0;
        System.out.println(s.solution(new int[] {4, 1, 2, 1}, 4));
    }
}
