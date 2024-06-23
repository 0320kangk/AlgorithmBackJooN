# 세준수 풀이

### [문제 링크](https://www.acmicpc.net/problem/1418)

### 문제 풀이
이 문제는 에라토스테네스의 체를 이용하여 푸는 문제이다. </br>
에라토스테네스의 체를 이용하여 각 배열의 값에 소수의 최댓값을 넣는다.  </br>
만약 K값이 배열의 값보다 크거나 같다면 K-세준수를 만족하는 것이다. </br>
### 소스 코드
```java
public class K_세준수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N + 1];
        //false는 소수
        //true는 소수가 아닌 수
        for (int i = 2; i <= N; i++) {
            if(arr[i] != 0) continue;
            for (int j = 1; i*j <= N; j++) {
                arr[i*j] = i;
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
           if(K >= arr[i]) count++;
        }
        System.out.println(count);
    }
}

```