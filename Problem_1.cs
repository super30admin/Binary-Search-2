public class Solution
    {
        // Time Complexity : O(log n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        public int[] SearchRange(int[] nums, int target)
        {
            if (nums == null || nums.Length == 0) return new int[] { -1, -1 };
            int n = nums.Length;
            int low = 0;
            int high = n - 1;

            //First index
            int firstIndex = BinarySearchFirstIndex(nums, low, high, target);
            if (firstIndex == -1)
            {
                //did not find the target
                return new int[] { -1, -1 };
            }
            //Last index
            int lastIndex = BinarySearchLastIndex(nums, firstIndex, high, target);

            return new int[] { firstIndex, lastIndex };
        }

        public int BinarySearchFirstIndex(int[] nums, int low, int high, int target)
        {
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                //check if target is the mid
                if (nums[mid] == target)
                {
                    //check if mid is the first index
                    if (mid == 0 || nums[mid] > nums[mid - 1])
                    {
                        return mid;
                    }
                    else
                    {
                        //keep going left
                        high = mid - 1;
                    }
                }
                else if (nums[mid] > target)
                {
                    //left array
                    high = mid - 1;
                }
                else
                {
                    //right array
                    low = mid + 1;
                }
            }
            return -1;
        }

        public int BinarySearchLastIndex(int[] nums, int low, int high, int target)
        {
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                //check if target is the mid
                if (nums[mid] == target)
                {
                    //check if mid is the first index
                    if (mid == nums.Length - 1 || nums[mid] < nums[mid + 1])
                    {
                        return mid;
                    }
                    else
                    {
                        //keep going right
                        low = mid + 1;
                    }
                }
                else if (nums[mid] > target)
                {
                    //left array
                    high = mid - 1;
                }
                else
                {
                    //right array
                    low = mid + 1;
                }
            }
            return -1;
        }
    }
