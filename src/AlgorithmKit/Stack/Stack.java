package AlgorithmKit.Stack;

import java.util.Scanner;


public class Stack {

    int location = -1;
    int[] stack = new int[10000];


    void push(int num) {

        stack[++location] = num;

    }

    int pop() {

        if (location >= 0) {

            return stack[location--];
        } else {
            return -1;
        }


    }

    int size() {

        return location + 1;

    }

    int empty() {

        if (location < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    int top() {
        if (location < 0) {
            return -1;
        } else {
            return stack[location];
        }

    }

    public static void main(String[] args) {

        Stack x = new Stack();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int count = sc.nextInt();
        String command;

        for (int i = 0; i < count; i++) {

            command = sc.next();

            if (command.equals("push")) {

                x.push(sc.nextInt());
            } else if (command.equals("pop")) {

                sb.append(x.pop()).append('\n');
            } else if (command.equals("size")) {

                sb.append(x.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(x.empty()).append('\n');
            } else if (command.equals("top")) {
                sb.append(x.top()).append('\n');
            }
        }

        System.out.println(sb);

    }

}
