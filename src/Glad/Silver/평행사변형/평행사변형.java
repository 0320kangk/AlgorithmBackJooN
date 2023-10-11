package Glad.Silver.평행사변형;

import java.util.Arrays;
import java.util.Scanner;

public class 평행사변형 {
    public static void main(String[] args) {
        // 평행사변형을 만드는 점은 총 3개가 가능하다
        // A점 B점 C점 의 각을 마주보는 변 3개가 가능하다.
        // 즉 A B C 점을 이어 붙인 3가지 방법의 2배가 평행사변형 둘래가 된다.
        //선분 BA + AC, BC + CA, AB+ BC
        Scanner sc = new Scanner(System.in);
        int[] A = {sc.nextInt(), sc.nextInt()};
        int[] B = {sc.nextInt(), sc.nextInt()};
        int[] C = {sc.nextInt(), sc.nextInt()};

        //세 변이 일직선이 될 때 평행사변형이 될 수 없다., ab, bc 기울기가 같은가?
        if (  (A[1]-B[1]) * (B[0]-C[0])  == (B[1]-C[1]) * (A[0]-B[0]) ){
            System.out.println(-1);
        } else {
            //BA + AC
            double BC = Math.sqrt(Math.pow(B[0] - C[0], 2) + Math.pow(B[1] - C[1], 2));
            double AC = Math.sqrt(Math.pow(C[0] - A[0], 2) + Math.pow(C[1] - A[1], 2));
            double AB = Math.sqrt(Math.pow(A[0] - B[0], 2) + Math.pow(A[1] - B[1], 2));
            double[] recs = new double[3];
            recs[0] = (AB + AC) * 2;
            recs[1] = (BC + AC) * 2;
            recs[2] = (AB + BC) * 2;
            Arrays.sort(recs);
            System.out.println(recs[2] - recs[0]);
        }

    }
}
