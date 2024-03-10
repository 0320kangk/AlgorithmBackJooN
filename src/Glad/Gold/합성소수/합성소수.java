package Glad.Gold.합성소수;


import java.util.Arrays;
import java.util.Scanner;

public class 합성소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(sc.next());
            arr[i] = num;
        }
        Arrays.sort(arr);
        boolean[] isPrimes = new boolean[arr[T - 1] + 1];
        for (int i = 0; i < isPrimes.length; i++) {
            isPrimes[i] = !checkCompositeNumber(i);
        }
        isPrimes[1] = false;
        boolean[] isCompositePrimes = new boolean[arr[T - 1] + 1];
        for (int i = 0; i < T; i++) {
            int num = arr[i];
            while(num > 100){
                if(!isPrimes[num] && (isCompositePrimes[num] ||checkPartialNumber(num, isPrimes))){
                    isCompositePrimes[num] = true;
                    sb.append(num).append("\n");
                    break;
                }
                num--;
            }
            if (num <= 100) sb.append(-1).append("\n");

        }
        System.out.println(sb);
    }
    static boolean checkCompositeNumber(int num){
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                return true;
            }
        }
        return false;
    }
    static boolean checkPartialNumber(int num, boolean[] isPrimes) {
        String tNum = String.valueOf(num);
        int[] arr = new int[tNum.length()];
        int temp = num;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp % 10;
            temp = temp / 10;
        }
        int sum = 0;
        for (int i = 1; i < tNum.length() - 1; i++) { // 길이
            for (int j = i; j < tNum.length(); j++) {// 위치
                sum = 0;
                for (int k = j; k >= j - i; k--) {
                    sum = sum * 10 + arr[k];
                }
                if (!isPrimes[sum]){
                    return false;
                }
            }
        }
        return true;
    }
}
