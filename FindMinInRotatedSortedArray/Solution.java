// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Here check if the left and right adjacent element are greater than the mid element. If yes, then it is the minimum.
 * If no, then move low to mid+1 if nums[mid] >= nums[low], else move high to mid-1
 */
class Solution {
    public int findMin(int[] nums) {

        int low = 0, high = nums.length-1;

        while(low <= high) {
            if(nums[low] <= nums[high])
                return nums[low];

            int mid = low + (high-low)/2;

            if((mid == low || nums[mid] < nums[mid-1]) && (mid == high || nums[mid] < nums[mid + 1]))
                return nums[mid];
            else if(nums[mid] >= nums[low])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return 93894;
    }
}