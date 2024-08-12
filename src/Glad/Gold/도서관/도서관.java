package Glad.Gold.도서관;

import java.util.*;

public class 도서관 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> minorList = new ArrayList<>();
        List<Integer> plusList = new ArrayList<>();
        sc.nextLine();
        String[] points = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(points[i]);
            if(p < 0) {
                minorList.add(p);
            }else{
                plusList.add(p);
            }
        }
        Collections.sort(minorList, Collections.reverseOrder());
        Collections.sort(plusList);
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        //먼저 처리할 list 정하기
        if( !plusList.isEmpty()&&
                !minorList.isEmpty() &&
                Math.abs( plusList.get(plusList.size()- 1)) >= Math.abs( minorList.get( minorList.size() -1))){
            firstList = minorList;
            secondList = plusList;
        } else if(!plusList.isEmpty()&&
                !minorList.isEmpty() &&
                Math.abs( plusList.get(plusList.size()- 1)) < Math.abs( minorList.get(minorList.size() -1))) {
            firstList = plusList;
            secondList = minorList;
        }else if ( plusList.isEmpty()){
            firstList = minorList;
        } else if(minorList.isEmpty()) {
            firstList = plusList;
        }
        int walking = 0;
        //11 *2 + 78 + 58
        //firstList 는 가정 먼곳 부터 가야함, second가 있다는 가정
        if(!secondList.isEmpty()) {
            // 가장 먼곳 탐방
            int destination = firstList.size() - 1;
            walking += calWalking(firstList, M, destination);

            //한번에 나를 수 있는 가장 먼 곳 구역 제외하고 나머지는 위와 똑같이
            destination = secondList.size() - 1 - M;
            walking += calWalking(secondList, M,  destination );
            walking += Math.abs(secondList.get(secondList.size() - 1));
        }else {
            int destination = firstList.size() - 1 - M;
            walking += calWalking(firstList, M,  destination );
            walking += Math.abs(firstList.get(firstList.size() - 1));
        }
        System.out.println(walking);
    }
    private static int calWalking(List<Integer> bookList, int M, int destination) {
        int walking = 0;
        while (destination >= 0) {
            walking += Math.abs( bookList.get(destination) ) * 2;
            destination -= M;
        }
        return walking;
    }
}
