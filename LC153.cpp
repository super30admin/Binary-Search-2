// Time complexity O(n)
// Space complexity O(1)
class Solution {
public:
    int findMin(vector<int>& nums) {
        int lo = 0;
        int hi = nums.size()-1;
        while (lo <= hi) {

            if (nums[lo] <= nums[hi]) {
                return nums[lo];
            }

            int mid = lo + (hi-lo)/2;
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }

            if (nums[lo] <= nums[mid]) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        return INT_MAX;
    }
};