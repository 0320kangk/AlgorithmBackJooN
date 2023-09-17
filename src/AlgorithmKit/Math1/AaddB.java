package AlgorithmKit.Math1;

import java.util.Scanner;


public class AaddB {




    /*void numberSplit(int[] array, int size, int num) {

        if( --size >= 0) {

            array[size] = num % 10000;
            System.out.println(array[size]);
            numberSplit( array, size, num / 10000);

        }

    }*/

    void StringSplit(String[] array, int size, int length, String text) {

        int i = 0;
        while (i < size - 1) {

            array[i] = text.substring(length - ((i + 1) * 4), length - (i * 4));
            i++;

        }
        array[size - 1] = text.substring(0, length - (i * 4));
    }

    public static void main(String[] args) {

        AaddB Adder = new AaddB();
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();

        int xSize = x.length();
        int ySize = y.length();

        int xArraySize = xSize % 4 == 0 ? xSize / 4 : xSize / 4 + 1;
        int yArraySize = ySize % 4 == 0 ? ySize / 4 : ySize / 4 + 1;

        String[] xArray = new String[10000];
        String[] yArray = new String[10000];


        int[] xIntArray = new int[10000];
        int[] yIntArray = new int[10000];

        Adder.StringSplit(xArray, xArraySize, xSize, x);
        Adder.StringSplit(yArray, yArraySize, ySize, y);


        for (int i = 0; i < xArraySize; i++) {
            xIntArray[i] = Integer.parseInt(xArray[i]);

        }

        for (int i = 0; i < yArraySize; i++) {
            yIntArray[i] = Integer.parseInt(yArray[i]);

        }

        int bigSize = Math.max(xArraySize, yArraySize);
        int[] zIntArray = new int[10001];


        for (int i = 0; i < bigSize - 1; i++) {

            zIntArray[i] = xIntArray[i] + yIntArray[i] + zIntArray[i];


            if (zIntArray[i] >= 10000) {

                zIntArray[i] -= 10000;
                zIntArray[i + 1] = 1;

            }
        }

        zIntArray[bigSize - 1] = xIntArray[bigSize - 1] + yIntArray[bigSize - 1] + zIntArray[bigSize - 1];

        System.out.print(zIntArray[bigSize - 1]);
        for (int i = bigSize - 2; 0 <= i; i--) {

            int digitCorrection = zIntArray[i];

            if (digitCorrection < 10) {

                System.out.print(0);
                System.out.print(0);
                System.out.print(0);
                System.out.print(zIntArray[i]);

            } else if (digitCorrection < 100) {

                System.out.print(0);
                System.out.print(0);
                System.out.print(zIntArray[i]);
            } else if (digitCorrection < 1000) {


                System.out.print(0);
                System.out.print(zIntArray[i]);
            } else {
                System.out.print(zIntArray[i]);
            }

        }

    }

}




