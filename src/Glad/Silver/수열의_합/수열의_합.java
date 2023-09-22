package Glad.Silver.수열의_합;

import java.util.*;

public class 수열의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열의 합 N
        int L = sc.nextInt(); // 수열의 최소한의 길이 L
        int start = 0;
        int seqEnd = N;
        int sum = 0;
        int minLength = N;
        int seqStart = 0;
        for (int i = 0; i <= N; i++) {
            sum += i;
            while(sum > N) {
                sum -= start;
                start+=1;
            }
            int seqLength = i- start + 1;
            if ( sum == N && seqLength >= L){
                if (minLength > seqLength){
                    minLength = seqLength;
                    seqEnd = i;
                    seqStart = start;

                }
            }
        }

        System.out.println(sum);
        System.out.println(N);
        if (seqStart == 0 && seqEnd-seqStart + 1 > L) {
            seqStart++;
        }
        if ( seqEnd-seqStart + 1 > 100 || minLength == N ) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = seqStart; i <= seqEnd; i++) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());

    }
}
