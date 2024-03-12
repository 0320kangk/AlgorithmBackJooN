package Glad.Gold.X_K;

import java.util.Scanner;

public class X_K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int K = sc.nextInt();
        String binary_X = Integer.toBinaryString(X);
        String binary_K = Integer.toBinaryString(K);
        StringBuilder sb = new StringBuilder();
        int i = binary_K.length() - 1;
        int j = binary_X.length() - 1;
        while (i >= 0) {
            if (j < 0 || binary_X.charAt(j) == '0'){
                sb.append(binary_K.charAt(i));
                i--;
            }
            else {
                sb.append(0);
            }
            j--;
        }
        System.out.println(Long.parseLong(sb.reverse().toString(), 2));
    }
}
