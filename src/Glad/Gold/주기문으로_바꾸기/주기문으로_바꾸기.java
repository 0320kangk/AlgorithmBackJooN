package Glad.Gold.주기문으로_바꾸기;

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
        for (int i = 1; i <= M; i++) { //i=주기
            int count = 0;
            for (int j = 0; j < i; j++) {//j=주기 이하의 시작 지점
                int[] chars = new int[4];
                for (int k = j; k < messages.length; k+=i) { // 시작점~끝
                    if(messages[k] == 'A') chars[0]++;
                    else if(messages[k] == 'C') chars[1]++;
                    else if(messages[k] == 'G') chars[2]++;
                    else chars[3]++;
                }
                int max = Math.max(Math.max(chars[0], chars[1]), Math.max(chars[2], chars[3]));
                int sum = chars[0] +  chars[1] + chars[2] +  chars[3];
                count += sum - max;
            }
            min = Math.min(count, min);
        }
        System.out.println(min);
    }
}
