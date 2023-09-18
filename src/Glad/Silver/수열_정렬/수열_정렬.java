package Glad.Silver.수열_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 수열_정렬 {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        int[] copyB = Arrays.copyOf(B, B.length);
        Arrays.sort(copyB);
//        int[] P = new int[N];
        boolean[] usedIndex = new boolean[N];
        StringBuilder sb = new StringBuilder();
        int pIndex = 0;
        while (pIndex < N){
            for (int i = 0; i < copyB.length; i++) {
                if (B[pIndex] == copyB[i] && !usedIndex[i]){
                    usedIndex[i] = true;
//                    P[pIndex] = i;
                    sb.append(i + " ");
                    break;
                }
            }
            pIndex++;
        }
        System.out.println(sb.toString().trim());
    }
}
