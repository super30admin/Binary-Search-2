class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size()==0)
            return {-1,-1};

        int n=nums.size()-1;
        int low=0, high=n;

        int index1=BS1( target, nums);
        if(index1==-1)
            return {-1,-1};

        int index2=BS2( target, nums);

        return {index1, index2};
    }

    int BS1(int target,vector<int>& nums)
    {
        int low=0,  high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==low || nums[mid]!=nums[mid-1])
                     return mid;
                high=mid-1;
            }
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    int BS2(int target, vector<int>& nums)
    {   
        int low=0, high=nums.size()-1; 
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if((mid==high)|| nums[mid]!=nums[mid+1])
                    return mid;
                low=mid+1;
            }
                
            else if(nums[mid]<target)
                low=mid+1;
            else 
                high=mid-1;

        }
        return -1;
    }
};
