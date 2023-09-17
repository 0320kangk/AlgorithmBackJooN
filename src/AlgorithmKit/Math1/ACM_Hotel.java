package AlgorithmKit.Math1;

import java.util.Scanner;


public class ACM_Hotel {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int TestData = sc.nextInt();
        int[][] Data = new int[TestData][3];

        for (int i = 0; i < TestData; i++) {

            for (int j = 0; j < 3; j++) {

                Data[i][j] = sc.nextInt();

            }

            int BackNumber;
            int FrontNumber;

            if (Data[i][2] % Data[i][0] == 0) {

                BackNumber = Data[i][2] / Data[i][0];
                FrontNumber = Data[i][0] * 100;

            } else {

                BackNumber = Data[i][2] / Data[i][0] + 1;
                FrontNumber = Data[i][2] % Data[i][0] * 100;
            }


            System.out.println(FrontNumber + BackNumber);

        }


    }

}
