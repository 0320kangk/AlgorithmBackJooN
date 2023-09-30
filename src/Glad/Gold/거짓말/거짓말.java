package Glad.Gold.거짓말;

import javax.jws.soap.SOAPBinding;
import java.util.*;

public class 거짓말 {
    static int findParent(int[] parent, int node) {
        if(parent[node] == node){
            return node;
        }
        return findParent(parent, parent[node]);
    }
    static void union(int[] parent, int node1, int node2) {
        int parentNode1 = findParent(parent, node1);//3번에서 시작함
        int parentNode2 = findParent(parent, node2);
        if( parentNode1 < parentNode2)
            parent[parentNode2] = parentNode1;
        else
            parent[parentNode1] = parentNode2;
    }

    public static void main(String[] args) {
        /*
        진실을 알고 있는 사람으 번호의 파티는 제외한다.
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //사람 수
        int M = sc.nextInt(); // 파티 수
        int truePeople = sc.nextInt(); //진실을 아는 사람 수
        Set<Integer> truePeopleSet = new HashSet<Integer>();
        for (int i = 0; i < truePeople; i++) {
            truePeopleSet.add(sc.nextInt()); // 진실을 아는 사 람 번호
        }
        int[] nodes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = i;
        }
        //파티 참가 수
        List<List<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int people = sc.nextInt(); //파티 참가자 수
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < people; j++) {
                int num = sc.nextInt();
                list.add(num);
            }
            for (int j = 0; j < list.size() - 1; j++) {
                union(nodes, list.get(j) ,list.get(j + 1));
            }
            partyList.add(list);
        }
//        System.out.println(Arrays.toString(nodes));
        HashSet<Integer> copySet = new HashSet<>(truePeopleSet);
        for (Integer person : copySet) {
            int parent = findParent(nodes, person);
            for (int i = 1; i <= N; i++) {
                if (findParent(nodes, i) == parent)
                    truePeopleSet.add(i);
            }
        }
//        System.out.println(truePeopleSet);
        int count = 0;
        for (List<Integer> list : partyList) {
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (truePeopleSet.contains(list.get(i))) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                count++;
            }
        }
        System.out.println(count);
    }
}
