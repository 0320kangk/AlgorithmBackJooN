package Glad.Silver.영식이의_손가락;

import java.util.Scanner;

public class 영식이의_손가락 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int finger = sc.nextInt();
        long N = sc.nextLong();
        long answer = 0;

        if(1<=N) {
            answer +=5; // 첫 시작
            if( finger!= 1 && finger != 5) answer += (N-1) * 4; // 2, 3, 5
            else answer += (N-1) * 8; //1, 5

            if(finger==1) answer += 3;
            else if(finger == 5) answer += 7;
            else if( (N - 1) % 2 == 0 ) answer += (4-finger);
            else  answer += (finger-2);
        } else{
            answer += (finger-1);
        }

        //1 2 3 4 5 4 3 2 1 2 3 4 5 4 3 2 1 2 3 4 5 4 3 2
        System.out.println(answer);
    }
}

