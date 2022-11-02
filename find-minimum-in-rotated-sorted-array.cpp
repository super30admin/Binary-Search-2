/*

TC: O(lgn)
SC: O(1)

*/class Solution {
public:
    int findMin(vector<int>& nums) {
        int l=0, r=nums.size()-1;
        int minElement = INT_MAX;
        while(l<=r) {
            int mid = l+(r-l)/2;
            minElement = min(minElement, nums[mid]);
            if(nums[mid] < nums[r]) r=mid-1;   //sorted on the right side
            else   minElement = min(minElement, nums[l]), l=mid+1;  //sorted on the left side
        }
        return minElement;
    }
};