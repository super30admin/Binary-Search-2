/*
TC - O(logN)
SC - O(1)
Issues Faced - no, this was a simple binary search. But I did miss the == case for lo and mid value comparison. This is important in the case that the search space shrinks to just a single or two element(s), where even then the minimum should be compared by taking the leftmost element

Run on Leetcode - Yes

*/


class Solution {
    public:
        int findMin(vector<int>& nums) {
    
            int lo = 0;
            int hi = nums.size() - 1;
            int minimum = INT_MAX;
    
            while (lo <= hi) {
                int mid = (lo + (hi - lo)/2);
    
                if (nums[lo] <= nums[mid]) {
                    //this side is normally sorted
                    minimum = min(minimum, nums[lo]);
                    lo = mid + 1;
                } else {
                    // the right side is normally sorted
                    minimum = min(minimum, nums[mid]);
                    hi = mid - 1;
                }
            }
    
            return minimum;
            
        }
    };
