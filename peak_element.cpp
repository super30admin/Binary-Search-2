// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// Idea is to go towards higher neighbor of mid to find the peak. 

#include<vector>

class Solution {
public:
    int findPeakElement(std::vector<int>& nums) {
        int n = nums.size();
        int low = 0;
        int high = n - 1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if( (mid == n-1 || nums[mid] > nums[mid+1]) 
              && (mid == 0 || nums[mid] > nums[mid-1]) )
            {
                return mid;
            }
            else if (mid > 0 && (nums[mid] < nums[mid-1])) 
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return 2222;
    }
};