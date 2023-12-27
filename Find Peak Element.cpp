//162. Find Peak Element

/*
Binary search implementation - check neighbors of mid to get peak

Time complexity: O(Log N)
Space complexity: O(1)

*/

class Solution {
public:
    int findPeakElement(vector<int>& nums) {

        int low = 0, high = nums.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            
            //check neighbors of mid to get peak
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.size()-1 || nums[mid] > nums[mid+1]))
                return mid;
            
            else{
                if(nums[mid+1] > nums[mid]) low = mid+1;
                else high = mid - 1;
            }
        }

        return -1;
        
    }
};