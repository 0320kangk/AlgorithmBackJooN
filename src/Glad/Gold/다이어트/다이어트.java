package Glad.Gold.다이어트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class 다이어트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        List<objectG> list = new ArrayList<>();
        objectG og = new objectG(G);
        long min = 3;
        // 1500 = A^2 - B^2
        StringBuilder sb = new StringBuilder();
        for (int i = 2; G >= min; i++) {
            long diff = (long) Math.pow(i, 2) - (long) Math.pow(i - 1, 2);
            boolean flag =false;
            for (objectG objectG : list) {
                objectG.value += diff;
                if(objectG.value == G) flag = true;
            }
            list.add(new objectG(diff));
            if(flag || diff == G) sb.append(i).append("\n");
            min = list.get(list.size() - 1).value;
        }
        String answer = sb.toString();
        if(!answer.isEmpty()) System.out.println(answer);
        else System.out.println(-1);

    }
    static class objectG {
        public objectG(long value){
            this.value = value;
        }
        long value;
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            objectG objectG = (objectG) o;
            return value == objectG.value;
        }

    }
}
