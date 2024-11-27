package org.kr.co.algorithms.recursion;

public class Recursion {
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-21 오후 10:07
     * @description : 자연수 N이 입력되면 N까지의 모든 자연수를 재귀함수를 사용해서 출력하는 프로그램을 작성하세요.
     */
    public void DFS(int n) {
        if(n==0) return;
        else{
            DFS(n-1);
            System.out.print(n + "");
        }
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-21 오후 10:11
     * @description : 자연수 N이 입력되면 N을 이진수로 출력하는 프로그램을 작성하세요. 단 재귀함수를 사용해야 합니다.
     */
    public void DFS2(int n) {
        if(n==0) return;
        else{
            DFS2(n/2);
            System.out.print(n%2 + "");
        }
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-27 오후 7:15
     * @description : 자연수 N이 입력되면 N팩토리얼의 결과 값을 출력하는 프로그램을 작성하세요.
     */
    public int Factorial(int n) {
        if(n==1) return 1;
        else return n*Factorial(n-1);
    }
}
