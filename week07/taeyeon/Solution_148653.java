class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey != 0) {
            int curr = storey % 10;
            int interval = 10 - curr;
            if (curr == 5) {
                int next = (storey / 10) % 10;
                if (next >= 5) {
                    storey += interval;
                    answer += interval;
                } else {
                    answer += curr;
                }
            }
            else if (curr > 5) {
                storey += interval;
                answer += interval;
            } else {
                answer += curr;
            }
            storey /= 10;
        }
        return answer;
    }

}