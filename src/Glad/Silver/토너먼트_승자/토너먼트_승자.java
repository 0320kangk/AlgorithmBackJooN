package Glad.Silver.토너먼트_승자;

import java.util.Scanner;

public class 토너먼트_승자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");

        double[][] winRates = new double[8][8];

        int idx = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (i == j) continue;
                winRates[i][j] = Integer.parseInt(split[idx]) / 100.0;
                winRates[j][i] = 1 - (Integer.parseInt(split[idx]) / 100.0);
                idx++;
            }
        }
        //각 번호가 라운드에 올라갈 확률
        double[][] winRounds = new double[3][8];
        for (int i = 0; i < 4; i++) {
            winRounds[0][2*i] = winRates[2*i][2*i+1];
            winRounds[0][2*i +1] = winRates[2*i+1][2*i];
        }

        for (int i = 0; i < 8; i++) {
            if( i< 4){
                if(i == 0 || i == 1){
                    winRounds[1][i] += winRounds[0][i] * winRounds[0][2] * winRates[i][2];
                    winRounds[1][i] += winRounds[0][i] * winRounds[0][3] * winRates[i][3];
                }
                else {
                    winRounds[1][i] += winRounds[0][i] * winRounds[0][0] * winRates[i][0];
                    winRounds[1][i] += winRounds[0][i] * winRounds[0][1] * winRates[i][1];
                }
            } else {
                if(i == 4|| i == 5){
                    winRounds[1][i] += winRounds[0][i] * winRounds[0][6] * winRates[i][6];
                    winRounds[1][i] += winRounds[0][i] * winRounds[0][7] * winRates[i][7];
                } else {
                    winRounds[1][i] += winRounds[0][i] * winRounds[0][4] * winRates[i][4];
                    winRounds[1][i] += winRounds[0][i] * winRounds[0][5] * winRates[i][5];
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            if(i < 4){
                for (int j = 4; j < 8; j++) {
                    winRounds[2][i] += winRounds[1][i] * winRounds[1][j]* winRates[i][j];
                }
            }
            else {
                for (int j = 0; j < 4; j++) {
                    winRounds[2][i] += winRounds[1][i] * winRounds[1][j] * winRates[i][j];
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            System.out.print(winRounds[2][i] + " ");
        }
    }
}
