import java.util.*;

class Node {
    int a, b, cnt;

    public Node(int a, int b, int cnt) {
        this.a = a;
        this.b = b;
        this.cnt = cnt;
    }
}

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] visited;

    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] lever = new int[2];

        arr = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            String s = maps[i];
            for (int j = 0; j < maps[i].length(); j++) {
                arr[i][j] = s.charAt(j);

                if (arr[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if (arr[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        visited = new boolean[maps.length][maps[0].length()];
        int count = bfs(start[0], start[1], 'L');
        if (count == -1) return -1;

        visited = new boolean[maps.length][maps[0].length()];
        int count1 = bfs(lever[0], lever[1], 'E');
        if (count1 == -1) return -1;

        answer = count + count1;
        return answer;
    }

    public static int bfs(int x, int y, char t) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (arr[node.a][node.b] == t) {
                return node.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.a + dx[i];
                int ny = node.b + dy[i];

                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                    if (arr[nx][ny] != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, node.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }
}