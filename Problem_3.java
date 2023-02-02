// 162. Find Peak Element
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : In the base case(line 20) why we are checking mid==0 and mid==-1


// Approach
// while applying the binary search, we have to also check whether the mid indexed element is greater thsn its previous index anf next index element.

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n -1 || nums[mid+1] < nums[mid]))
                return mid;
            else if(mid > 0 && nums[mid] < nums[mid -1])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}