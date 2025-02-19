package Glad.Gold.멍멍이_쓰다듬기;

import java.util.Scanner;

public class 멍멍이_쓰다듬기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        long Y = sc.nextLong();
        // X -> Y로 가야함
        long  keyAmount = 0; //현재 성장 가능한 키 중심
        int count = 0;
        while (X != Y) {
            count++;
            long minDist = 0;
            if (keyAmount !=0 ) minDist = (keyAmount + 1 ) * (keyAmount) / 2; //돌아갈 수 있는지 확인
            //다음 칸 증가시 내려 올 수 있는지 확인
            if( X + minDist + keyAmount + 1  <= Y){
                X+= keyAmount + 1;
                keyAmount++;
            } else if( X + minDist <= Y ){
                X+=keyAmount;
            } else{
                keyAmount--;
                X += keyAmount;
            }
        }
        System.out.println(count);
    }
}
