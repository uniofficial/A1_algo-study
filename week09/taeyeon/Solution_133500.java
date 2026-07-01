import java.util.*;

class Solution {

    public ArrayList<Integer>[] graph;
    public int result;
    public int solution(int n, int[][] lighthouse) {
        result = 0;

        graph = new ArrayList[n + 1];

        for(int i = 1; i <= n ; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < lighthouse.length; i++)
        {
            graph[lighthouse[i][0]].add(lighthouse[i][1]);
            graph[lighthouse[i][1]].add(lighthouse[i][0]);
        }

        dfs(1, 0);

        return result;
    }

    public int dfs(int cur, int prev)
    {
        int num = 0;

        if(graph[cur].size() == 1 && graph[cur].get(0) == prev)
        {
            return 1;
        }

        for(int i = 0; i < graph[cur].size(); i++)
        {
            int next = graph[cur].get(i);
            if(next == prev) continue;
            num += dfs(next, cur);
        }

        if(num == 0)
        {
            return 1;
        }

        result++;
        return 0;

    }
}