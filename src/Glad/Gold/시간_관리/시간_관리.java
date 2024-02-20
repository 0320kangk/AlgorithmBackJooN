package Glad.Gold.시간_관리;

import java.util.Arrays;
import java.util.Scanner;

public class 시간_관리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] tsArr = new int[N][2];
        int maxLateTime = 1000000;
        for (int i = 0; i < N; i++) {
            String[] ts = sc.nextLine().split(" ");
            tsArr[i][0] = Integer.parseInt(ts[0]);
            tsArr[i][1] = Integer.parseInt(ts[1]);
            maxLateTime = Math.min(maxLateTime, tsArr[i][1] - tsArr[i][0]);
        }
        Arrays.sort(tsArr, (ts1, ts2) ->  ts2[1]-ts1[1]);
        while(maxLateTime >= 0){
            int t = maxLateTime;
            for (int i = 0; i < tsArr.length; i++) {
                t += tsArr[i][0];
                if (t > tsArr[i][1] || t > 1000000) {
                    t = -1;
                    break;
                }
            }
            if ( t!= -1 ){ break;}
            else maxLateTime--;
        }
     /*   for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(tsArr[i]));
        }*/
        if (maxLateTime < 0 ) maxLateTime = -1;
        System.out.println(maxLateTime);

    }
}
