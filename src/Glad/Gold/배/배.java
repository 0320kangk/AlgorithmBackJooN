package Glad.Gold.배;

import java.util.*;


public class 배 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String crane = sc.nextLine();
        String[] craneSplit = crane.split(" ");
        List<Integer> cranes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(craneSplit[i]));
        }
        int M = sc.nextInt();
        sc.nextLine();
        String box = sc.nextLine();
        String[] boxSplit = box.split(" ");
        List<Integer> boxesWeights = new ArrayList<>();
        for (int i = 0; i < boxSplit.length ; i++) {
            boxesWeights.add(Integer.parseInt(boxSplit[i]));
        }
        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxesWeights, Collections.reverseOrder());

        if (boxesWeights.get(0) > cranes.get(0)){
            System.out.println(-1);
            return;
        }
        int move = 0;
        while(!boxesWeights.isEmpty()){
            for (int i = 0; i < cranes.size(); i++) {
                for (int j = 0; j < boxesWeights.size(); j++) {
                    if(cranes.get(i) >= boxesWeights.get(j)){
                        boxesWeights.remove(j);
                        break;
                    }
                    if (j == boxesWeights.size() -1){
                        cranes.remove(i--);
                    }
                }
            }
            move++;
        }
        System.out.println(move);
    }
}
