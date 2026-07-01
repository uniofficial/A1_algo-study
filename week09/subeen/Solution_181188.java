import java.util.Arrays;

class Solution_181188 {
    public int solution(int[][] targets) {

        int answer = 0;
        int lastE = -1; 

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        for(int[] t : targets){
            int s = t[0];
            int e = t[1];

            if(s >= lastE){
                answer++;
                lastE = e;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_181188 s = new Solution_181188();
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(s.solution(targets));
    }
}
