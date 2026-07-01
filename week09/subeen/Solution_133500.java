import java.util.ArrayList;

class Solution_133500 {
    boolean[] visited;
    int[][] dp;
    ArrayList<Integer>[] tree;
    
    public int solution(int n, int[][] lighthouse) {
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        tree = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int[] edge : lighthouse){
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        dfs(1);

        return Math.min(dp[1][0], dp[1][1]);

    }

    private void dfs(int cur){
        visited[cur] = true;

        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for(int child : tree[cur]){
            if(!visited[child]){
                dfs(child);

                dp[cur][0] += dp[child][1];

                dp[cur][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }

    public static void main(String[] args) {
        Solution_133500 s = new Solution_133500();
        int[][] l1 = {{1,2}, {1,3}, {1,4}, {1,5},{5,6}, {5,7}, {5, 8}};
        System.out.println(s.solution(8, l1));

        int[][] l2 = {{4,1}, {5,1}, {5,6}, {7,6}, {1,2}, {1,3}, {6,8},{2,9},{9,10}};
        System.out.println(s.solution(10, l2));
    }
}