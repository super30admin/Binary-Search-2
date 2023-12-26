// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// The idea is to search the unsorted portion for the min value. We check for it and go left/right
// based on it.

#include <vector>
class Solution {
public:
    int findMin(std::vector<int>& nums) {
        int low = 0;
        int n = nums.size();
        int high = n-1;
        while(low <= high)
        {
            // if array is sorted return low
            if(nums[low] <= nums[high])
            {
                return nums[low];
            }

            int mid = low + (high - low)/2;
            // if mid leement is less than its neighbors then return mid
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n-1 || nums[mid] < nums[mid+1]))
            {
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]) // left side sorted
            {
                low = mid + 1 ;
            }
            else
            {
                high = mid - 1;
            }
        }
        return 2222;
    }
};