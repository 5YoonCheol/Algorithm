package org.kr.co.algorithms.twoPointers;

public class AlgorithmCode {
    /**
     * @author : 5YoonCheol
     * @created : 2024-10-15 오후 9:24
     * @description : 연속 부분수열
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
     * @description : 연속된 자연수의 합
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


    public static void main(String[] args) {
        AlgorithmCode algorithmCode = new AlgorithmCode();

        //실행할 함수 호출
        algorithmCode.numberOfCase(4, 3, new int[]{1,2,3});
        algorithmCode.sumOfConsecutive(15);
    }
}
