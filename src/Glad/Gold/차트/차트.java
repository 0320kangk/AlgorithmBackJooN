package Glad.Gold.차트;

import java.util.Scanner;

public class 차트 {
    static int[] dogsArr;
    static int[] dogsTable;
    static boolean[] visited;
    static int count = 0;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dogsArr = new int[N];
        dogsTable = new int[N];
        visited = new boolean[N];
        sc.nextLine();
        String dogsData = sc.nextLine();
        String[] split = dogsData.split(" ");
        for (int i = 0; i < split.length; i++) {
            int value = Integer.parseInt(split[i]);
            if (value > 50) {
                System.out.println(0);
                System.exit(0);
            }
            dogsTable[i] = value;
        }
        dogsArr = new int[] {1, 1, 48, 1,1, 48};
        find50();
        System.out.println(count);
    }
    static void find50() {
        int lp = 0;
        int rp = 1;
        int sum = dogsArr[0];
        int cnt = 0;
        while (rp < N) {
            if (sum == 50) {
                cnt++;
                System.out.println(lp + ":" + rp);
                sum += dogsArr[rp++];
                sum -= dogsArr[lp++];
            } else if ( sum > 50) {
                sum -= dogsArr[lp++];
            } else {
                sum += dogsArr[rp++];
            }
        }
        while (sum > 50 && lp < rp) {
            if (sum == 50){
                cnt++;
            }
            sum -= dogsArr[lp++];
        }
        count = Math.max(cnt , count);
    }
    //조합
    //모든 값으 2..n개씩 뽑아서 50의 개수를 찾기
    static void findLine(int idx) {
        if ( N == idx) {
            find50();
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dogsArr[idx] = dogsTable[i];
                    findLine( idx + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
