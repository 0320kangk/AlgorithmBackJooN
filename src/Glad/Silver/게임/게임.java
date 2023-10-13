package Glad.Silver.게임;

import java.util.Scanner;

public class 게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextInt();
        long Y = sc.nextInt();
        long Z =( Y * 100) / X;
        if ( Z >= 99){
            System.out.println(-1);
            return;
        }
        long left =  1;
        long right = (long) 1e9; //10억
        long mid = 0; //mid 결과 값
        long addGame = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            long value = ( 100 * (Y + mid)) / (X + mid);
            if ( value >= Z + 1) {
                right = mid -1;
                addGame = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(addGame);
    }
}
