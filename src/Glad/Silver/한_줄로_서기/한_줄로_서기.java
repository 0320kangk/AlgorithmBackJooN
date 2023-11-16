package Glad.Silver.한_줄로_서기;

import java.util.Scanner;

public class 한_줄로_서기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] answers = new int[N];//answers 의 index를 위치라 하자
        for (int i = 0; i < N; i++) {
            int idx = arr[i];

            while (answers[idx] != 0 || findZero(answers, idx, i + 1) != arr[i]){
                idx++;
            }
            answers[idx] = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int answer : answers) {
            sb.append(answer + " ");
        }
        System.out.println(sb);
    }

    private static int findZero(int[] answers, int idx,int height) {
        int conut = 0;//count는 머지? 왼쪽에 자신보다 큰 키
        for (int i = 0; i < idx; i++) {
            if(answers[i] > height || answers[i] == 0){
                conut++;
            }
        }
        return conut;
    }
}
