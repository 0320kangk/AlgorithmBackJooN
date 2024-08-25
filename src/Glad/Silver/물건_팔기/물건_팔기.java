package Glad.Silver.물건_팔기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 물건_팔기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            Integer[] prices = new Integer[2];
            prices[0] = Integer.parseInt(split[0]);
            prices[1] = Integer.parseInt(split[1]);
            list.add(prices);
        }
        /*
        계쏙 이상하게 푸는중
        중요한 것은
        x 원에 팔면 전부다 x원이 된다는 것
         */
        Collections.sort(list, (p1, p2) -> p2[0] - p1[0]);
        int answer = 0;
        int maxProfit = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer[] p1 = list.get(i);
            int profit = 0;
            for (int j = 0; j <= i; j++) {
                if(p1[0] - list.get(j)[1]>= 0) profit += (p1[0] - list.get(j)[1]);
            }
            if(profit >= maxProfit && profit != 0){
                maxProfit = profit;
                answer = p1[0];
            }
        }
        System.out.println(answer);
    }
}