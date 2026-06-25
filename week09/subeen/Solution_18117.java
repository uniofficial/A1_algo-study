class Solution_18117 {
    public long solution(int r1, int r2) {
        long answer = 0;

        for(int x = 1; x <= r2; x++){
            long y2 = (long) Math.sqrt((long)r2 * r2 - (long)x * x);
            long y1 = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));
            
            answer += y2 - y1 + 1;
        }
        return answer * 4;
    }

    public static void main(String[] args) {
        Solution_18117 s = new Solution_18117();
        System.out.println(s.solution(2, 3));
    }
}
