package Glad.Silver.접두사;

import java.util.*;

public class 접두사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = sc.next();
        }
        int max = 0;
        Arrays.sort(strings, Collections.reverseOrder());
        HashSet<String> set = new HashSet<>();
        set.add(strings[0]);
        for (String s1 : strings) {
            boolean flag = false;
            for (String s2 : set) {
                if(s2.startsWith(s1)){
                    flag =true;
                    break;
                }
            }
            if(!flag) set.add(s1);
        }
        System.out.println(set.size());
    }
}
