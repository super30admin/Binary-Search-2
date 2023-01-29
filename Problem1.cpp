// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution
{
public:
    int lowForLast = -1;
    int binarySearchFirst(vector<int> &nums, int target)
    {
        int low = 0;
        int high = nums.size() - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                // checking for the first pos of target
                if (mid == 0 || nums[mid] > nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            }
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    int binarySearchLast(vector<int> &nums, int target)
    {
        // optimization to search from the first occurence rather than starting search from the first index
        int low = lowForLast;
        int high = nums.size() - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                // checking for the last pos of target
                if (mid == nums.size() - 1 || nums[mid] < nums[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            }
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    vector<int> searchRange(vector<int> &nums, int target)
    {
        // null
        if (nums.size() == 0)
            return vector<int>{-1, -1};
        // checking whether target exists in the given range
        if (nums[0] > target || nums[nums.size() - 1] < target)
            return vector<int>{-1, -1};
        int first = binarySearchFirst(nums, target);
        if (first == -1)
            return vector<int>{-1, -1};
        lowForLast = first;
        int last = binarySearchLast(nums, target);
        return vector<int>{first, last};
    }
};