package String;

import java.util.Scanner;

public class groupWordChecker {

    public static void main(String[] args) {

        int[] alphabetList = new int[26];

        for (int i = 0; i < 26; i++) {

            alphabetList[i] = 0;
        }

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] stringList = new String[count];

        for (int i = 0; i < stringList.length; i++) {

            stringList[i] = sc.next();

        }
        int WordCheckerCount = count;
        for (int i = 0; i < count; i++) {

            int stringLength = stringList[i].length();

            for (int j = 0; j < stringLength; j++) {

                alphabetList[stringList[i].charAt(j) - 97]++;

            }
            for (int k = 0; k < 26; k++) {

                if (alphabetList[k] > 1) {

                    if ((stringList[i].lastIndexOf(k + 97) - stringList[i].indexOf(k + 97)) != alphabetList[k] - 1) {

                        WordCheckerCount--;
                        break;

                    }


                }
            }
            for (int l = 0; l < 26; l++) {

                alphabetList[l] = 0;
            }


        }
        System.out.println(WordCheckerCount);


    }


}
