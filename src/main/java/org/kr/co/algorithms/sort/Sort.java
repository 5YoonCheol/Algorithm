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

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-07 오후 10:00
     * @description : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     * 정렬하는 방법은 삽입정렬입니다.
     */
    public String insertionSort(int a, int[] arr){
        String answer = "";

        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;
            // 요소를 오른쪽으로 이동
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j=j-1;
            }
            // 키 값을 적절한 위치에 삽입
            arr[j+1] = key;
        }

        for(int x : arr){
            answer += x + " ";
        }
        return answer;
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-07 오후 10:22
     * @description : 삽입정렬 다른 풀이
     */
    public String insertionSort2(int a, int[] arr){
        String answer = "";

        for(int i=1; i<arr.length; i++){
            int tmp = arr[i];
            int j;
            for(j=i-1; j>=0; j--){
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
        }

        for(int x : arr){
            answer += x + " ";
        }
        return answer;
    }


}
