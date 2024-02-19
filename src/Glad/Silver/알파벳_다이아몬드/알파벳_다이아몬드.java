package Glad.Silver.알파벳_다이아몬드;

import java.util.Scanner;

public class 알파벳_다이아몬드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt( input[0]);
        int R1 = Integer.parseInt( input[1]);
        int C1 = Integer.parseInt( input[2]);
        int R2 = Integer.parseInt( input[3]);//행 13
        int C2 = Integer.parseInt( input[4]);//열 46
        int length = 2*N - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = R1; i < R2 + 1; i++) {
            for (int j = C1; j < C2 + 1; j++) {
                //다이아몬드 중심에서의 거리를 알아야함, 좌표에서 절대적 위치를 알아야함
                int x = i % length;//한 다이아몬드에서의 위치
                int y = j % length;// 한 다이아몬드에서의 위치
                //중심에서 위치까지의 거리
                int dist = Math.abs((N-1) - x) + Math.abs(N-1 - y);
                if( dist >= N ) sb.append(".");
                else sb.append((char)((dist % N) + 'a'));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
