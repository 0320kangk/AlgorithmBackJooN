package Glad.Gold.소트;

import java.util.Scanner;

public class 소트 {
    /*
    이 문제의 특징
    사전순으로 가장 뒷서는 결과를 출력해야 함
    교환은 최대 S번, 만약 교환이 의미없다면 안 해도 ㅗ됨

    최대한 가장 뒷서는 사전순을 뽑는법
    -> 가장 가장 앞에 자리를 최대한 큰 수로 배치하기

    ex> 3 1 2 4 5
    S= 2
    가장 앞자리는 2번의 이동으로 더 큰 수를 배치할 수 없음
    첫 번째 자리는 배제하고 푼다
    두 번째 자리는 가장 큰 수 4를 배치 할 수 있음
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        sc.nextLine();
        String nums = sc.nextLine();
        String[] numsSplit = nums.split(" ");
        for (int i = 0; i < numsSplit.length; i++) {
            arr[i] = Integer.parseInt(numsSplit[i]);
        }
        int S = sc.nextInt();
//        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            int maxValue = arr[i];
            int maxIndex = i;
            //S만큼 교환하여 옮길 수 있는 거리
            for (int j = i + 1; j < arr.length; j++) {
                if ( j-i > S)
                    break;
                if (maxValue < arr[j]){
                    maxValue = arr[j];
                    maxIndex = j;
                    //값 교환하기
                }
            }
             for (int k = maxIndex; k > i; k--) {
                 int temp = arr[k - 1];
                 arr[k - 1] = arr[k];
                 arr[k] = temp;
             }
            S -= (maxIndex - i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}
