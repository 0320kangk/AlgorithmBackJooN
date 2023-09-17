package AlgorithmKit.String;

import java.util.Scanner;

public class FindAlphabet {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char alphabet = 'a';
        for (int i = 0; i < 26; i++) {


            System.out.print(text.indexOf(Character.toString(alphabet)) + " ");
            alphabet++;

        }


    }


}
