# Contact 풀이

### [문제 링크](https://www.acmicpc.net/problem/1013)


### 문제풀이
이 문제는 정규표현식을 이용하여 푸는 문제이다. </br>
이 문제에서 주어진 '+', 와 '|' 는 정규 표현식의 기호와 같은 역할을 한다. </br>
즉 패턴 (100+1+ | 01)+ 은 정규 표현식과 같다고 볼 수 있다. </br>
주어진 문자들을 정규표현식을 통해 구별하자. </br>


## 소스 코드
```java
public class Contact {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("(100+1+|01)+");
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            String inputPattern = sc.next();
            Matcher matcher = compile.matcher(inputPattern);
            if (matcher.matches())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

```