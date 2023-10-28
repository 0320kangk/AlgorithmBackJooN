package Glad.Gold.카드_섞기;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드_섞기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        int[] S = new int[N];
        sc.nextLine();
        String[] pValues = sc.nextLine().split(" ");
        String[] sValues = sc.nextLine().split(" ");
        for (int i = 0; i < pValues.length; i++) {
            P[i] = Integer.parseInt(pValues[i]);
        }
        for (int i = 0; i < sValues.length; i++) {
            S[i] = Integer.parseInt(sValues[i]);
        }
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = i;
        }
        int repeat = 0;
        int[] cardsCopy = Arrays.copyOf(cards, cards.length);
        //cards 는 0부터 차례데로 0~2번 사람에게 분배된다.
        //P[cards[i]] 의 cards[i]는 플에이어(P값)이 받아야 할 카드 번호이다.
        //i % 3는 0번부터 2번까지 차레데로 카드를 지급할 때 받는 사람을 의미한다.
        //실제 카드를 받는 사람과 cardsCopy의 카드 번호를 받아야 할 P 값이 다르다면 순서가 잘못된 것이다.
        while(true) {
            boolean flag = false;
            for (int i = 0; i < cardsCopy.length; i++) {
                if (P[cardsCopy[i]] != i % 3) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                break;
            repeat++;
            int[] sCards = new int[N];
            for (int i = 0; i < N; i++) {
                sCards[S[i]] = cardsCopy[i];
            }
            cardsCopy = sCards;
            if (Arrays.equals(cardsCopy, cards)){
                repeat = -1;
                break;
            }
        }
        System.out.println(repeat);
    }
}
