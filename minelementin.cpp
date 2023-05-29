class Solution {
public:
    int findMin(vector<int>& nums) {
        
        int start = 0;
        int end = nums.size()-1;
        int mid;
        mid = start + (end-start)/2;
        while(start<=end)
        {
          

          if(nums[start]<=nums[end]){
              return nums[start];
          }
             mid = start + (end-start)/2;
            if((mid == 0 || nums[mid]<nums[mid-1]) && (nums[mid]<nums[mid+1])   )
            {

                return nums[mid];
            }
            else if(nums[start]<=nums[mid]){
                start = mid+1;
            }
            else{
            end = mid-1;
            }
            mid = start + (end-start)/2;
        }

             return -1;
    }
};