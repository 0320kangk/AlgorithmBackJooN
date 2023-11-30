package Glad.Gold.줄어드는_수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 줄어드는_수 {

    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        backTracking( 0 , 9 );
        Collections.sort(list);
        list.remove(0);
        if( N-1 < list.size()  )
            System.out.println(list.get(N-1));
        else
            System.out.println(-1);
    }
    static void backTracking(long num, int front){
        list.add(num);
        if (front < 0 )return;
        for (int i = front; i >=0 ; i--) {
            backTracking(num *10 + i, i - 1);
        }
    }
}
