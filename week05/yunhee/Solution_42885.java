// 구명보트 

/* 보트 한 번에 최대 2명, 무게 제한 limit 
 * 가장 무거운 사람은 혼자 타거나 가장 가벼운 사람과 타야 함 
 */

package com.Algo.week05;

import java.util.Arrays;

class Solution_42885 {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boat = 0;

        while (left <= right) {

            // 가장 가벼운 사람이 가장 무거운 사람이 함께 탈 수 있으면 
            if (people[left] + people[right] <= limit) {
                left++;
            }

            // 가장 무거운 사람은 항상 태움 
            right--;
            boat++;
        }

        return boat;
    }
}