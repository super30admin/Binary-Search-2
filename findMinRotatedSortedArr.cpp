// Time Complexity : O(log n) in worst and avg case, O(1) in best case i.e. when it is sorted in increasing order
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size()-1;
        while(left<=right)
        {
            if(nums[left]<=nums[right])
            {
                return nums[left];
            }
            int mid = left+(right-left)/2;

            if(nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            else if((nums[mid]<nums[right]))
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }

        }
        return 123;
    }
};