class Solution {
     // Time Complexity : O(logn)
    // Space Complexity : O(1)
public:
    int findMin(vector<int>& nums) {
        int low = 0;
        int high = nums.size()-1;
        int mid = (high-low)/2 + low;

        while(low<high){
            mid = (high-low)/2 + low;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }
            else high = mid;
        }
        return nums[low];

    }
};