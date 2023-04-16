// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
 * As we need to right algorithm in O(logn) We try to implement binary search  where we check if mid element is greater than both the side,
 * then we return mid. Else we know mid element is lesser than one on right or left element and we traverse to the side which has higher values
 * or return -1 if not found.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length < 1) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((mid == low || nums[mid - 1] < nums[mid]) && (mid == high || nums[mid] > nums[mid + 1])) {
                return mid;
            } if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
