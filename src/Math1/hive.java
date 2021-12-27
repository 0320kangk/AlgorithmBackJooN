package Math1;

import java.util.Scanner;

public class hive {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = 1;
        if ( x== 1) {
            System.out.println( 1 );
            System.exit(0);
        }
        while (true) {

            if ( 3*(n-1)*(n-1) + 3*(n-1) + 1 < x && x <= 3*n*n + 3*n +1 ) {

                System.out.println( n + 1 );
                break;

            }
            n++;

        }

    }


}
