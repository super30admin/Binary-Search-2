// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
We compute binary searches for left and right part of array to understand the first and last occurences
We make sure to check if mid value equals to the target element and has a chance of becoming first/last
occurence at validations checks accordingly. If not, we move our high/low positions to left and right
as required to find.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};

        int first = binarySearchFirst(nums, target, 0, nums.length - 1);

        if(first == -1)
            return new int[]{-1, -1};

        int second = binarySearchSecond(nums, target, first, nums.length - 1);
        return new int[]{first, second};
    }

    private int binarySearchFirst(int[] nums, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(target == nums[mid]) {
                if(mid == low || nums[mid] != nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            }
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private int binarySearchSecond(int[] nums, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(target == nums[mid]) {
                if(mid == high || nums[mid] != nums[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            }
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}