package Glad.Silver.침투_계획_세우기;

import java.util.Scanner;

public class 침투_계획_세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int i = 1;
        long point = 1;
        while(x + y >= i) point += 6L * i++;
        if(y > 0) point -= (i-1) * 6L;
        while(y-- > 0) point +=1;

        System.out.println(point);
    }
}
