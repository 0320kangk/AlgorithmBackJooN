package Glad.Silver;

import java.util.*;

//https://www.acmicpc.net/problem/1002
// https://haenny.tistory.com/389 두 객체 비교하기
public class 터렛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        for (int i = 0; i < repeat; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            System.out.println(countContact(x1, y1, r1, x2, y2, r2));
        }

    }
    static int countContact(int x1, int y1, int r1, int x2, int y2, int r2) {
        double xy = Math.pow(x2 - x1, 2) + Math.pow(y2-y1, 2);
        if (x1==x2 && y1==y2 && r1==r2){
            return -1;
        }
        else if( Math.pow(r2 + r1, 2)  < xy ){
            return 0;
        }
        else if ( Math.pow(r2 - r1, 2) > xy) {
            return 0;
        }
        else if ( Math.pow(r2 - r1, 2) ==  xy ) {
            return 1;
        }
        else if ( Math.pow(r2 + r1, 2)== xy) {
            return 1;
        } else {
            return 2;
        }
    }
}
