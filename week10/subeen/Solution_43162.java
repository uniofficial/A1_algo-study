class Solution_43162 {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }

    public void dfs(int[][] computers, int idx){
        visited[idx] = true;

        for(int i = 0; i < computers[idx].length; i++){
            if(!visited[i] && computers[idx][i] == 1)
                dfs(computers, i);
        }
    }

    public static void main(String[] args) {
        Solution_43162 s = new Solution_43162();
        System.out.println(s.solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(s.solution(3, new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
    }
}