# RGB 거리 풀이


### [문제 링크](https://www.acmicpc.net/problem/1149)


### 문제 풀이
이 문제는 dp를 이용하여 푸는 문제이다. 집의 개수 N과 색 개수 3에 맞는 배열 valeus[N][3], dp[N][3]을 만든다.</br>
values[N][3] 은 각 집을 칠하는데 필요한 비용을 갖는다.</br> 
dp[i][j] 는 (dp[i-1][j], dp[i-1][1], dp[i-1][2]) 중 에서 values[i][j] 과 더한 값이 가장 작은 값이 된다.</br>
물론 같은 색깔을 더하는 경우는 제외한다. </br>
결국 한 색깔의 비용에 대하여 다른 색깔과 더했을 때 가장 작은 값을 dp[i][j]에 넣어 계산하는 방법이다. </br>
### 소스 코드
```java

public class RGB거리 {
    static int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] values = new int[N][3];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            for (int j = 0; j < 3; j++) {
                values[i][j] = Integer.parseInt(split[j]);
            }
        }
        int[][] dp = new int[N][3];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MAX);
        }
        for (int i = 0; i < 3; i++) {
            dp[0][i] = values[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < values[0].length; k++) {
                    if(k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + values[i][j]);
                }
            }
        }
        int min = MAX;
        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[dp.length - 1][i], min);
        }
        System.out.println(min);
    }
}

```