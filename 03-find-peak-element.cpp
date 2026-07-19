/*
TC - O(logN)
SC - O(1)
Issues Faced - no, this was a simple binary search. 

Run on Leetcode - Yes

*/


class Solution {
    public:
        int findPeakElement(vector<int>& nums) {
            int lo = 0;
            int n = nums.size();
            int hi = n - 1;
    
            while (lo <= hi) {
                int mid = (lo + (hi - lo)/2);
    
                bool leftCheck = mid == 0 || (mid > 0 && nums[mid - 1] < nums[mid]);
                bool rightCheck = mid == n - 1 || (mid < (n - 1) && nums[mid] > nums[mid + 1]);
    
                if (leftCheck && rightCheck) {
                    return mid;
                }
    
                if (!leftCheck) {
                    //this means you are smaller than your left neighbor, so let's go that way
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
    
            return -1;
            
        }
    };
