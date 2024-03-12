# X_K 문제 풀이

### [문제 링크](https://www.acmicpc.net/problem/1322)

### 문제 풀이
이 문제는 + 연산과 | 연산의 공통점을 찾는 문제이다. </br>
피연산자를 2진수로 변환하여 계산해 보자. </br>
X Y에 대하여 같은 자리수를 + 연산 할 때
1 + 1 = 10,  </br>
1 + 0 = 1,</br>
0 + 1 = 1,  </br>
0 + 0 = 0  </br>
인 것을 볼 수 있다. </br>
| 연산을 해보자. </br>
1 | 1 = 1 </br>
1 | 0 = 1 </br>
0 | 1 = 1 </br>
0 | 0 = 0 </br>
인 것을 볼 수 있다.
위 연산 결과를 비교하면 알 수 있듯이 1 + 1 = 10과 1 | 1 = 1이 결과가 다른 것을 볼 수 있다.</br>
즉 +와 |가 같은 결과를 가지기 위해서는 1과 1의 연산을 피해야 한다는 것을 알 수 있다.
또한 X 가 1 값을 갖는 다면 Y는 무조건 0 값을 가져야 한다. </br>
오직 X가 0일 때만 Y는 0과 1 어떤 값을 갖아도 같은 연산 결과를 갖는다. </br>
우리는 K 번째 작은 Y 를 찾고 있다.  </br>
우선 K를 이진수로 변환하자. </br>
이진수 X와 K를 첫 번째 자리 수 부터 비교하자. </br>
1. X 자리수 값이 0이라면 비교한 K의 자리수의 값을 갖는 이진수 a 를 만들자. </br>
2. 1 이라면  a앞에 0을 붙이자. </br>
각 i의 자리 수에 대하여 위 행동을 반복하면 K 번째 작은 수를 구할 수 있다.</br>


### 소스 코드
```java
public class X_K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int K = sc.nextInt();
        String binary_X = Integer.toBinaryString(X);
        String binary_K = Integer.toBinaryString(K);
        StringBuilder sb = new StringBuilder();
        int i = binary_K.length() - 1;
        int j = binary_X.length() - 1;
        while (i >= 0) {
            if (j < 0 || binary_X.charAt(j) == '0'){
                sb.append(binary_K.charAt(i));
                i--;
            }
            else {
                sb.append(0);
            }
            j--;
        }
        System.out.println(Long.parseLong(sb.reverse().toString(), 2));
    }
}

```