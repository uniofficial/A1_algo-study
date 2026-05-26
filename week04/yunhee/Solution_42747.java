// H-Index

// h번 이상 인용된 논문이 h편 이상
// 내림차순 정렬 후 현재 인덱스에서 남아있는 논문 수 >= 현재 인용 수

package com.Algo.week04;

import java.util.Arrays;
import java.util.Collections;

class Solution_42747 {
    public int solution(int[] citations) {

        // Collections.reverseOrder() 사용하려면 Integer 타입 필요 (구글링)
        Integer[] arr = Arrays.stream(citations)
                              .boxed()
                              .toArray(Integer[]::new);

        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        int hIndex = 0;

        // 논문 순회
        for (int i = 0; i < arr.length; i++) {
        	// i+1은 현재까지의 논문 개수
        	// arr[i]는 현재 논문의 인용 횟수
        	// arr[i]>=i+1이면 i+1편 이상의 논문이 i+1번 이상 인용된 것 
            if (arr[i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }
}