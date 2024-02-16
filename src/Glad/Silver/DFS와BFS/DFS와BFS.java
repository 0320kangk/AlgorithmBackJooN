package Glad.Silver.DFS와BFS;

import java.util.*;

public class DFS와BFS {
    static List<List<Integer>> lists;
    static int V;
    static List<Integer> dfsList =  new ArrayList<>();
    static StringBuilder sbBfs = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //정점의 수
        int M = sc.nextInt(); // 간선의 개수
        V = sc.nextInt();
        lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < N + 1; i++) {
            lists.add(new ArrayList<>());
        }
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            String[] sPair = sc.nextLine().split(" ");//두 정점의 간선 번호
            int[] nPair = new int[] {Integer.parseInt(sPair[0]), Integer.parseInt( sPair[1])};
            lists.get(nPair[0]).add(nPair[1]);
            lists.get(nPair[1]).add(nPair[0]);
        }
        for (int i = 1; i < lists.size(); i++) {
            Collections.sort( lists.get(i));
        }
        boolean[] visited = new boolean[N + 1];
        dfs(visited, V);
        StringBuilder sbDfs = new StringBuilder();
        for (int i = 0; i < dfsList.size(); i++) {
            sbDfs.append(dfsList.get(i)).append(" ");
        }
        bfs();
        System.out.println(sbDfs);
        System.out.println(sbBfs);
    }


    static void dfs(boolean[] visited, int point) {
        Stack<Integer> stack = new Stack<>();
        stack.add(point);
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            if (!visited[pop]){
                dfsList.add(pop);
                visited[pop] = true;
                List<Integer> list = lists.get(pop);
                for (int i = list.size() - 1; i >= 0; i--) {
                    Integer v = list.get(i);
                    if(!visited[v]){
                        stack.add(v);
                    }
                }
            }

        }

    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[lists.size() + 1];
        q.add(V);
        visited[V] = true;
        sbBfs.append(V).append(" ");
        while (!q.isEmpty()){
            Integer point = q.poll();
            List<Integer> list = lists.get(point);
            for (int i = 0; i < list.size(); i++) {
                Integer next = list.get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    sbBfs.append(next).append(" ");
                }
            }
        }
    }
}
