package Glad.Silver.수_이어_쓰기;

import java.util.Scanner;

public class 수_이어_쓰기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        char[] arrNum = num.toCharArray();
        int arrP = 0;
        int ans = 1;
        while(arrP < arrNum.length){
            String x = String.valueOf(ans);
            for (int i = 0; i < x.length(); i++) {
                if( x.charAt(i) == arrNum[arrP]){
                    arrP++;
                }
                if(arrP > arrNum.length) break;
            }
            ans++;
        }
        System.out.println(ans-1);
    }
}
