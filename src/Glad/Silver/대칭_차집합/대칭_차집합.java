package Glad.Silver.대칭_차집합;

import java.util.HashSet;
import java.util.Scanner;

public class 대칭_차집합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aCount = sc.nextInt();
        int bCount = sc.nextInt();
        sc.nextLine();
        String[] aUnion = sc.nextLine().split(" ");
        String[] bUnion = sc.nextLine().split(" ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < aUnion.length; i++) {
            set.add(aUnion[i]);
        }
        int answer = 0;
        for (int i = 0; i < bUnion.length; i++) {
            if(!set.add(bUnion[i])) {
                answer++;
            }
        }
        System.out.println(aCount + bCount - 2 * answer );
    }
}
