class Solution_250135 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long start = count(h1, m1, s1);
        long end = count(h2, m2, s2);
        
        long startTotal = h1 * 3600L + m1 * 60L + s1;
        
        int totalAlarm = (int) (end - start);
        
        if((startTotal * 59 % 3600 == 0) || (startTotal * 719 % 43200 == 0))
            totalAlarm++;
        
        return totalAlarm;
    }
    
    public long count(int h, int m, int s){
        long total = h * 3600L + m * 60L + s;
        
        long secMin = total * 59 / 3600;
        long secHour = total * 719 / 43200;
        
        long dup = total / 43200;
        
        return secMin + secHour - dup;
    }

    public static void main(String[] args) {
        Solution_250135 s = new Solution_250135();
        System.out.println(s.solution(0,5,30,0,7,0));
        System.out.println(s.solution(0,6,1,0,6,6));
        System.out.println(s.solution(1,5,5,1,5,6));
        System.out.println(s.solution(0,0,0,23,59,59));
    }
}