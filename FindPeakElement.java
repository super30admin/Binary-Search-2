// The approach to this problem is to understand the fact that the peak is easier to find, when we move towards the side, where the neighbour is greater than
// the current element. Perform binary search on to that side until we end up with the element that matches the peak condition.

// Time Complexity  - O(logn)
// Space Complexity - O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low)/2;

            // Check if the mid element is the peak
            if((mid == low || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid+1] > nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }

        }
        return -1;
    }
}