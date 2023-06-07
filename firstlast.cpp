// TC:O(logN)
// SC:O(1)

// Approach:
// Doing two binary seraches one for the first and other for last index,
// For finding the left index of the target, moving towards left if we find the number same as target at mid-1
// For finding the right index of the target, moving towards right if we find the number same as target at mid+1


class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {

        int left=BinarySearchLeft(nums,target);
        int right=BinarySearchRight(nums,target);

        return vector<int>{left,right};  
    }

    int BinarySearchLeft(vector<int>& nums, int target)
    {
        int low=0;
        int high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            // For finding the left index of the target, moving towards left if we find the number same as target at mid-1
            if(nums[mid]==target)
            {
                if(mid-1>=0 && nums[mid-1]==target)
                high=mid-1;
                else
                return mid;
            }
            else if(nums[mid]<target)
            low=mid+1;
            else
            high=mid-1;   
        } 
        return -1;  
    }

    int BinarySearchRight(vector<int>& nums, int target)
    {
        int low=0;
        int high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
              // For finding the right index of the target, moving towards right if we find the number same as target at mid+1
            if(nums[mid]==target)
            {
                if(mid+1<=nums.size()-1 && nums[mid+1]==target)
                low=mid+1;
                else
                return mid;
            }
            else if(nums[mid]<target)
            low=mid+1;
            else
            high=mid-1;   
        }   
        return -1;
    }
};