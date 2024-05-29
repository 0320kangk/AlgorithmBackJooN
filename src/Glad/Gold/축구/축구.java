package Glad.Gold.축구;

import java.util.Scanner;

import static java.lang.Math.pow;

public class 축구 {
    static int[] range = {0,1,4,6,8,9,10,12,14,15,16,18};
    static int N = 19;
    static int[] C = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A = sc.nextDouble()/ 100;
        double B = sc.nextDouble() / 100;
        //4c1 = 4, 4c2= 6, 4c3 = 4
        initCn();
        double sA = 0;
        double sB = 0;
        //A와 B 둘다 못 맞출 때 구하기
        for (int i : range) {
            sA += C[i] * pow(A, i) * pow(1-A, 18-i);
            sB += C[i] * pow(B, i) * pow(1-B, 18-i);
        }
        System.out.println(1-(sA*sB));
    }
    public static void initCn() {
        int n= N;
        C[0]=C[1]=1;
        for(int i=2; i < n; ++i) {
            C[0]=C[i]=1;
            for(int j=i-1; j > 0; j--) C[j] = C[j] + C[j-1];
        }
    }
}
