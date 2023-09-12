package String;

import java.util.Scanner;


public class StringRepeat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] repeatArray = new int[count];
        String[] text = new String[count];

        for (int i = 0; i < count; i++) {

            repeatArray[i] = sc.nextInt();
            text[i] = sc.next();

        }
        for (int i = 0; i < count; i++) {

            for (int j = 0; j < text[i].length(); j++) {

                for (int k = 0; k < repeatArray[i]; k++) {

                    System.out.print(text[i].charAt(j));

                }

            }
            System.out.println();
        }

    }

}
