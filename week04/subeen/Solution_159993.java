import java.util.ArrayDeque;
import java.util.Deque;

class Solution_159993 {
    char[][] map; 
    boolean[][] visited;
    
    int R = 0;
    int C = 0; 
    
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        
        map = new char[R][C];
        visited = new boolean[R][C];
        
        int[] info = new int[6];
            
        
        for(int i = 0; i < R; i++){
            char[] c = maps[i].toCharArray();
            
            for(int j = 0; j < C; j++){
                map[i][j] = c[j];
                
                switch (c[j]) {
                    case 'S' -> {
                        info[0] = i;
                        info[1] = j;
                    }
                    case 'L' -> {
                        info[2] = i;
                        info[3] = j;
                    }
                    case 'E' -> {
                        info[4] = i;
                        info[5] = j;
                    }
                    default -> {
                    }
                }
            }
        }
        
        // 레버까지 
        int toLever = bfs(info[0], info[1], info[2], info[3]);
        if(toLever == -1) return -1;
        
        int toExit = bfs(info[2], info[3], info[4], info[5]);
        if(toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    public int bfs(int sr, int sc, int tr, int tc){
        Deque<int[]> q = new ArrayDeque<>();
        visited = new boolean[R][C];
        
        q.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            
            if(r == tr && c == tc)
                return dist;
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(visited[nr][nc] || map[nr][nc] == 'X') continue;
                
                q.offer(new int[]{nr, nc, dist + 1});
                visited[nr][nc] = true; 
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Solution_159993 s = new Solution_159993();
        System.out.println(s.solution(new String[] {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(s.solution(new String[] {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
    }
}
