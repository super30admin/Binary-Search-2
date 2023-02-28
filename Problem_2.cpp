153. Find Minimum in Rotated Sorted Array

TC O(logn)
SC O(1)

class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        if (n ==0) return 0;
        int low = 0;
        int high = n-1;

        while (low <= high) {
            if (nums[low] <= nums[high]) return nums[low];
            int mid = low + (high - low)/2;
            if (((mid == 0) || (nums[mid] < nums[mid - 1])) 
            && ((mid == n-1) || (nums[mid] < nums[mid +1]))) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
};
