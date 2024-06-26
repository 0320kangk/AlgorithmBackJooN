package Glad.Gold.새_엘범;

import java.util.Scanner;

public class 새_엘범 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt(); // 개수
        long L = sc.nextInt(); // 길이
        int C = sc.nextInt(); // 용량

        int count =1;
        for (int i = 1; i  <= N; i++) {
            long an =  L + (1 + L) * (i-1);
            if(an <= C) count = i;
        }
        long answer = 0;
        if ( count >= N ){
            if ( N % 13 == 0) answer = 2;
            else answer = 1;
        }
        else {
            if (count % 13 == 0) count--;
            answer = N / count;
            if(N % count != 0) answer ++;
            //다른 cd에서 노래를 빼와도 13의 배수인 경우
            if(count % 13 == 1 &&
                    (N % count) % 13 == 0 &&
                    count - (N % count) <= 1 &&
                    count != 1
                ) answer++;
        }
        /*
        N% count = 나머지 노래 개수
        count는 한 cd 용량에 들어 갈 수 있는 노래 개수
        한마디로 count는 노래 단위
         */
        System.out.println(answer);
    }
}
