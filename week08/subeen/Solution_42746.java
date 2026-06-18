import java.util.Arrays;

class Solution_42746 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            arr[i] = "" + numbers[i];

        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));

        if(arr[0].equals("0"))
            return arr[0];

        StringBuilder sb = new StringBuilder();

        for(String s : arr){
            sb.append(s);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_42746 s = new Solution_42746();
        System.out.println(s.solution(new int[] {6, 10, 2}));
        System.out.println(s.solution(new int[] {3, 30, 34, 5, 9}));
    }
}