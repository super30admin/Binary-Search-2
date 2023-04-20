// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// we do bsFloor and bsCeil to get the start and end respectively

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int start = -1, end = -1;
        start = bsFloor(nums,target);
        end = bsCeil(nums,target);
        return {start,end}; 
    }
    int bsFloor(vector<int>& nums,int target)
    {
        int hi= nums.size()-1;
        int lo = 0;
        int index=-1;
        while(lo<=hi)
        {
            int mid = lo + (hi - lo)/2;
            if(target == nums[mid]) index = mid;
            if(target <= nums[mid])
            {
                hi = mid-1;
                
            }
            else{
                lo = mid +1;
            }
        }
        return index;
    }
        int bsCeil(vector<int>& nums,int target)
    {
        int hi= nums.size()-1;
        int lo = 0;
        int index=-1;
        while(lo<=hi)
        {
            int mid = lo + (hi - lo)/2;
            if(target == nums[mid]) index = mid;
            if(target >= nums[mid])
            { 
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return index;
    }
};