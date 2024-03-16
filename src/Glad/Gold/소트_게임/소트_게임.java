package Glad.Gold.소트_게임;

import java.util.*;

public class 소트_게임 {
    static class Node {
        String seq;
        int cnt;

        public Node(String seq, int cnt) {
            this.seq = seq;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        String[] split = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
        }
        char[] charArray = sb.toString().toCharArray();
        Arrays.sort(charArray);
        String sortSb = new String(charArray);
        System.out.println(bfs(N, K, sortSb, sb.toString()));
    }
    static int bfs(int N, int K, String sortSb, String sequence) {
        LinkedList<Node> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(new Node(sequence, 0));
        while(!q.isEmpty()){
            Node node = q.poll();
            int L = 0;
            int R = K;
            String seq = node.seq;
            if (seq.equals(sortSb)) return node.cnt;
            while(R <= N) {
                String subLeft = seq.substring(0, L);
                String subMid = new StringBuilder().append(seq.substring(L, R)).reverse().toString();
                String subRight = seq.substring(R, N);
                StringBuilder sb = new StringBuilder();
                String nextSeq = sb.append(subLeft).append(subMid).append(subRight).toString();
                if(!set.contains(nextSeq)) {
                    q.add(new Node(nextSeq, node.cnt + 1));
                    set.add(nextSeq);
                }
                L++;
                R++;
            }
        }
        return -1;
    }
}
