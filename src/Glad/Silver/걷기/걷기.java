package Glad.Silver.걷기;

import java.util.Scanner;

public class 걷기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextInt();
        long Y = sc.nextInt();
        long W = sc.nextInt();
        long S = sc.nextInt();

        //직진
        long straight = X*W + Y*W;
        //대각선 이동
        //두 좌표의합이 짝수인 경우
        long across = 0;
        if( (X + Y) % 2 == 0){
            across = S * Math.max(X, Y);
        }else {
            across = S * (Math.max(X, Y) -1) +  W;
        }
        //대각선으로 이동후 나머지 거리 평행이동
        long mix = S * Math.min(X, Y) + Math.abs(X-Y) * W;

        long answer = Math.min(Math.min(straight, across), mix);
        System.out.println(answer);
    }

}
