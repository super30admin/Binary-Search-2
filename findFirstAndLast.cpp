class Solution {
public:
    int binarySearchFirst(vector<int>& nums, int left, int right, int target)
    {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if ((mid == 0) || (nums[mid] > nums[mid - 1])) {
                    return mid;   //Found index of first occurrence
                }

                right = mid - 1; //Not first occurrence. Keep moving left
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    int binarySearchLast(vector<int>& nums, int left, int right, int target)
    {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if ((mid == right) || (nums[mid] < nums[mid + 1])) {
                    return mid; //Found index of last occurrence
                }

                left = mid + 1; //Not last occurrence. Keep moving right
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    vector<int> searchRange(vector<int>& nums, int target)
    {
        int first, last;

        if (nums.size() == 0 || target < nums[0] || target > nums[nums.size() - 1]) {
            return {-1, -1};
        }

        first = binarySearchFirst(nums, 0, nums.size() - 1, target);
        if (first == -1) {
            return {-1, -1};
        }

        last = binarySearchLast(nums, first, nums.size() - 1, target);

        return {first, last};
    }
};
