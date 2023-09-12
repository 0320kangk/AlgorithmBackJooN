package Math1;

import java.util.Scanner;

public class breakEvenPoint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] list = new int[3];
        for (int i = 0; i < 3; i++) {

            list[i] = sc.nextInt();

        }

        if (list[2] > list[1]) {

            System.out.println(list[0] / (list[2] - list[1]) + 1);


        } else {

            System.out.println(-1);

        }


    }


}
