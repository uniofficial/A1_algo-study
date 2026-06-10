import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num1 = nums[i];
                    int num2 = nums[j];
                    int num3 = nums[k];

                    int sum = num1 + num2 + num3;

                    int sosu = 0;
                    for (int l = 1; l <= sum; l++) {
                        if (sum % l == 0) {
                            sosu++;
                        }
                    }

                    if (sosu == 2) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}