/*
/*

TC: O(lgn)
SC: O(1)

*/
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int l=0, r=nums.size()-1, first=-1, last=-1;
        //find first
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(target == nums[mid] && (mid-1<0 || nums[mid-1]!=target)) {
                first = mid; break;
            } 
            else if(target <= nums[mid])   r = mid-1;
            else    l = mid+1;
        }
        //find last
        if(first == -1) return {-1,-1};
        l=first, r=nums.size()-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(target == nums[mid] && (mid+1==nums.size() || nums[mid+1]!=target))  {
              last = mid; break;  
            } 
            else if(target >= nums[mid])   l = mid+1;
            else    r = mid-1;
        }
        
        return {first, last};
    }
};