package Glad.Silver.날짜_계산;

import java.util.Scanner;

public class 날짜_계산 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int X = 0;
        int Y = 0;
        int Z = 0;

        int year = 0;
        while (E != X || S != Y || M != Z) {
            X++;
            Y++;
            Z++;
            if (X == 16) X = 1;
            if (Y == 29) Y = 1;
            if (Z == 20) Z = 1;
            year++;
        }
        System.out.println(year);


    }
}
