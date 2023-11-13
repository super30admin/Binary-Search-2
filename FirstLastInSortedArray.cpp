class Solution {
public:
    
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.empty()) 
        {
            return {-1, -1};
        }
        return search(nums, target, 0, nums.size() - 1);
    }
private:
    vector<int> search(vector<int>& nums, int target, int l, int r) 
    {
        if (nums[l] == target && nums[r] == target) 
        {
            return {l, r};
        }
        if (nums[l] <= target && nums[r] >= target) 
        {
            int m = l + (r - l) / 2;
            vector<int> left = search(nums, target, l, m), right = search(nums, target, m + 1, r);
            if (left[0] >= 0 && right[0] >= 0) 
            {
                return {left[0], right[1]};
            }
            return left[0] == -1 ? right : left;
        }
        return {-1, -1};
    }
};