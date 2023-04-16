// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
 * We observed that in rotated array, atleast one side of the array is sorted but the minimun element lies in the unsorted part.
 * We can say minimum element is lesser that the left and right element of that element and we return.
 * else we go in left or right side depennfing on the unsorted part.
 */
public class FindMin {
    public int findMin(int[] nums) {
        if(nums == null || nums.length < 1) {
             return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if((mid == low || nums[mid] < nums[mid - 1]) && (mid == high || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
