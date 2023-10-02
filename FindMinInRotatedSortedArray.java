// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindMinInRotatedSortedArray
{
    class Solution
    {
        int n = 0;

        public int findMin(int[] nums)
        {
            int n = nums.length;
            return binarySearch(nums, 0, n-1);
        }

        public int binarySearch(int[] nums, int low, int high)
        {
            while(low <= high)
            {
                if(nums[low] <= nums[high])
                    return nums[low];

                int mid = low + (high-low)/2;

                if (
                        (mid == 0 || nums[mid] < nums[mid-1]) &&
                                (mid == n-1 || nums[mid] < nums[mid+1])
                )
                {
                    return nums[mid];
                }
                else if(nums[low] <= nums[mid])
                    low = mid +1;
                else
                    high = mid-1;
            }
            return -1;
        }
    }
}
