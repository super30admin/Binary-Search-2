/*

TC: O(lgn)
SC: O(1)

*/
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int l=0, r=nums.size()-1;
        while(l<=r) {
            int mid=l+(r-l)/2;
            if((mid+1==nums.size() || nums[mid]>nums[mid+1]) && (mid-1<0 || nums[mid]>nums[mid-1])) return mid;
            else if(mid+1<nums.size() && nums[mid]<nums[mid+1]) l=mid+1;
            else    r=mid-1;
        }
        return -1;
    }
};