package org.kr.co.algorithms.sort;

public class Sort {
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-07 오후 9:28
     * @description : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     * 정렬하는 방법은 선택정렬입니다.
     */
    public String selectionSort(int a, int[] arr){
        String answer = "";

        for(int i=0; i<arr.length-1; i++){
            int idx = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[idx]){
                    idx = j;
                }
            }
            // 최소값을 찾으면 현재 위치와 교환
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }

        for(int x : arr){
            answer += x + " ";
        }
        return answer;
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-07 오후 9:54
     * @description : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     * 정렬하는 방법은 버블정렬입니다.
     */
    public String bubbleSort(int a, int[] arr){
        String answer = "";

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    // 인접위치와 교환
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for(int x : arr){
            answer += x + " ";
        }
        return answer;
    }

    
}
