package org.kr.co.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-12 오후 9:24
     * @description : 새 학기가 시작되었습니다. 철수는 새 짝꿍을 만나 너무 신이 났습니다.
     * 철수네 반에는 N명의 학생들이 있습니다.
     * 선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.
     * 제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.
     * 그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.
     * 선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.
     * 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를
     * 차례로 출력하는 프로그램을 작성하세요.
     */
    public String findDiffrence(int a, int[] arr){
        String answer = "";
        int[] orgin = arr.clone();

        Arrays.sort(orgin);

        for(int i=0; i<a; i++){
            if(orgin[i] != arr[i]){
                answer += i+1 + " ";
            }
        }

        return answer.trim();
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-13 오후 8:25
     * @description : N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
     * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
     */
    public void sortPoint(){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        ArrayList<Point> dataList = new ArrayList<>();
        for(int i = 0; i < a; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point data = new Point(x, y);
            dataList.add(data);
        }

        Collections.sort(dataList);
        for(Point point : dataList){
            System.out.println(point.x + " " + point.y);
        }
    }
    
    
}
