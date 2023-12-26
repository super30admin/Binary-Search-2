// Time Complexity : O(logN+logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Idea is to do binary search on left side and use that left index and do binary search 
// on the right side. 

#include <vector>

// Helper function to search left subarray
int BinarySearchLeft(std::vector<int>& nums, int low, int high, int target)
{
    while(low <= high)
    {
        int mid = low + (high-low)/2;
        if(nums[mid] == target)
        {
            if(mid == 0 || nums[mid] > nums[mid-1])
            {
                return mid;
            }
            else // go left
            {
                high = mid - 1;
            }
        }
        else if(nums[mid] > target)
        {
            // go left to find first occurance
            high = mid - 1;
        }
        else
        {
            // go right to find first occurance
            low = mid + 1 ;
        }
    }
    return -1;
}

// Helper function to search right subarray
int BinarySearchRight(std::vector<int>& nums, int low, int high, int target)
{
    while(low <= high)
    {
        int mid = low + (high-low)/2;
        if(nums[mid] == target)
        {
            if(mid == nums.size()-1 || nums[mid] < nums[mid+1])
            {
                return mid;
            }
            else // go right
            {
                low = mid + 1;
            }
        }
        else if(nums[mid] > target)
        {
            // go left to find first occurance
            high = mid - 1;
        }
        else
        {
            // go right to find first occurance
            low = mid + 1 ;
        }
    }
    return -1;
}

class Solution {
public:
    std::vector<int> searchRange(std::vector<int>& nums, int target) {
        int n = nums.size(); 

        if(n == 0)
        {
            return {-1, -1};
        }

        int left = BinarySearchLeft(nums, 0, n-1, target);
        if(left == -1)
        {
            return {-1,-1};
        }
        int right = BinarySearchRight(nums, left, n-1, target);
        return {left, right};
    }
};