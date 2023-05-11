package BinarySearchTwo;

import java.util.Arrays;
public class FirstnLastPositionEleArr {
    public int bsFirst(int[] arr, int target, int left, int right){

        while(left <= right){
            int mid = left + (right - left)/ 2;

            if(arr[mid] == target){
                if(mid == left || arr[mid-1] < arr[mid]) // mid = left or 0 + ...
                    return mid;
                else
                    // keep moving left as first occurence is left to the mid
                    right = mid - 1;
            }

            else if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        // not found
        return -1;

    }

    public int bsLast(int[] arr, int target, int left, int right){

        while(left <= right){
            int mid = left + (right - left)/ 2;

            if(arr[mid] == target){
                if(mid == right || arr[mid] < arr[mid+1])  // mid = right or arr.length - 1 + ....
                    return mid;
                else
                    // keep moving right as last occurence is right to the mid
                    left = mid + 1;
            }

            else if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        // not found
        return -1;

    }
    public int[] searchRange(int[] nums, int target) {

        int l = nums.length;

        // null case
        if(nums == null || l == 0)
            return new int[] {-1, -1};

        // target out of nums range
        if(target < nums[0] || target > nums[l-1])
            return new int[] {-1, -1};

        // first occurence
        int firstOccurence = bsFirst(nums, target, 0, l-1);  //logn
        if (firstOccurence == -1)
            return new int[] {-1, -1};

        // last occurence
        int lastOccurence = bsLast(nums, target, firstOccurence, l-1); //logn
        return new int[] {firstOccurence, lastOccurence};
    }

    public static void main(String[] args){

        FirstnLastPositionEleArr object = new FirstnLastPositionEleArr();
        int[] searchArray = {5,7,7,8,8,10};

        // array = {5,7,7,8,8,10}, target = 8
        int[] result = object.searchRange(searchArray, 8);

        System.out.println("result =" + Arrays.toString(result));
    }

}