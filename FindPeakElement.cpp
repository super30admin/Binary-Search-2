// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes , took lots of time

// Your code here along with comments explaining your approach
// The peak can be the middle 
// The peak can be to the right of the middle -> move low to mid+1
// The peak can be to the left of the middle --> Move high to md - 1

//Base cases if only element - return that index
// If first element > second element - return first element as peak
// If last element > second last element - return last element as peak

class Solution {
public:
    int findPeakElement(vector<int>& nums) 
    {
        int size = nums.size();
        if(size==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[size-1]>nums[size-2]) return size-1;
        
        int low = 1;
        int high = size-2;
      
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]) return mid;
            else if(nums[mid]<nums[mid-1]) high= mid -1;
            else if(nums[mid]<nums[mid+1]) low = mid + 1;
        }
        return -1;
    }
};

