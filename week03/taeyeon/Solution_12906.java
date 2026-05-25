import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int count = 0, i;

        for(i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    if(arr[i] == -1) break;
                    arr[j] = -1;
                    count++;
                }
                else 
                    i = j;
            }
        }
        System.out.println(count);

        answer = new int[arr.length - count];
        count = 0;

        for(i=0;i<arr.length;i++){
            if(arr[i] == -1) continue;
            else{ 
                answer[count] = arr[i];
                count++;
            }
        }
        return answer;
    }
}