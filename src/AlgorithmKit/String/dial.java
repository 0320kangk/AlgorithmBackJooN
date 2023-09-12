package String;

import java.util.Scanner;

public class dial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char alphabet;
        int timer = 0;
        for (int i = 0; i < text.length(); i++) {

            alphabet = text.charAt(i);

            if (alphabet >= 65 && alphabet <= 67) {

                timer += 3;

            } else if (alphabet >= 68 && alphabet <= 70) {

                timer += 4;


            } else if (alphabet >= 71 && alphabet <= 73) {

                timer += 5;

            } else if (alphabet >= 74 && alphabet <= 76) {

                timer += 6;

            } else if (alphabet >= 77 && alphabet <= 79) {

                timer += 7;
            } else if (alphabet >= 80 && alphabet <= 83) {

                timer += 8;
            } else if (alphabet >= 84 && alphabet <= 86) {

                timer += 9;

            } else if (alphabet >= 87 && alphabet <= 90) {

                timer += 10;

            }


        }
        System.out.println(timer);

    }


}
