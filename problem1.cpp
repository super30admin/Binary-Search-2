//Time complexity: O(log)
//space complexity O(1)
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int first=binarySearchF(nums,target);
        if(first==-1)
            return {-1, -1};
        int second=binarySearchS(nums,target);

        return {first, second};
    }
    int binarySearchF(vector<int>& nums, int target)
    {
        int l=0, r=nums.size()-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
        if(nums[mid]==target)
        {
            if(mid==0 || nums[mid-1]!=nums[mid])
                return mid;
        
                r=mid-1;
        }

        else if(target>nums[mid])
        {
            l=mid+1;
        }
        else
        {
            r=mid-1;
        }
        }
        return -1;
    }
    int binarySearchS(vector<int>& nums, int target)
    {
        int l=0, r=nums.size()-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
        if(nums[mid]==target)
        {
            if(mid==nums.size()-1 || nums[mid+1]!=nums[mid])
                return mid;
           
                l=mid+1;
        }

        else if(target>nums[mid])
        {
            l=mid+1;
        }
        else
        {
            r=mid-1;
        }
        }
        
        return -1;
    }
};