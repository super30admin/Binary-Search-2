// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Approach
 * if the low value is smaller then high, that means our element is at low but if that id not the case
 * we check is mids might me the high lowest by comparing mid -1 and mid + 1 to the mids if that also not the case then
 * we need to eleminate one half of the side how we do that is before we 
 * we check if low it smaller then the mid if that is true that side is sorted and we eleminate that
 * 
 */

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[high]) {
                return nums[low];
            } else if ((mid > 0 && nums[mid - 1] > nums[mid]) && (mid < nums.length - 1 && nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}