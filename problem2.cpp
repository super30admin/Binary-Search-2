//Time complexity: O(logn)
//Space complexity: O(1)
class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size()==0)
            return -1;
        int l=0, r=nums.size()-1;
        while(l<=r)
        {
            if(nums[l]<nums[r])
                return nums[l];
            int mid=l+(r-l)/2;
            if((mid==0 || nums[mid]<nums[mid-1]) and (nums.size()-1==mid || nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }
            if(nums[l]<=nums[mid])
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
};