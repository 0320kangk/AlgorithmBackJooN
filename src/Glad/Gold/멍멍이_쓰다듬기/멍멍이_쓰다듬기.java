package Glad.Gold.멍멍이_쓰다듬기;

import java.util.Scanner;

public class 멍멍이_쓰다듬기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        // X -> Y로 가야함
        int  i = 1;
        int minDist;
        while (X != Y) {
            minDist = (1 + i) * i / 2;
            if( X + minDist + i + 1 <= Y){
                X
            }
            X+= i;
        }
    }
}
