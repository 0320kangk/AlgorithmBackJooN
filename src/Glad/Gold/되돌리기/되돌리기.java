package Glad.Gold.되돌리기;

import java.util.*;

public class 되돌리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node[] nodes = new Node[N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String cmd = sc.nextLine();
            String[] s = cmd.split(" ");
            nodes[i] = new Node(s[0], s[1], Integer.parseInt(s[2]));
        }
        Arrays.sort(nodes, (node1, node2) -> {
            return node2.time - node1.time;
        });
        StringBuilder sb = new StringBuilder();
        int time = Integer.MAX_VALUE;
        for (Node node : nodes) {
            if(node.time >= time) continue;
            if(node.type.equals("undo")){
                time = node.time - Integer.parseInt(node.text);
            }else {
                sb.append(node.text);
            }
        }
        System.out.println(sb.reverse());
    }
    static class Node {
        String type;
        String text;
        int time;

        public Node(String type, String text, int time) {
            this.type = type;
            this.text = text;
            this.time = time;
        }
    }

}
