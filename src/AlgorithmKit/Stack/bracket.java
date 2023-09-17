package AlgorithmKit.Stack;

import java.util.Scanner;
import java.util.Stack;

public class bracket {


    public static void main(String[] args) {

        Stack<Character> stack = new Stack();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder br = new StringBuilder();

        String input;
        boolean check;

        for (int i = 0; i < count; i++) {
            check = true;
            input = sc.next();
            for (int j = 0; j < input.length(); j++) {

                if (input.charAt(j) == '(') {

                    stack.push('(');

                } else if (!stack.empty()) {
                    stack.pop();
                } else {
                    check = false;
                    break;
                }

            }
            if (stack.empty() && check == true) {

                br.append("YES").append('\n');

            } else {
                stack.clear();
                br.append("NO").append('\n');
            }


        }
        System.out.print(br);
    }

}





