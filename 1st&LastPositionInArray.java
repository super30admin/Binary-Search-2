// Time Complexity : O( logn), n is the length of the array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * Follow Binary search approach. We run the binary search techniques 2 times, once to find the 1st occurance using the left search function.
 * 2nd the last occurance using the right search function.
 * Compare the target to the generated mid and accordingly move to left or right.
 */
class Solution {

    // search to find the 1st occurance
    private int searchLeft(int[] nums, int start, int end, int target) {

        // run binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // check if the mid element is target element. If so check the previous element
            // it should be smaller than mid or else we have tp decrement the end pointer
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    // search to find the last occurance.
    private int searchRight(int[] nums, int start, int end, int target) {

        // run binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // check if the mid element is smaller than next element so check the last
            // occurance of the target element
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }

            else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;

    }

    // main function which willc all the left and right search to find the 1st and
    // last occurance of the target.
    public int[] searchRange(int[] nums, int target) {
        // check for null case
        if (nums.length == 0 || nums == null)
            return new int[] { -1, -1 };

        // check for out of boundary
        if (nums[0] > target || nums[nums.length - 1] < target)
            return new int[] { -1, -1 };

        // call left for 1st and right for last occurance of the target
        int left = searchLeft(nums, 0, nums.length - 1, target);
        int right = searchRight(nums, left, nums.length - 1, target);

        // return the 1st and last index of target element.
        return new int[] { left, right };
    }
}