// Approach:
// We use binary search to keep cutting the search area in half until we find the smallest element.
// At each step, we compare the middle element to the rightmost element: if mid > right, the smallest must be to the right of mid, otherwise it’s at mid or to the left.
// We repeat this until left and right meet, and that position holds the minimum value.

// Time Complexity : O(log n)  
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No  

class Solution2{
    public int findMin(int[] nums) {
        int left = 0;                  // start of the array
        int right = nums.length - 1;   // end of the array

        // narrow down until left meets right
        while (left < right) {
            // find the middle spot
            int mid = left + (right - left) / 2;

            // if the middle number is bigger than the end number,
            // the smallest must be after mid
            if (nums[mid] > nums[right]) {
                left = mid + 1;  // toss out left half including mid
            } else {
                // otherwise, the smallest is at mid or before
                right = mid;     // keep mid in the search
            }
        }

        // left and right have converged on the smallest element
        return nums[left];
    }
}
