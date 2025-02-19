package Glad.Silver.쓰레기_수거;

import java.util.Scanner;
import java.util.Stack;

public class 쓰레기_수거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T > 0 ){
            int answer = 0;
            String[] wn = sc.nextLine().split(" ");
            int w = Integer.parseInt(wn[0]);
            int n = Integer.parseInt(wn[1]);
//            int[][] trashArea = new int[n][2];
            Stack<Integer[]> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                String[] xw = sc.nextLine().split(" ");
                stack.add(new Integer[]{Integer.parseInt(xw[0]),  Integer.parseInt(xw[1])});
            }
            int current_weight = 0;
            while(!stack.isEmpty()){
                Integer[] peek = stack.peek();
                if(current_weight + peek[1] <= w) {
                    w += peek[1];
                } else {
                    
                }

            }
            System.out.println(answer);
        }
    }
}
