// Time Complexity : 2(log n) == O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        if(nums == null || nums.length == 0) return new int[] {-1, -1};

        if(nums[0]>target || nums[n-1]<target) return new int[] {-1, -1};

        int start = BinarySearchFirstIndex(nums,target);
        if(start == -1) return new int[] {-1,-1};
        int last = BinarySearchLastIndex(nums, start, target);

        return new int[] {start, last};
    }

    public int BinarySearchFirstIndex(int[] nums,int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid;
                }
                else {
                    //keep moving left
                    high = mid - 1;
                }
            }
            else if(nums[mid]>target) {
                // search left
                high = mid - 1;

            }
            else{
                //search right
                low = mid + 1;

            }
        }
        return -1;
    }

    public int BinarySearchLastIndex(int[] nums,int first, int target) {
        int low = first;
        int high = nums.length - 1;
        int n = nums.length;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == n-1 || nums[mid] < nums[mid+1]) {
                    return mid;
                }
                else {
                    //keep moving right
                    low = mid + 1;
                }
            }
            else if(nums[mid]>target) {
                // search left
                high = mid - 1;

            }
            else{
                //search right
                low = mid + 1;

            }
        }
        return -1;
    }
}