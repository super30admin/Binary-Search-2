// Time Complexity: O(log N), where N is the number of elements in the array.
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Use binary search to find the minimum element in the rotated sorted array.
// 2. If the middle element is greater than the rightmost element, the minimum must be in the right half.
// 3. Otherwise, the minimum is in the left half or is the middle element itself.
// 4. Continue narrowing the search range until the left and right pointers converge to the minimum.

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r)
        {
            int mid =  l + (r-l)/2;
            if(nums[mid]>nums[r])
            {
                l = mid+1;
            }
            else
            {
                r= mid;
            }
        }
        return nums[l];
    }
}