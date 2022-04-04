
// Time Complexity : log(n);
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : binary search
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        
        int n = nums.size();
        if(nums.size() == 0) return -1;
        
        int l = 0;
        int r = n-1;
        
        while(l<=r) {
            int mid = l + (r-l)/2;
            
            if((mid == n-1 || nums[mid]> nums[mid +1]) && (mid == 0 || nums[mid] > nums[mid-1])) {
                return mid;
            } else if (mid != 0 && nums[mid] < nums[mid -1]) {
               r = mid -1; 
            } else {
               l = mid +1;
            }
        }
        
        return -1;
    }
};