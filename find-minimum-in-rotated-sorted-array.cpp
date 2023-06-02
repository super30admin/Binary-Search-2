// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
  
using namespace std;


class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() == 0) return -1;
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[low] <= nums[high]) return nums[low];
            else if ((mid == 0 || nums[mid] < nums[mid - 1]) 
                && (nums[mid] < nums[mid + 1] || mid == nums.size() - 1)){
                    return nums[mid];
                } 
            else if(nums[low] <= nums[mid]){
                // left is sorted
                low = mid + 1;
            }
            else{
                // right is sorted
                high = mid - 1;
            }
        }
        return -1;
    }
};
