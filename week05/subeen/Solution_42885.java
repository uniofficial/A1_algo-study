import java.util.Arrays;

class Solution_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            if(people[left] + people[right] <= limit)
                left++;
            
            right--;
            answer++;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution_42885 s = new Solution_42885();
        System.out.println(s.solution(new int[] {70, 50, 80, 50}, 100));
        System.out.println(s.solution(new int[] {70, 80, 50}, 100));
    }
}