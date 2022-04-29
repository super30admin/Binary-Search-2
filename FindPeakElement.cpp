class Solution {
public:
    int findPeakElement(vector<int>& nums) 
    {
        int size = nums.size();
        if(size==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[size-1]>nums[size-2]) return size-1;
        
        int low = 1;
        int high = size-2;
      
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]) return mid;
            else if(nums[mid]<nums[mid-1]) high= mid -1;
            else if(nums[mid]<nums[mid+1]) low = mid + 1;
        }
        return -1;
    }
};

