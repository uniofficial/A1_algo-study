package com.Algo.week10;

import java.util.Arrays;

class Solution_42884 {
    public int solution(int[][] routes) {
        // 진출 지점 기준 오름차순 정렬
        // 빨리 끝나는 차량부터 처리해야 카메라를 최대한 뒤쪽에 놔서 다른 차량들과 겹칠 확률 높아짐 
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameraCount = 0; // 설치한 카메라 개수
        int lastCameraPos = Integer.MIN_VALUE; // 마지막으로 설치한 카메라의 위치

        // 정렬된 순서대로 순회
        for (int[] route : routes) {
            int enter = route[0]; // 진입 지점
            int exit = route[1];  // 진출 지점

            // 현재 차량의 진입 지점이 마지막 카메라 위치보다 크면 새 카메라 설치 필요
            if (enter > lastCameraPos) {
                cameraCount++;
                lastCameraPos = exit; // 새 카메라는 이 차량의 진출 지점에 설치
            }
            // enter <= lastCameraPos 이면 이미 카메라를 만나는 상태이므로 아무것도 안 함
        }

        return cameraCount;
    }
}