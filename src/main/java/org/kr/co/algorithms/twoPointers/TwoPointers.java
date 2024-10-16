package org.kr.co.algorithms.twoPointers;

public class TwoPointers {
    /**
     * @author : 5YoonCheol
     * @created : 2024-10-15 오후 9:24
     * @description : N개의 수로 이루어진 수열이 주어집니다.
     * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
     */
    public int numberOfCase(int n, int m, int[] arr){
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < n; rt++){
            sum += arr[rt];
            if(sum == m){ answer ++; }
            while(sum >= m){
                sum -= arr[lt++];
                if(sum == m){ answer ++; }
            }
        }
        return answer;
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-10-16 오후 8:53
     * @description : N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
     */
    public int sumOfConsecutive(int n){
        int answer = 0;
        int sum = 0;
        int lt = 0;
        /*
        1부터 시작하는 연속되는 자연수의 합
        n을 2로 나눈 몫+1 까지만 반복해주면 됨
        (ex. n=15 일 때, 8부터 연속된 자연수들의 합은 무조건 15를 초과하기 때문)
        */
        for(int rt=1; rt<=n/2+1; rt++){
            sum += rt;
            if(sum == n){answer++;}
            //n 이상이 될 경우 맨 앞 자연수를 하나씩 밀면서 빼준다.
            while(sum >= n){
                sum -= ++lt;
                if(sum == n){answer++;}
            }
        }

        return answer;
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-10-16 오후 10:26
     * @description : N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
     * sumOfConsecutive의 다른 풀이이다.
     */
    public int otherSumOfConsecutive(int n){
        int answer = 0;
        int cnt = 1;
        /*
        n=15 일 때 수학적으로 15 - (1 + 2) % 2 == 0 인 경우 12/2 의 몫인 6을 1,2에 각각 더해줘서 7+8 = 15가 된다.
        같은 방법으로 15 - (1+2+3) % 3 == 0 인 경우 9/3 의 몫인 3을 1,2,3에 각각 더해주면 4+5+6 = 15가 된다.
        (1+2), (1+2+3)에서의 자연수의 개수가 cnt이고 최초에 n--를 하는 이유는 (1+2), (1+2+3)과 같이 1은 무조건 빼고 시작해야하기 때문이다.
        */
        n--;
        while(n > 0){
            cnt++;
            n = n - cnt;
            if(n % cnt == 0) answer++;
        }

        return answer;
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-10-16 오후 9:28
     * @description : 0과 1로 구성된 길이가 N인 수열이 주어집니다.
     * 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
     * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
     */
    public int maxLengthSequence(int n, int m, int[] arr){
        int answer = 0;
        int length = 0;
        int max = 0;
        int lt = 0;

        //배열 크기만큼 반복
        for(int rt = 0; rt < n; rt++){
            // 0과 1로만 이루어진 배열 이므로 0일 때 1로 변경 한다는 가정 하에 max 값 증가, 길이 증가
            if(arr[rt] == 0){
                length++;
                max++;
            }
            //1인 경우 length 증가
            length += arr[rt];

            //max의 크기가 m을 넘어설 경우. 즉 m=3일 경우
            if(max > m){
                //m=3 인데 길이가 1 증가했으므로 다시 길이를 1 줄이고
                length--;

                // 정답보다 길이가 길 경우 정답을 변경
                answer = Math.max(answer, length);
                //이후 길이와 max를 초기화 시키고 시작항을 1증가 시켜서 다시 반복
                length = 0;
                max = 0;
                lt++;

                /*
                rt = lt로 했을 경우
                rt가 1이면 다시 반복이 시작될 때 rt++ 에 의해 1이 증가함.
                ex) 최초 lt=0 lt++로 인해 lt=1 => rt=1인데 반복문이 다시 시작할 때 rt++에 의해 rt=2가 된다.
                때문에 1을 빼준다.
                */
                rt=lt-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TwoPointers twoPointers = new TwoPointers();

        //실행할 함수 호출
        twoPointers.numberOfCase(4, 3, new int[]{1,2,3,4});
        twoPointers.sumOfConsecutive(15);
        twoPointers.maxLengthSequence(14, 2, new int[]{1,1,0,0,1,1,0,1,1,0,1,1,0,1});
    }
}
