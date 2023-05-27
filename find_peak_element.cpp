/*
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
How to decide which half of the array to choose to find the peak


// Your code here along with comments explaining your approach in three sentences only
We divide the array into a subarray of equal half
check if peak is present at the center if not 
we move to the subarray whose adjacent value to mid are greater than it . 
This is  becaue it will take us to a maxima as at 0 and n the val is -inf

*/


#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int vec_len{static_cast<int>(nums.size())};
        if(vec_len == 1){
            return 0;
        }
        int low{0};
        int high{vec_len-1};
        
        while (low <=high) {
            int mid {low + (high - low) / 2};
            if((mid == vec_len-1 || nums[mid]>nums[mid+1]) && (mid == 0 || nums[mid]>nums[mid-1])){
                return mid;
            }
            if (mid<vec_len-1 && nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
       
        return -1;
    }
};