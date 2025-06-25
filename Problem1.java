/*
 * TC: O(log(n))
 * SC: O(1)
 * Wrote two separate functions which would find the first and last element respectively 
 * using Binary Search, and return a new list[first,last]. If not found it returns [-1,-1]
 * 
 * 
 */

import java.util.Arrays;

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if (nums == null || nums.length == 0)
            return new int[]{-1,-1};
        int first = firstOccurrence(nums, low, high, target);
        int last = lastOccurrence(nums, low, high, target);
        return new int[] { first, last };
    }

    int firstOccurrence(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2; //to prevent int overflow

            if (target == nums[mid]) {
                if (mid != 0 && nums[mid - 1] == target) {
                    high = mid - 1;
                } else
                    return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1; //if the target is not found return -1
    }

    int lastOccurrence(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2; //to prevent int overflow

            if (target == nums[mid]) {
                if (mid != (nums.length - 1) && nums[mid + 1] == target) {
                    low = mid + 1;
                } else
                    return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1; //if the target is not found return -1
    }

    public static void main(String[] args){
        int nums[] = {5,7,7,8,8,10};
        Problem1 p = new Problem1();
        System.out.println(Arrays.toString(p.searchRange(nums, 8)));
    }
}