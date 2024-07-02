package Glad.Silver.국회의원_선거;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 국회의원_선거 {
    public static void main(String[] args) {
        /*
        가장 큰 수를 뽑음
        다솜이 보다 크다면 매수해서 표를 뺏음
        (큰수 - 다솜이 표 / 2)  + 1
        15 19
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N-1];
        int dasom = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int countVote = 0;
        Arrays.sort(arr, Collections.reverseOrder());
        while (arr.length > 0 && dasom <= arr[0]){
            dasom++;
            arr[0]--;
            countVote++;
            Arrays.sort(arr, Collections.reverseOrder());
        }

        System.out.println(countVote);
    }
}
