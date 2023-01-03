// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution
{
public:
    int findPeakElement(vector<int> &nums)
    {
        // use BS and move towards the higher element if mid is not the peak
        int low = 0;
        int high = nums.size() - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            // take care of the edge cases ie pos of mid
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if (mid > 0 && nums[mid] < nums[mid - 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
};