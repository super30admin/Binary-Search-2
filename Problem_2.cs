public class Solution
    {
        // Time Complexity : O(log n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int FindMin(int[] nums)
        {
            if (nums == null && nums.Length == 0)
            {
                return -1;
            }

            int low = 0;
            int high = nums.Length - 1;

            while (low <= high)
            {
                //if the whole array is sorted
                if (nums[low] <= nums[high])
                {
                    return nums[low];
                }
                //calculate the middle and check if middle is less than its adjacent elements
                int mid = low + (high - low) / 2;
                if ((mid == 0 || nums[mid] < nums[mid - 1]) && (nums[mid] < nums[mid + 1]))
                {
                    return nums[mid];
                }
                //check if left half is sorted array
                else if (nums[low] <= nums[mid])
                {
                    low = mid + 1;
                }
                //right half is sorted
                else
                {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
