package Glad.Silver.기타리스트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 기타리스트 {
    static int N;
    static int S;
    static int M;
    static int[] volumeDiffs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int[] volumeDiffs = new int[N];
        sc.nextLine();
        String[] split = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            volumeDiffs[i] = Integer.parseInt(split[i]);
        }
        int[] volumes = new int[M + 1]; //모든 볼륨의 범위
        Arrays.fill(volumes, -1);
        //중요한 것은 시점과 볼륨량
        // vol[볼륨량] = 시점;
        volumes[S] = 0;
        for (int i = 1; i < N + 1; i++) {
            List<Integer> nextVolumes = new ArrayList<>();
            for (int j = 0; j < M+1; j++) {
                if(volumes[j] == i-1) {
                    int nextVol1 = j -volumeDiffs[i - 1];
                    int nextVol2 = j+volumeDiffs[i - 1];
                    if(nextVol1 >= 0) nextVolumes.add(nextVol1);
                    if(nextVol2 <= M) nextVolumes.add(nextVol2);
                }
            }
            for (Integer nextVolume : nextVolumes) volumes[nextVolume] = i;
        }
        int answer = -1;
        for (int i = 0; i < M + 1; i++) {
            if(volumes[i] == N)  answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
