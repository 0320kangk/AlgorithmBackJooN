package Glad.Gold.합성소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 합성소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(sc.next());
            arr[i] = num;
            if (arr[i] > max) max = arr[i];
        }
        boolean[] notPrimes = new boolean[max + 1];
        checkCompositeNumber(notPrimes);
        notPrimes[0] = true;
        notPrimes[1] = true;

        List<Integer> list = new ArrayList<>();
        for (int i = 101; i <= max; i++) {
            if(notPrimes[i] && checkPartialNumber(i, notPrimes)){
                list.add(i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                Integer compositePrime = list.get(j);
                if (arr[i] <= compositePrime){
                    if(arr[i] == compositePrime) sb.append(compositePrime).append("\n");
                    else if (j > 0) sb.append(list.get(j- 1)).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                } else if (j == list.size() - 1) {
                    sb.append(list.get(list.size() - 1)).append("\n");
                }
            }
        }
        if (list.isEmpty()){
            for (int i = 0; i < T; i++) {
                sb.append("-1").append("\n");
            }
        }

        System.out.println(sb);
    }
    static void checkCompositeNumber(boolean[] notPrimes){
        for (int i = 2; i <= Math.sqrt(notPrimes.length - 1); i++) {
            if (notPrimes[i])continue;
            for (int j = i + i; j < notPrimes.length; j+=i) {
                notPrimes[j] = true;
            }
        }

    }
    static boolean checkPartialNumber(int num, boolean[] isPrimes) {
        String tNum = String.valueOf(num);
        int[] arr = new int[tNum.length()];
        int temp = num;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = temp % 10;
            temp = temp / 10;
        }
        int sum = 0;
        for (int i = 0; i < tNum.length() - 1; i++) { // 위치
            sum = arr[i];
            for (int j = i + 1; j < tNum.length(); j++) {// 길이
                if (i == 0 && j == tNum.length() - 1)continue;
                sum = sum * 10 + arr[j];

                if (isPrimes[sum]){
                    return false;
                }
            }
        }
        return true;
    }
}
