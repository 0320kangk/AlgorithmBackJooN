package Glad.Gold.동전_교환;

import java.util.Scanner;

public class 동전_교환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G1 = sc.nextInt();
        int S1 = sc.nextInt();
        int B1 = sc.nextInt();

        int G2 = sc.nextInt();
        int S2 = sc.nextInt();
        int B2 = sc.nextInt();
        //골드가 부족하면 실버에서 떙겨옴, 실버도 부족하면 브론즈에서 땡겨옴
        //위에 다 안되면 -1
        int count = 0;

        if(G1 < G2) {
            //확인
            int reqS = (G2 - G1) * 11;
            if(S1-S2 < reqS ){
                //S를 일단 먼저 사용
                count += S1 / 11;
                G1 += S1 / 11;
                S1 = S1 % 11;
                reqS = (G2 - G1) * 11;
                int reqB = (reqS -S1) * 11;
                if(B1 >= reqB){
                    count += reqB / 11;
                    S1 += (reqB / 11) - reqS;
                    G1 += reqS / 11;
                    count +=  reqS / 11;
                    B1 = B1 - reqB;
                }
            }else {
                count += G2 - G1;
                S1 -= reqS;
                G1 = G2;
            }
        }
//        System.out.println(count);
        if(S1 < S2){
            if(G1 > G2){
                int reqG = (int) Math.ceil ((S2-S1) / 9.0);
                if(G1 -G2 < reqG) {
                    S1 += (G1-G2) * 9;
                    count += G1-G2;
                    G1 -= G1-G2;
                } else {
                    count += reqG;
                    G1 -= reqG;
                    S1 += reqG * 9;
                }
            }if(B1 > B2 && S1 < S2) {
                int reqB = (S2-S1) * 11;
                if(B1-B2 >= reqB){
                    count += (int) Math.ceil ((reqB)/ 11.0);
                    B1 -= reqB;
                    S1 += (int) Math.ceil ((reqB)/ 11.0);
                }
            }

        }
//        System.out.println(count);

        if(B1 < B2) {
            int reqB = B2-B1;
            if(S1 > S2 ){
                if(reqB > (S1-S2) * 9){
                    count += (S1-S2);
                    B1 += (S1-S2) * 9;
                    S1 = S2;
                } else {
                    count += (int)Math.ceil(reqB / 9.0);
                    B1 +=  (int)Math.ceil(reqB / 9.0) * 9;
                    S1 -= (int)Math.ceil(reqB / 9.0);
                }
            }

            if(G1 > G2 && B1 < B2){
                int ableB = (G1 - G2) * 81;
                reqB = B2-B1;
                if(ableB >= reqB ){
                    G1 -= (int)Math.ceil((reqB) / 81.0);
                    int changeG = (int) Math.ceil((reqB) / 81.0);
                    int addS = changeG * 9;
                    S1 += addS;
                    count += changeG;
                    //s1 -> b1
                    int useS = (int) Math.ceil((reqB) / 9.0);//
                    count += useS;
                    B1 += useS * 9;
                    S1 -=  useS;
                }
            }
        }


        if(G1 >= G2 && S1 >= S2 && B1 >= B2){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }


    }
}
