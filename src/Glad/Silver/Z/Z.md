# Z 풀이


### [문제 링크](https://www.acmicpc.net/problem/1074)

### 문제 풀이
이 문제는 재귀 함수를 이용하여 푸는 문제이다. </br>
2^N * 2^N 2차원 배열의 한 변의 길이는 2^N이 된다.</br>
이 배열은 4등분 한 후에 재귀적으로 방문한다.</br>
이 4등분 한 부분을 1,2,3,4 사 분면이라 하자.</br>
r행 c열의 위치를 p라 하자.</br>
2차원 배열을 4등분 한 후 p가 어떤 사분면에 위치하는지 확인한다.</br>
p가 만약 x 사분면에 포함된 다면 [1, x-1] 사분면의 부분을 먼저 탐색해야 한다.</br>
그런 후 x 사분면의 부분을 다시 4등분 하여 탐색하는 재귀 형식으로 탐색한다.</br>
자세한 내용은 코드를 확인하자.</br>

### 소스 코드
```java

public class Z {

    static int visit = 0; //방문 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        partition(r, c, (int)Math.pow(2,N));
        System.out.println(visit);
    }
    /**
     * 
     * @param r size 배열 기준의 r행
     * @param c size 배열 기준의 c행
     * @param size 배열 크기
     */
    public static void partition(int r, int c, int size) {
        if(size == 1)
            return;
        int partSize = size / 2;//4등분 한 배열의 길이
        
        if ( r < partSize && c < partSize){  // 1사분면
            partition(r,c,partSize);
        } else if (r < partSize && c >= partSize) {  // 2사분면
            visit += size * size / 4; 
            partition(r,c-partSize,partSize);//2사분면 기준의 c 위치는 c-partSize
        } else if (r >= partSize && c < partSize ){  // 3사분면
            visit += (size * size / 4) * 2;
            partition(r-partSize, c, partSize); //3사분면 기준의 r 위치는 r-partSize
        } else if (r >= partSize && c >= partSize){  // 4사분면
            visit += (size * size / 4) * 3;
            partition(r-partSize, c-partSize, partSize);
        }

    }

}

```