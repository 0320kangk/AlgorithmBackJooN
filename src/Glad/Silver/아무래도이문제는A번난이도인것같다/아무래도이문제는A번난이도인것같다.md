# 아무래도이문제는A번난이도인것같다 풀이

### [문제 링크](https://www.acmicpc.net/problem/1402)

### 문제 풀이
이 문제는 문제의 조건을 잘 확인해야 하는 문제이다. </br>
문제의 조건을 잘 보면 a(i)는 정수이다.  </br><
즉 -1과 1도 가능하다는 것이다. </br>
ai가 -1과 1도 가능하다는 것은 어떤 수도 A에서 B로 변할 수 있다는 것이다. </br>
A = 6, B= 5 이라 해보자 </br>
A = -1 * -1 * 1 * 6 = 6 이다. </br>
-1 + -1 + 1 + 6 = 5 이다.  </br>
A에 -1 혹은 1을 곱하여 만들고자 하는 모든 정수를 만들 수 있으므로 모든 입력에 대하여 "yes"를 출력하면 된다. </br>


### 소스 코드
```java
public class 아무래도이문제는A번난이도인것같다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
           System.out.println("yes");
        }

    }
}
```