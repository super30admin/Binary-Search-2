// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I have created two helper methods - one performs binary search to find the index of first occurrence of the element. If element is not
found, it returns {-1,-1} as the result, else it stores the index of first occurrence of element as the first element of the result
array. The right binary search is performed if the element exists in the array and optimizes on the search space by only searching
for the element from the index of the first occurrence in the array to the last element
*/

public class Solution
{
    public int[] SearchRange(int[] nums, int target)
    {
        int[] result = new int[] { -1, -1 };

        result[0] = LeftBinarySearch(nums, target);

        if (result[0] == -1)
        {
            return result;
        }

        result[1] = RightBinarySearch(nums, target, result[0]);

        return result;
    }

    public int LeftBinarySearch(int[] nums, int target)
    {
        int low = 0, high = nums.Length - 1;

        int result = -1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
            {
                result = mid;
                high = mid - 1;
            }

            else if (nums[mid] < target)
            {
                low = mid + 1;
            }

            else
            {
                high = mid - 1;
            }
        }

        return result;
    }

    public int RightBinarySearch(int[] nums, int target, int low)
    {
        int high = nums.Length - 1;
        int result = low;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
            {
                result = mid;
                low = mid + 1;
            }

            else if (nums[mid] > target)
            {
                high = mid - 1;
            }
        }

        return result;
    }
}