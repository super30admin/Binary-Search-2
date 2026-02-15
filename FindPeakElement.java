// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
We implement binary search by checking if value at mid is greater than previous value and also next index's
value by making sure of edge case checks. If so, we return the index of mid, if not, we move low and high
indices accordingly.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1]))
                return mid;
            else if(nums[mid + 1] > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}