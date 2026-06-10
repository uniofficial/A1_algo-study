import java.util.LinkedList;
import java.util.Queue;

class Solution_1844 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if(x == n - 1 && y == m -1) 
                return dist;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                    
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            
                if(maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny, dist + 1});
            }
        }
        
        return -1;
    }

    public static void main(String[] args){
        Solution_1844 s = new Solution_1844();
        int[][] map1 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(s.solution(map1));

        int[][] map2 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
        System.out.println(s.solution(map2));
    }
    
}