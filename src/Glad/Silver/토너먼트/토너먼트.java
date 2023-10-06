package Glad.Silver.토너먼트;

import java.util.Scanner;

public class 토너먼트 {
    public static void main(String[] args) {
        /*
        참가자는
        라운드 마다 절반 줄어든다.
        16 -> 8 -> 4 ->2 , 2명 남을 때가 결승전
        (1, 2), (3,4), (5, 6), (7, 8)
        홀 짝 구분하기
        홀= 홀/2 + 1
        짝 = 짝 /2

        홀 + 1 == 짝 으로 두 번호가 만난다면 붙게 되는 것
        */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        for (int i = 1; N > 0; i++, N = N/2) {
            if((p1 % 2 == 1 && p1 + 1 == p2) ||
                    (p1 % 2 == 0 && p1 == p2 + 1))
                System.out.println(i);
            p1 = p1 % 2 == 0 ? p1 / 2 : p1 / 2 + 1;
            p2 = p2 %2 == 0 ? p2 /2 : p2 /2 + 1;
        }

    }
}
