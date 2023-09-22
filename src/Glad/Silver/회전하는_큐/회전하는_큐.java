package Glad.Silver.회전하는_큐;

import java.util.*;

public class 회전하는_큐 {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Queue<Integer> pollQ = new LinkedList<Integer>();
        for (int i = 0; i < M; i++) {
            pollQ.add(sc.nextInt() - 1);
        }
        for (int i = 0; i < N; i++) {
            deque.add(i);
        }
        int move = 0;
        while(!pollQ.isEmpty()){
            Integer pollIndex = pollQ.poll();
            ArrayDeque<Integer> deque1 = new ArrayDeque<>(deque);
            ArrayDeque<Integer> deque2 = new ArrayDeque<>(deque);
            int leftMove = findIndex(deque1 , pollIndex, 2);
            int rightMove = findIndex(deque2, pollIndex, 3);
            int min = Math.min(leftMove, rightMove);
            if (min == leftMove){
                deque = deque1;
            } else {
                deque = deque2;
            }
            move += min;
        }
        System.out.println(move);
    }

    private static int findIndex(Deque<Integer> deque, int pollIndex, int direction) {
        int move = 0;
        if( direction == 2) {
            while(!deque.isEmpty()){
                Integer poll = deque.poll();
                if (poll != pollIndex) {
                    deque.addLast(poll);
                    move++;
                } else{
                    break;
                }
            }
        }
        if( direction == 3) {
            while(!deque.isEmpty()){
                Integer pop = deque.removeLast();
                if (pop != pollIndex) {
                    deque.addFirst(pop);
                    move++;
                } else{
                    move++;
                    break;
                }
            }
        }
        return move;
    }
}
