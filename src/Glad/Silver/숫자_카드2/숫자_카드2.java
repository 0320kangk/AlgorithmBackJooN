package Glad.Silver.숫자_카드2;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cards = new int[N];
        sc.nextLine();
            String s1 = sc.nextLine();
            String[] split1 = s1.split(" ");
            for (int i = 0; i < split1.length; i++) {
                cards[i] = Integer.parseInt(split1[i]);
            }

        int M = sc.nextInt();
        int[] values = new int[M];
        sc.nextLine();
        String s2 = sc.nextLine();
        String[] split2 = s2.split(" ");
        for (int i = 0; i < split2.length; i++) {
            values[i] = Integer.parseInt(split2[i]);
        }
        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int start = getStartIdx(cards, values, i);
            int end = getEndIdx(cards,values,i);
            if (start != -1)
                sb.append(end - start + 1).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    private static int getStartIdx(int[] cards, int[] values, int i) {
        int left = 0;
        int right = cards.length -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(cards[mid] == values[i]){
                if(mid - 1 < 0 || cards[mid - 1] != values[i])
                    return mid;
                else
                    right = mid - 1;
            }
            else if(cards[mid] > values[i]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    private static int getEndIdx(int[] cards, int[] values, int i) {
        int left = 0;
        int right = cards.length -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(cards[mid] == values[i]){
                if(mid + 1 > cards.length - 1 || cards[mid + 1] != values[i])
                    return mid;
                else
                    left = mid + 1;
            }
            else if(cards[mid] > values[i]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
