package Glad.Gold.감소하는_수;

import java.util.*;

public class 감소하는_수 {
    static List<Long> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            findNum(i);
        }
        if(N >= list.size())
            System.out.println(-1);
        else{
            list.sort(Comparator.naturalOrder());
            System.out.println(list.get(N));
        }
    }
    /*
    num -> 만들어가는 숮사

     */
    public static void findNum(long num) {
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            findNum(num * 10 + i);
        }
    }

}
