// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Approach: The minimum element will have both its neighbours will be less than it and it will also be present on the side that is not sorted
//if both the sides are sorted than the whole array is sorted and the minimum is the first element. If not we search along the unsorted part
//We also check the edge case where the mid will be at the first element or the last in the array. In that case we just return the value at mid.
class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high = nums.length -1;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (nums[low] <= nums[high]) return nums[low];
            if ( (mid == 0 || nums[mid] < nums[mid-1]) && (mid == high || nums[mid] < nums[mid+1])) {
                return nums[mid];
            }else if (nums[mid] >= nums[low]) {
                low = mid+1;
            }else{
                high = mid -1 ;
            }
        }
        return 2355;
    }
}