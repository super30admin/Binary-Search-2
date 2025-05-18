// Time complexity O(n)
// Space complexity O(1)
class Solution {
    int searchFirst(vector<int>& nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid-1]) {
                    return mid;
                } else {
                    hi = mid -1;
                }
            } else if (nums[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;    
    }

    int searchLast(vector<int>& nums, int target, int lo, int hi) {
        int n = nums.size();
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target) {
                if (mid ==  (n-1) || nums[mid] != nums[mid+1]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;    
    }

public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.empty()) {
            return {-1, -1};
        }
        int first = searchFirst(nums, target, 0, nums.size()-1);
        if (first == -1) {
            return {-1, -1};
        }
        int last = searchLast(nums, target, first, nums.size()-1);
        return {first, last};
    }
};