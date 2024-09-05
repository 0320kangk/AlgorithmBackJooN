package Glad.Gold.주기문으로_바꾸기;

import java.util.Arrays;
import java.util.Scanner;

public class 주기문으로_바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        //M이하의 주기문 만들기

        sc.nextLine();
        String word = sc.nextLine();
        char[] messages = word.toCharArray();
        int min = word.length();
        for (int i =1; i <= M; i++) {
            char[] copyMessage = Arrays.copyOf(messages, messages.length);
            int maxI = word.length() - i - 1;
            int count = 0;
            for (int j = 0; j <= maxI; j++) {
                if(copyMessage[j]!=copyMessage[j + i]){
                    copyMessage[j + i] = copyMessage[j];
                    count++;
                }
            }
            min = Math.min(count, min);

        }

        System.out.println(min);

    }
}
