package Glad.Silver.소수;

import java.util.Scanner;

public class 소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int share = 0;
        A = A % B;
        A = A *10;
        while( N != 0) {
            share = A / B;
            A = A % B;
            A = A * 10;
            N --;
        }
        System.out.println(share);
    }
}
