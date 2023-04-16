// Time Complexity : O(2logN) =~ O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
 * We figured out that moving lenearly after binary search may cause O(n) in worst case, 
 * and thus we can have two separate binary search to find first and last occurence. 
 * binarySearchLeft: if we mid element is equal to target and is not equalt to mid - 1, we found our first occurence and return, else we go left.
 * if target > mid element we go right, else go left. 
 * binarySearchRight: if we mid element is equal to target and is not equalt to mid + 1, we found our last occurence and return, else we go right.
 * if target > mid element we go right, else go left. 
 */

class SearchFirstLastRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length < 1) {
            return new int[]{-1,-1};
        }
        int low = 0;
        int high = nums.length - 1;
        int first = binarySearchLeft(low, high, nums, target);
        if(first == -1) {
            return new int[]{-1,-1};
        }
        int last = binarySearchRight(low, high, nums, target);
        return new int[]{first, last};
    }

    private int binarySearchLeft(int low, int high, int[] nums, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == low || nums[mid-1] != nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
            if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchRight(int low, int high, int[] nums, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == high || nums[mid+1] != nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                } 
            }
            if(target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
