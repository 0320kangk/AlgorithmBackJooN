package Glad.Silver.선물;

import java.util.Scanner;

public class 선물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 개수 5
        //최대 A 길이 정육면체 구하기
        int L = sc.nextInt();//밑변 길이 10
        int W = sc.nextInt();//밑변 높이 7
        int H = sc.nextInt();//높이  5
        //총 넓이 80 <= 10 개로 나누면 총 넓이 8?
        double left =0;
        double right = Math.min(L, Math.min(W,H));
        while( left < right) {
            double mid = (left + right)/2; //A길이
            if (left == mid || right == mid) break;//1.4*1.3*1.2
            if((long)(L/mid)*(long)(W/mid)*(long)(H/mid) >= N){
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }
}
