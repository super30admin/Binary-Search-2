public class Solution
    {
        // Time Complexity : O(log n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int FindPeakElement(int[] nums)
        {
            if (nums == null && nums.Length == 0) return -1;
            int low = 0;
            int high = nums.Length - 1;

            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                //If elements adjacent to mid are lower than mid
                if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.Length - 1 || nums[mid] > nums[mid + 1]))
                {
                    return mid;
                }
                //move to left half of array
                else if (mid > 0 && nums[mid - 1] > nums[mid])
                {
                    high = mid - 1;
                }
               //move to right half
                else
                {
                    low = mid + 1;
                }
            }
            return high;
        }
    }
