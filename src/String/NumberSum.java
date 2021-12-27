package String;

import java.util.Scanner;

public class NumberSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String number = sc.next();
        int Storage = 0;
        for (int i = 0 ; i < count ; i++ ) {
            Storage += (int)number.charAt(i) - 48;
        }
        System.out.println(Storage);

    }

}
