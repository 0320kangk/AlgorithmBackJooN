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
        FF ->  FS -> SS -> SF (순환이 될 때)

        SS -> SF (순환이 안될 때)

        FF -> FS (순환이 안될 때)

        1. FF 가 0보다 크고 FS=0 이면
        답은 FF

        2. FF FS == 0 일 때
        SS + Math.min(SS,SF);

        3. 그 외?



         */
        int min = Math.min(FF, Math.min(FS, Math.min(SS, SF)));
        // FF ->  FS -> SS -> SF (순환이 될 때)

    }
}
