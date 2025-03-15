// Time Complexity: O(log N), where N is the number of elements in the array.
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Use binary search to efficiently find a peak element.
// 2. If the middle element is smaller than the next element, the peak must be in the right half.
// 3. Otherwise, the peak lies in the left half or at `mid` itself.
// 4. Continue narrowing the search range until `l` and `r` converge to the peak.

class Solution {
    public int findPeakElement(int[] nums) 
    {
        int l = 0;
        int r = nums.length-1;
        while(l<r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[mid+1])
            {
                l = mid+1;
            }
            else
            {
                r= mid;
            }
        }   
        return l; 
    }
}