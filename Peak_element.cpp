class Solution {
public:
    int findPeakElement(vector<int>& nums) {
            int n = nums.size();
        int low =0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            //if mid is the peak element
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==n-1 || nums[mid]> nums[mid+1]))return mid;
            else if(mid==n-1 || nums[mid]<nums[mid+1])low = mid+1;
        
        else high = mid -1;
        }
    return -1;
    }
    
};
