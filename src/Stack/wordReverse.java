package Stack;

import java.util.Scanner;
import java.util.Stack;

public class wordReverse {

    public static void main(String[] args ){

        Stack<Character> stack = new Stack();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int count = sc.nextInt();
        sc.nextLine();
        String x="";

        while ( count-- > 0) {
            x = sc.nextLine() + " ";

            for (int i = 0; i < x.length(); i++) {


                if (x.charAt(i) != ' ') {
                    stack.push(x.charAt(i));
                }
                else {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }

             }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}



