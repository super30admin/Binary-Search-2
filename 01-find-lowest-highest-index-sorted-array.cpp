/*
TC - O(logN)
SC - O(1)
Issues Faced - no, this was a simple double binary search. But I did overcomplicate the bound tightening. Simply noting the current found position and continuing to search is neater.

Run on Leetcode - Yes

*/


class Solution {
    public:
        vector<int> searchRange(vector<int>& nums, int target) {
    
            int lo = 0;
            int hi = nums.size() - 1;
    
            int lowest = -1;
            int highest = -1;
    
            while (lo <= hi) {
                int mid = (lo + (hi - lo)/2);
    
                if (nums[mid] == target) {
                        lowest = mid;
                        hi = mid - 1;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
    
            lo = 0;
            hi = nums.size() - 1;
    
    
            while (lo <= hi) {
                int mid = (lo + (hi - lo)/2);
    
                if (nums[mid] == target) {
                        highest = mid;
                        lo = mid + 1;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
    
            return {lowest, highest};
    
            
        }
    };
