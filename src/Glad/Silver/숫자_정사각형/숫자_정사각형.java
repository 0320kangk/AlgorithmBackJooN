package Glad.Silver.숫자_정사각형;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자_정사각형 {
    public static void main(String[] args) {

        /*
        1. n m 값 행열 입력
        2. n m 중 작은 값이 최대 정사각형 길이
        3. 2부터 시작하여 4개의 꼭짓점을 확인
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] rec = new String[N];
        for (int i = 0; i < N; i++) {
            rec[i] = sc.next();
        }
        System.out.println(Arrays.toString(rec));
        //4개의 꼭짓점 검사
        int length = Math.min(N, M);
        //길이 반복문 2부터..
        for (int i = length - 1; i >= 1; i--) {
            //길이에 대한 검사... 시작점을 정하기...
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    //한점을 기준으로 4점 찾기
                    if ( j + i < N && k + i < M ){
                        int dot1 = rec[j].charAt(k);
                        int dot2 = rec[j + i].charAt(k);
                        int dot3 = rec[j].charAt(k + i);
                        int dot4 = rec[j + i].charAt(k + i);

                        if (dot1 == dot2 &&
                                dot1 == dot3 &&
                                dot1 == dot4){
                            System.out.println((i+1)*(i+1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(1);

    }
}
