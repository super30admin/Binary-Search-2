class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) { //call 2 binarysearch function one t find first and another to find last
        int first = binarysearchfirst(nums,target,0,nums.size()-1);
        if(first == -1) return {-1,-1};
        int last = binarysearchlast(nums,target,first,nums.size()-1);
        return {first,last};
    }
    int binarysearchfirst(vector<int>& nums,int target,int l,int h)
    {
        while(l<=h)
        {

            int mid = l+(h-l)/2;
            if(nums[mid]==target)//if mid is the target then check if found element is the begining of the range
            {
                if(mid ==0 || nums[mid-1]!= target) 
                 return mid ;
                 else
                 h = mid-1;
            }else if(nums[mid]<target) // eliminate one half
                l = mid+1;
            else
                h = mid-1;
        }
        return -1;
    }
    int binarysearchlast(vector<int>& nums,int target,int l,int h)
    {
       
        while(l<=h)
        {

            int mid = l+(h-l)/2;
            if(nums[mid]==target)//if mid is the target then check if found element is the last ele of the range
            {
                if(mid == nums.size()-1 || nums[mid+1]!= target) 
                 return mid ;
                 else
                 l = mid+1;
            }else if(nums[mid]<target) // eliminate one half
                l = mid+1;
            else
                h = mid-1;
        }
        return -1;
    }
};