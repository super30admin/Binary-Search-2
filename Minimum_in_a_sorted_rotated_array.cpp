class Solution {
public:
    int findMin(vector<int>& nums) {
       int n = nums.size()-1, low = 0, high = nums.size()-1;
       if(n ==-1) return -1;
       if(n==0) return nums[0];
        while(low<=high){
            int mid = low + (high-low)/2;
        if(nums[low] <= nums[high])return nums[low];
        if((mid == 0 || nums[mid] < nums[mid-1]) && (nums[mid] < nums[mid+1])){
                return nums[mid];
         }
         else if(nums[mid]< nums[low]) {
             high = mid -1;
         }
         else low = mid+1;

        }
   return -1;
    } 
};
