package Glad.Gold.겹치는_선분;


import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 겹치는_선분 {
    static class Line implements Comparable<Line> {
        int point;
        int type;

        public Line(int point, int type) {
            this.point = point;
            this.type = type;
        }

        // type = 0 시작점
        // type = 1 끝점
        @Override
        public int compareTo(Line line) {
            if( this.point == line.point ) return line.type - this.type;
            return this.point - line.point;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        PriorityQueue<Line> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            pq.add(new Line(Integer.parseInt(st.nextToken()), 0));
            pq.add(new Line(Integer.parseInt(st.nextToken()), 1));
        }
        //시작점 오름차순 정렬
        int count = 0;
        int answer = 0;
        while (!pq.isEmpty()){
            Line poll = pq.poll();
            //끝점이면 --
            //시작점이면 ++
            // 어차피 가장 높을 때만 찾는 것
            if(poll.type == 0 ){
                count++;
                answer = Math.max(count, answer);
            } else {
                count--;
            }
        }
        System.out.println(answer);
    }
}
