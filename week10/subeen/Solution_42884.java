import java.util.Arrays;

class Solution_42884 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camera = Integer.MIN_VALUE;

        for(int[] route : routes){
            if(camera < route[0]){
                answer++;
                camera = route[1];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution_42884 s = new Solution_42884();
        System.out.println(s.solution(new int[][] {{-20,-15},{-14,-5},{-18,-13},{-5,-3}}));
    }
}