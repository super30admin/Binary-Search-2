
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class FindPeakElement {
    public int findPeakElement(int[] nums) {

        int left = 0;

        int right = nums.length - 1;

        while(left < right)
        {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[mid + 1]) // If the middle element is smaller than the next element
            {
                left = mid + 1; // Set the left pointer to mid + 1, as the peak must be on the right side
            }

            else
            {
                right = mid; // Otherwise, set the right pointer to mid, as the peak must be on the left side or mid is the peak
            }
        }

        return left; // Return the index of the peak element

    }
}