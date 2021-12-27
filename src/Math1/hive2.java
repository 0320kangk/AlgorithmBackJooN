package Math1;

import java.util.Scanner;

public class hive2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int multiple = 6;
        int depth = 0;
        int total = 1;

        while (true) {

            total = total + depth * multiple;

            if (total >= input) {
                break;
            }
            depth++;

        }
        System.out.println( depth + 1);

    }
}