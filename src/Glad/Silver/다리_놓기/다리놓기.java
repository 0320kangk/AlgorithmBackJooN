package Glad.Silver.다리_놓기;

import java.util.ArrayList;
import java.util.Scanner;

public class 다리놓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int sBridge = sc.nextInt();
            int eBridge = sc.nextInt();
            int restBridge = eBridge - sBridge;
            long answer = 1;
            int max = Math.max(restBridge, eBridge-restBridge);
            int min = Math.min(restBridge, eBridge-restBridge);
            for (int j = max + 1; j <= eBridge; j++) {
                answer *= j;
            }
            for (int j = 1; j <= min; j++) {
                answer /= j;
            }
            System.out.println(answer);
        }
        ArrayList<int[]> list = new ArrayList<>();
        list.toArray(new Integer[0]);

    }
}
