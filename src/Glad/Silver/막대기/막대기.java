package Glad.Silver.막대기;

import java.util.*;

public class 막대기 {
    public static void main(String[] args) {
        //재귀 함수를 통해
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        stack.add(64);
        int sum = 64;
        while(sum > X) {
            Integer pop = stack.pop();
            sum -= pop;
            int half = pop/2;
            sum += half;
            stack.add(half);
            if(sum < X ){
                stack.add(half);
                sum += half;
            }
        }
        System.out.println(stack.size());

    }
}
