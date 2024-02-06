package Glad.Silver.스위치_켜고_끄기;

import java.util.Scanner;

public class 스위치_켜고_끄기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sw = sc.nextInt();
        int[] on = new int[sw + 1];
        sc.nextLine();
        String switchStatus = sc.nextLine();
        String[] split = switchStatus.split(" ");
        for (int i = 1; i <= sw; i++) {
            on[i] = Integer.parseInt(split[i - 1]);
        }
        int stds = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < stds; i++) {
            String s = sc.nextLine();
            String[] split1 = s.split(" ");
            int gender = Integer.parseInt(split1[0]);
            int num = Integer.parseInt(split1[1]);
            //남자
            if( gender == 1) {
                for (int j = 1; j < on.length; j++) {
                    if (j % num == 0){
                        switchChange(on, j);
                    }
                }
            } else {
                switchChange(on, num);
                int move = 1;
                while (num - move > 0 &&
                        num + move < on.length) {
                    if (on[num - move] == on[num + move]){
                        switchChange(on, num - move);
                        switchChange(on, num + move);
                    } else {
                        break;
                    }
                    move++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < on.length; i++) {
            if (i % 20 != 0) sb.append(on[i]).append(" ");
            else sb.append(on[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void switchChange(int[] on, int i) {
        on[i] = on[i] == 0 ? 1 : 0;
    }
}
