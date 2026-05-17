import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution_12978 {
    class Node implements Comparable<Node> {
        int v, w;
        
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override 
        public int compareTo(Node o){
            return Integer.compare(this.w, o.w);
        }
    }

    List<Node>[] graph;
    int[] dist;
    int limit;
    
    public int solution(int N, int[][] road, int K) {

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        limit = K;
        
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int w = r[2];
            
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }
        
        dijkstra(1);
        
        int answer = 0;
        
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K)
                answer++;
        }
        
        return answer;
    }
    
    private void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.w > dist[cur.v]) continue;
            if(dist[cur.v] > limit) continue;
            
            for(Node next : graph[cur.v]){
                int newCost = dist[cur.v] + next.w;
                
                if(newCost < dist[next.v]){
                    dist[next.v] = newCost;
                    pq.offer(new Node(next.v, newCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution_12978 s = new Solution_12978();

        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        System.out.println(s.solution(6, road, 4));
    }
}
