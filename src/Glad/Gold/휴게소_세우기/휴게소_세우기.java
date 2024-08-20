package Glad.Gold.휴게소_세우기;

import java.util.*;

public class 휴게소_세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 기존 휴게소 개수
        int M = sc.nextInt();  // 새로 지을 휴게소 개수
        int L = sc.nextInt();  // 고속도로의 길이

        Integer[] rests = new Integer[N];
        for (int i = 0; i < N; i++) {
            rests[i] = sc.nextInt();
        }
        // 휴게소 위치 정렬
        Arrays.sort(rests);
        // 고속도로의 시작과 끝을 포함하는 구간 추가
        List<Integer> gaps = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            gaps.add(rests[i] - rests[i - 1]); // 각 휴게소 사이의 거리
        }
        if (rests.length > 0){
            gaps.add(rests[0] - 0); // 고속도로 시작점과 첫 휴게소 사이의 거리
            gaps.add(L - rests[N - 1]); // 마지막 휴게소와 고속도로 끝점 사이의 거리
        } else {
            gaps.add(L);
        }


        int answer = 0;
        int left = 1; //최소 구간 길이
        int right = L; //최대 구간 길이
        while(left <= right) {
            int mid = (left + right) / 2; // 구간 길이
            int count = 0;
            for (Integer gap : gaps) {
                count += (gap - 1) / mid;
            }
            if(count > M  ){
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }

        }
        System.out.println(answer);
    }
}