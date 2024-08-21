package Glad.Silver.방_번호;

import java.util.*;

public class 방_번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        while (N > 0){
            int rest = N % 10;
            if( rest == 9) rest = 6;
            map.put(rest, map.getOrDefault(rest, 0) + 1);
            N = N / 10;
        }

        if(map.containsKey(6)){
            int value = map.get(6);
            if(value % 2 == 1) value = value /2 + 1;
            else value = value/2;
            map.put(6, value);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.get(0));
    }
}
