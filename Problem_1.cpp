class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res;
        int start = INT_MAX;
        int n = nums.size();
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                start = min(start, mid);
                high = mid - 1;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            }
        }
        if(start == INT_MAX) {
            return {-1,-1};
        }
        int end = INT_MIN;
        low = 0;
        high = n -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                end = max(end, mid);
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            }
        }
        
        return {start, end};
    }
};
