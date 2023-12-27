//153. Find Minimum in Rotated Sorted Array

/*
Binary search implementation

Time complexity: O(Log N)
Space complexity: O(1)

*/

class Solution {
public:
    int findMin(vector<int>& nums) {
       
        int low = 0, high = nums.size()-1;
        while(low<=high){
            if(nums[low] <= nums[high]) return nums[low];

            int mid = low + (high-low)/2;

            if((mid == 0 || nums[mid] < nums[mid-1] ) && (mid == nums.size()-1 || nums[mid] < nums[mid+1]))
            return nums[mid];
            else if(nums[low] <= nums[mid]) low = mid+1;
            else high = mid -1;
        }

        return INT_MAX;

     
    }
};