package Glad.Gold.가지고_노는_1;

public class 가지고_노는_1 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int N = sc.nextInt();
        boolean[] visited = new boolean[N];
        int remainder = 1 % N;
        int length = 1;
        while (!visited[remainder]){
            visited[remainder] = true;
            if(remainder == 0) {
                System.out.println(length);
                return;
            }
            length++;
            remainder = (remainder * 10 + 1) % N;
        }

        // 불가능한 경우
        System.out.println(-1);
    }
}
