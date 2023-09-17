package AlgorithmKit.String;

import java.util.Scanner;


public class wordCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] wordList = text.split(" ");
        int spaceCount = 0;
        for (int i = 0; i < wordList.length; i++) {


            if (wordList[i].isEmpty()) {

                spaceCount++;

            }

        }

        System.out.print(wordList.length - spaceCount);

    }


}
