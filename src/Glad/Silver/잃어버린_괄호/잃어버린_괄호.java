package Glad.Silver.잃어버린_괄호;

import java.util.Scanner;

public class 잃어버린_괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String eq = sc.nextLine();
        int start = 0;
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < eq.length(); i++) {
            if(eq.charAt(i) == '-' || eq.charAt(i) == '+' || i == eq.length() - 1 ){
                int end = i;
                if(end == eq.length() -1) end++;
                int num = Integer.parseInt(eq.substring(start, end));
                if (flag) sum -= num;
                else sum += num;
                start = i + 1;
            }
            if(  eq.charAt(i) == '-'  ){
                flag = true;
            }

        }
        System.out.println(sum );
    }
}