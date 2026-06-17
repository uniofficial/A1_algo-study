class Solution_140107 {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(long a = 0; a * k <= d; a++){
            long x = a * k;
            long maxB = (long) Math.sqrt((long)d * d - x * x) / k;
            answer += maxB + 1;
        }
        
        return answer;
    }

    public static void main(String[] args){
        Solution_140107 s = new Solution_140107();
        System.out.println(s.solution(2, 4));
        System.out.println(s.solution(1, 5));
    }
}