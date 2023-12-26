package Glad.Silver.사람의_수;

import java.util.Arrays;
import java.util.Scanner;

public class 사람의_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] avers = new int[N];
        for (int i = 0; i < N; i++) {
            String avr = sc.next();
            String[] split = avr.split("\\.");
            StringBuilder sb = new StringBuilder();
            sb.append(split[0]).append(split[1]);
            avers[i] =Integer.parseInt((sb.toString()));
        }
        int answer = 1000;
        for (int i = 1; i <= 1000; i++) {
            if (findPeople(i, avers)){
                answer = Math.min(i, answer);
            }
        }
        System.out.println(answer);
    }
    public static boolean findPeople(int peopleNums, int[] avers) {
        /*
        사람이 2명일 떄
        점수는 0부터 10
        x1 + y1 은 0~20이 가능
        (x1  + y1)/ 2 = 0.5
         */

        boolean able = false;
        for (int i = 0; i < avers.length; i++) {
            able = false;
            int left = 0;
            int right = peopleNums * 10;
            while (left <= right) {
                int mid = (left + right) / 2; // 총 점수
                int midAvg = mid * 1000 / peopleNums;//평균점수의 원래 점수
                //mid는 구하고자 하는 값 avers[i]
                if (midAvg == avers[i]){
                    able = true;
                    break;
                }
                else if (midAvg > avers[i] ) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (!able) break;
        }
        return able;
    }
}
