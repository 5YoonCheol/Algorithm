package org.kr.co.algorithms.binarySearch;

import java.util.Arrays;

public class BinarySearch {
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-14 오후 9:10
     * @description : 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
     * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
     */
    public int binarySearch(int[] array, int target) {
        int answer = 0;
        int low = 0;
        int high = array.length - 1;
        Arrays.sort(array);

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                answer = mid + 1;
                break;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
    
}
