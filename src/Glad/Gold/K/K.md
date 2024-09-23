# K 풀이

### [문제 링크](https://www.acmicpc.net/problem/1549)

### 문제 풀이
이 문제는 누적 합과 브루트 포스 알고리즘 문제이다. </br>
A[i] 에 대한 누적 합을 갖는 sumA[i + 1] 배열을 정의한다.  </br>
이 배열은 A[0] 부터 A[i] 의 합이 sumA[i+1] 과 같다. </br>
S(i, k) =sumA[i + k] - sumA[i] 와 같다.   </br>
K의 최댓값은 1/N 이 된다. </br>
두 S가 겹치지 않기 위해서는 K는 1/N 보다 커질 수 없다.  </br>
K=1, i=k, j=k+1 이라 하면 </br>
abs(s(i, k) - s(j, k)) = sum[i] - sum[i-k] - sum[j] - sum[j-k] </br>
위와 같은 식을 이용한 브루트 포스 알고리즘을 만들어 최솟값을 찾는다.</br>

### 소스 코드

```java
public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strA = sc.nextLine().split(" ");
        long[] sumA = new long[n + 1];
        for (int i = 1; i < sumA.length; i++) {
            sumA[i] = Integer.parseInt(strA[i-1]) + sumA[i - 1];
        }
        long min = 1000000000L * 3000;

        int K = 0;
        for (int k = 1; k <= n/2; k++) { 
            for (int i = k; i <= n; i++) { 
                for (int j = i + k; j <= n; j++) {
                    long result = Math.abs((sumA[i] - sumA[i-k]) - (sumA[j] -sumA[j-k]));
                    if(min >= result){
                        min = result;
                        K = k;
                    }
                }
            }
        }
        System.out.println(K);
        System.out.println(min);
    }
}

```