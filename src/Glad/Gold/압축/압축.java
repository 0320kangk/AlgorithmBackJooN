package Glad.Gold.압축;

import java.util.Scanner;
import java.util.Stack;

public class 압축 {
    static String[] splitStr;
    static int idx;
    static Stack<String> stack = new Stack<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        splitStr = sc.nextLine().split("");
        System.out.println(decord(0));
    }


    static int decord(int start){
        int len = 0;
        for (int i = start; i < splitStr.length ;i++) {
            if (splitStr[i].equals("(")) {
                stack.add("(");
                len += Integer.parseInt(splitStr[i-1]) * decord(i + 1)  - 1;
                i = idx;
            } else if (splitStr[i].equals(")")){
                stack.pop();
                idx = i;
                return len;
            } else {
                len++;
            }
        }
        return len;
    }
}
