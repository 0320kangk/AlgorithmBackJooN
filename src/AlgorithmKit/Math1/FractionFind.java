package AlgorithmKit.Math1;

import java.util.Scanner;

public class FractionFind {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int molecule = 1; //분자
        int denominator = 1; //분모
        int count = sc.nextInt();

        while (count > 1) {


            if (molecule == 1) {

                denominator++;
                count--;

            } else {

                molecule++;
                count--;
            }

            if (molecule == 1) {

                while (denominator != 1) {

                    if (count == 1) {
                        break;
                    }

                    denominator--;
                    molecule++;
                    count--;


                }

            } else {
                while (molecule != 1) {

                    if (count == 1) {
                        break;
                    }

                    denominator++;
                    molecule--;
                    count--;

                }
            }


        }
        System.out.println(molecule + "/" + denominator);


    }

}
