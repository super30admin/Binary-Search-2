// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * here, we'll do binary search twice to find fist amd last postion. Binary Search to find first position will be search that :
 * find mid and check if the left adjacent element is same, then shift the high to mid-1. For last position will be search that :
 * find mid and check if the right adjacent element is same, then shift the low to mid+1. If left or right adjacent does't match,
 * then mid is the first and last position respectively.
 */
/
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int low = 0, high = nums.length-1;

        if(nums == null || nums.length == 0)
            return new int[] {-1, -1};

        if(target < nums[0] || target > nums[nums.length-1])
            return new int[] {-1, -1};

        int first = binarySearchFirst(nums, target);

        if(first == -1)
            return new int[]{-1, -1};

        int second = binarySearchSecond(nums, target, first);

        return new int[]{first, second};
    }

    private int binarySearchFirst(int[] nums, int target) {

        int low = 0, high = nums.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                if(mid == low || nums[mid] != nums[mid-1]) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchSecond(int[] nums, int target, int low) {

        int high = nums.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                if(mid == high || nums[mid] != nums[mid+1]) {
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}