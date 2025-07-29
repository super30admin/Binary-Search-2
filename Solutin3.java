// Approach:
// We treat the array like a series of uphills and downhills and use binary search to find a peak.
// If the middle point is lower than the element to its right, a peak must be on the right side, otherwise it’s on the left or at mid.
// We keep shrinking our range until left and right meet at a peak index.

// Time Complexity : O(log n)  
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No  

class Solution3 {
    public int findPeakElement(int[] nums) {
        int left = 0;                 
        int right = nums.length - 1;  

        while (left < right) {
            // pick the middle spot
            int mid = left + (right - left) / 2;
            
            // if mid is less than its right neighbor, the peak is to the right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;  // toss out the left side, including mid
            } else {
                // otherwise, the peak is at mid or to the left
                right = mid;     // keep mid in the search
            }
        }

        // left and right have converged on a peak
        return left;
    }
}
