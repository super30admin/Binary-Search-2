using System;

namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
            p.FindPeakElement(new int[] { 2, 3, 4, 5, 1});
            p.SearchRange(new int[] { 2, 3, 4, 5, 1});
            p.FindMin(new int[] { 2, 3, 4, 5, 1});
        }
        // Time Complexity: O(log n)
        // Space Complexity: O(1)
        public int FindPeakElement(int[] nums)
        {
            int low = 0;
            int high = nums.Length - 1;
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.Length - 1 || nums[mid] > nums[mid + 1]))
                {
                    return mid;
                }
                else if (mid == 0 || nums[mid] > nums[mid - 1])
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
        // Time Complexity: O(log n)
        // Space Complexity: O(1)
        public int FindMin(int[] nums)
        {
            int low = 0;
            int high = nums.Length - 1;
            while (low <= high)
            {
                if (nums[low] < nums[high]) return nums[low];
                int mid = low + (high - low) / 2;
                if (mid != 0 && nums[mid] < nums[mid - 1])
                {
                    return nums[mid];
                }
                else if (mid != nums.Length - 1 && nums[mid] > nums[mid + 1])
                {
                    return nums[mid + 1];
                }
                else if (nums[low] > nums[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            return nums[0];
        }

        // Time Complexity: O(log n) - tried to reduce the time complexity by reducing the search space when finding the last. 
        // Space Complexity: O(1)
        public int[] SearchRange(int[] nums, int target)
        {
            int low = 0;
            int high = nums.Length - 1;
            int lownext = 0, highnext = 0;
            bool found = false;
            int first = 0;
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target)
                {
                    if (!found)
                    {
                        lownext = mid;
                        highnext = high;
                        found = true;
                    }
                    if (mid == 0 || nums[mid - 1] != target)
                    {
                        first = mid;
                        break;
                    }
                    else
                    {
                        high = mid - 1;
                    }
                }
                else if (nums[mid] > target)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            if (!found) return new int[] { -1, -1 };
            while (lownext <= highnext)
            {
                int mid = lownext + (highnext - lownext) / 2;
                if (nums[mid] == target)
                {
                    if (mid == nums.Length - 1 || nums[mid] != nums[mid + 1])
                    {
                        return new int[] { first, mid };
                    }
                    else
                    {
                        low = mid + 1;
                    }
                }
                else if (nums[mid] > target)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            return new int[] { -1, -1 };
        }
    }
}
