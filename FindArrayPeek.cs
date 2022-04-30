using System;
namespace Algorithms
{
    public class FindArrayPeek
    {
        /// Time Complexity : O(log(n))
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Refered Online

        public int FindPeakElement(int[] nums)
        {
            int low = 0, high = nums.Length - 1;
            int mid;
            while (low < high)
            {
                mid = low + (high - low) / 2;
                if (nums[mid] > nums[mid + 1])
                {
                    high = mid;
                }
                else
                {
                    low = mid + 1;
                }
            }
            return low;

        }
    }
}
}
