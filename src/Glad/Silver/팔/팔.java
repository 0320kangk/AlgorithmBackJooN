package Glad.Silver.팔;

import java.util.Scanner;

public class 팔 {
    public static void main(String[] args) {
        /*
        700 900
        8이 얼마나 있는지 찾는 문제
        두 숫자 사이에 무엇이 올 수 있는지 알면 구 할 수 있는 문제

        or
        8이 필수인가만 보면 되나?
        최소를 구하는 것
        8이 고정인가를 구하면 됨
        8788 8888
        앞자리부터 8인지 확인한다.
        8일 때 마다 + 1
        다르다면 break
        끝

        ? 테스트 케이스 찾기
        188 1898
        -> 그냥 200 이면 되는거 아님?
         */
        Scanner sc = new Scanner(System.in);
        String L = sc.next();
        String R = sc.next();
        int count8 =0;
        if (L.length() == R.length()){
            for (int i = 0; i < L.length(); i++) {
                if(L.charAt(i) == '8' && R.charAt(i) == '8')count8++;
                else if(L.charAt(i) == R.charAt(i)) continue;
                else break;

            }
        }

        System.out.println(count8);


    }
}
