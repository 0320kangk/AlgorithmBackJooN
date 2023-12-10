package Glad.Gold.킥다운;

import java.util.Scanner;

public class 킥다운 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        String M = sc.next();
        String gear1 ;
        String gear2 ;
        if (N.length() >M.length()) {
            gear1 = M;
            gear2 = N;
        } else{
            gear1 = N;
            gear2 = M;
        }
        int min = gear1.length() + gear2.length();
        int right = 0;
        while (gear2.length() + gear1.length() - 1> right) {
            int gear1Idx = gear1.length() - 1;
            int gear2Idx = right;
            boolean flag = false;
            System.out.println(right);
            while(gear1Idx >= 0){
                if ( gear2Idx < gear2.length() &&
                        gear2Idx >= 0 &&
                        gear1.charAt(gear1Idx) == '2' &&
                        gear2.charAt(gear2Idx) == '2'){
                    flag = true;
                    break;
                }
                gear2Idx--;
                gear1Idx--;
            }
            if (!flag){
                if( right < gear1.length()){
                    min = Math.min( gear2.length() + gear1.length() - right - 1, min);
                }else if (right < gear2.length()){
                    min = Math.min(gear2.length(), min);
                }  else{
                    min = Math.min(right + 1, min);
                }
            }
            right++;


        }
        System.out.println(min);
    }
}
