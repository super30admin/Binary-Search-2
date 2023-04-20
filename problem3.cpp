// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// We do binary search on array and move towards the higher side if one of its neighbors is small;
// if both neighbors are small, that means we got peak value and return it.
// if both neighbors are big, we can move towards any side. in this solution, we are moving towards left side;




class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        int lo =0;
        int hi=n-1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if((mid==lo || nums[mid]>nums[mid-1]) && (mid==hi || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid]<nums[mid+1])
            {
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return 1;
        
    }
};