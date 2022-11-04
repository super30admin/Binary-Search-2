/*

TC: O(lgn)
SC: O(1)

*/
class Solution {
public:
    int findMin(vector<int>& nums) {
        int l=0, r=nums.size()-1;
        while(l<=r) {
            if(nums[l] <= nums[r]) return nums[l];   //edge case when array is sorted on current logic, also an optimization
            
            int mid = l+(r-l)/2;
            if((mid == l || nums[mid] < nums[mid-1]) 
                && (mid == r || nums[mid] < nums[mid+1]))    return nums[mid];   //to instantly find minimum
            else if(nums[mid] <= nums[r]) r=mid-1;   //sorted on the right side, so go left to find pivot
            else   l=mid+1;  //sorted on the left side, so go right to find the pivot
        }
        return -1;
    }
};