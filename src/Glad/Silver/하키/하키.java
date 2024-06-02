package Glad.Silver.하키;

import java.util.Scanner;

public class 하키 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int W = Integer.parseInt(nums[0]);
        int H = Integer.parseInt(nums[1]);
        int X = Integer.parseInt(nums[2]);
        int Y = Integer.parseInt(nums[3]);
        int P = Integer.parseInt(nums[4]);

        //첫 번째 원 구역
        // (h/2)^2 >= (x-a)^2 + (y-b)^2;// a , b는 사람 좌표,
        //두 번째 원 구역
        //(h/2)^2 >= (px - ( x-width)^2)) + (py - (y-(height/2)^2));

        int r = H/2;
        int rr = (int)Math.pow(r, 2);
        int count = 0;
        for (int i = 0; i < P; i++) {
            int px = sc.nextInt();
            int py = sc.nextInt();

            int c1Range =(int)(Math.pow((px - X),2) + Math.pow(py - (Y + r), 2));
            int c2Range =(int)((Math.pow(px - (X + W),2) +  Math.pow(py - (Y + r),2)));

            if(rr >= c1Range || rr >= c2Range ||
                    (px >= X && px <= X + W) && (py >= Y && py <= Y + H)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
