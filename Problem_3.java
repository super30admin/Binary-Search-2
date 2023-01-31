// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use binary search here. To find the peak element, we first get mid. If mid is greater than both its neighbors, we return it.
   Else we see which side is greater than mid and move our search to that side until we find the peak. If nums[mid] < nums[mid - 1],
   we move our search to left, so end = mid - 1, else for the right side, start = mid + 1;
*/

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;

        int n = nums.length;

        int start = 0, end = n - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) 
                return mid;
            else if(mid > 0 && nums[mid] < nums[mid - 1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return Integer.MIN_VALUE;
    }
}