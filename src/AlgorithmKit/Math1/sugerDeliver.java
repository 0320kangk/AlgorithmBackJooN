package AlgorithmKit.Math1;

import java.util.Scanner;

public class sugerDeliver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int CountFive = 0;
        int CountThree = 0;
        int Remainder = 0;
        int flag = 0;

        CountFive = input / 5;
        Remainder = input % 5;


        while (flag != 1) {

            if (Remainder % 3 != 0) {

                if (CountFive > 0) {

                    Remainder += 5;
                    CountFive--;
                }
                //봉지 개수 만들기 실패
                else {

                    flag = 1;
                    CountFive = 0;
                    CountThree = -1;

                }
            } else {

                CountThree = Remainder / 3;
                flag = 1;

            }

        }


        System.out.println(CountFive + CountThree);


    }
}
