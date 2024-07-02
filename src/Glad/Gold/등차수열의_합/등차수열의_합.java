package Glad.Gold.등차수열의_합;


import java.util.Scanner;

public class 등차수열의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        switch (k){
            case 2: {
                count = Math.max ((r - Math.max(3, l)) + 1, 0 );
                break;
            }
            case 3: {
                l = adjustStartPoint(l, 3);
                r = adjustEndPoint(r, 3);
                count = Math.max ((r - Math.max(6, l))/3 + 1, 0 );
                break;
            }
            case 4: {
                l = adjustStartPoint(l, 2);
                r = adjustEndPoint(r, 2);
                count = Math.max ((r - Math.max(10, l))/2 + 1, 0 );
                if(l <= 12 && r >= 12){
                    count--;
                }
                break;
            }case 5: {
                l = adjustStartPoint(l, 5);
                r = adjustEndPoint(r, 5);
                count = Math.max ((r - Math.max(15, l))/5 + 1, 0 );
                break;
            }
        }
        System.out.println(count);
    }
    public static int adjustStartPoint(int x, int multiple) {
        return (x % multiple == 0) ? x : x + (multiple - x % multiple);
    }

    public static int adjustEndPoint(int x, int multiple) {
        return (x % multiple == 0) ? x : x - (x % multiple);
    }
}
