// 34. Find First and Last Position of Element in Sorted Array
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// We should consider doing separate binary search for first and last elements, because for finding first occurence we keep doing binary search in left half when we encounter mid that is same as mid-1 element.
// We should not iterate linearly towards left and right after finding mid that is equal to target because time complexity will icrease to O(n).

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = first(nums, 0, nums.length - 1, target);
        int right = second(nums, 0, nums.length - 1, target);

        return new int[] {left,right};
    }

    public int first(int[] nums, int low, int high, int target) {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if( mid == low ||  nums[mid - 1] < nums[mid]) return mid;
                    // still go left
                else high = mid - 1;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return -1;
    }

    public int second(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == high || nums[mid + 1] > target) return mid;
                    // still go right
                else low = mid + 1;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return -1;
    }
}