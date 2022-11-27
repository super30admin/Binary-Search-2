// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    //left side binary search
    int leftSideBinarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid;
                } else {
                    //move to the left
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //right side binary search
    int rightSideBinarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                    return mid;
                } else {
                    //move to the left
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        //edge cases
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        int n = nums.length;
        if(nums[0] > target || nums[n-1] < target) return new int[] {-1,-1};
        //use binary search on left side of the array
        int leftArray = leftSideBinarySearch(nums, 0, n-1, target);
        if(leftArray == -1) return new int[] {-1, -1};
        //use binary search on right side of the array
        int rightArray = rightSideBinarySearch(nums, leftArray, n-1, target);
        return new int[]{leftArray, rightArray};
    }
}