// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindFirstLastIdxInSortedArray
{
    class Solution
    {
        public int[] searchRange(int[] nums, int target)
        {
            if (nums.length == 0)
                return new int[] {-1, -1};
            int firstIdx = binarySearchFirstIndex(nums, 0, nums.length-1, target);
            int secondIdx;
            if (firstIdx == -1)
                return new int[]{-1, -1};
            else
                secondIdx = binarySearchSecondIndex(nums, firstIdx, nums.length-1, target);

            return new int[]{firstIdx, secondIdx};
        }

        public int binarySearchFirstIndex(int[] nums, int low, int high, int target)
        {
            while(low <= high)
            {
                int mid = low + (high-low)/2;
                if(nums[mid] == target)
                {
                    if(mid > 0 && nums[mid-1] == target)
                        high = mid-1;
                    else
                        return mid;
                }
                else if (nums[mid] > target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            return -1;
        }

        public int binarySearchSecondIndex(int[] nums, int low, int high, int target)
        {
            while(low <= high)
            {
                int mid = low + (high-low)/2;
                if(nums[mid] == target)
                {
                    if(mid < nums.length-1 && nums[mid+1] == target)
                        low = mid+1;
                    else
                        return mid;
                }
                else if (nums[mid] > target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            return -1;
        }
    }
}