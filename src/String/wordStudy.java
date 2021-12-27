package String;

import java.util.Scanner;

public class wordStudy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int[] alphabetCount = new int[26];
        for (int i = 0; i < 26 ;i++) {
            alphabetCount[i] = 0;
        }
        for(int i = 0 ; i < text.length(); i++) {

            char x = text.charAt(i);

            if ( x < 97) {

                alphabetCount[x - 65]++;

            }
            else {

                alphabetCount[x - 97]++;

            }

        }

        int bigCount = 0;
        int position = 0;
        for (int i = 0 ; i < 26 ; i++) {

            if ( bigCount <= alphabetCount[i] ) {

                bigCount =  alphabetCount[i];
                position = i;

            }

        }
        for ( int i = 0 ; i < 26 ; i++) {

            if ( bigCount == alphabetCount[i] && position != i) {

                bigCount = -1;

            }
        }
        if ( bigCount == -1  ){
            System.out.println("?");

        }
        else {

            System.out.println( (char) (position + 65) );

        }



    }


}
