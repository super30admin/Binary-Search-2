// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes , took lots of time

// Your code here along with comments explaining your approach
//In a rotated sorted array, one side is always sorted at any given point. So the idea is to go to the unsorted side to find the minimum 
//We keep doing this, until our low pointer reaches the min.

class Solution {
public:
    int findMin(vector<int>& nums) 
    {
        int low =0;
        int high = nums.size()-1;
        while(low<high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid]>nums[high])
                low = mid+1;
            else 
                high = mid;
        }
        return nums[low];
    }
};
