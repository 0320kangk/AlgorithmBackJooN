package Glad.Gold.락스타_락동호;

import java.util.Scanner;

public class 락스타_락동호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int FF = sc.nextInt();
        int FS = sc.nextInt();
        int SF = sc.nextInt();
        int SS = sc.nextInt();
        int count = 0;
        /*
        1. FF 가 0보다 크고 FS=0 이면
        답은 FF

        2. FF FS == 0 일 때
        SS + (1 OR 0)
        SS SS SS SS SS SF

        3. 그 외
        3-1 FF -> FS -> SS -> SF 를 통한 순환
        3-2 FS SF 반복 순환
        3-3 SS 순환
         */
        if(FF > 0 && FS == 0) count = FF;
        else if( FF == 0 &&  FS == 0) count = SS + Math.min(SF, 1);
        else if (FS > SF) count = FF + SF * 2 + SS + 1;
        else count = FF + FS * 2  + SS;
        System.out.println(count);
    }
}
