package Glad.Silver.삼각형_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 삼각형_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] =Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int max = -1;
        for (int i = N - 1; i >= 2 ; i--) {
            if(arr[i] < arr[i - 1] + arr[i - 2]){
                max = arr[i-1] + arr[i-2] + arr[i];
                System.out.println(max);
                return;
            }
        }
        System.out.println(max);
    }
}
