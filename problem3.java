// Time Complexity : O(log n) as we reduce the search space by half in every iteration.
// Space Complexity : O(1) as no extra space is used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Whenever we find an element mid, which is greater than its neighbours, we return it as a peak element.
// If mid's left neighbour is greater than mid, then there is at least one peak on left side so we move to the left side.
// Same for the right side. This is because - if neighbore is greater, then either the other neighour is greater than it or lower, if lower then current neighbour is a peak, if greater then we can keep moving till we reach the end and we can return it because nums[-1] = nums[n] = -∞.

class Solution {
    public int findPeakElement(int[] nums) {
		if(nums.length == 1) return 0; 
        int n = nums.length;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        int start = 1;
        int end = n-2;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
        }
        return -1; 
    }
}