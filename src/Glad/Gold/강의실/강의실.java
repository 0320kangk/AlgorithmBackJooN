package Glad.Gold.강의실;

import java.util.*;

public class 강의실 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();

        int[][] classTime = new int[count][2];

        for (int i = 0; i < count; i++) {
            String[] split = sc.nextLine().split(" ");
            classTime[i][0] = Integer.parseInt(split[1]);
            classTime[i][1] = Integer.parseInt(split[2]);
        }
        Arrays.sort(classTime, (c1,c2) -> c1[0] - c2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < classTime.length; i++) {
            if (pq.isEmpty()){
                pq.add(classTime[i][1]);
                continue;
            }
            if (classTime[i][0] >= pq.peek()){
                pq.poll();
                pq.add(classTime[i][1]);
            }else {
                pq.add(classTime[i][1]);
            }
        }
        System.out.println(pq.size());

    }
}
