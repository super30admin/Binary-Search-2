class Solution {
public:
    int findMin(vector<int>& nums) 
    {
        int low = 0, high = nums.size() - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2;

            if ((mid > 0) && (nums[mid - 1] > nums[mid])) {
                return nums[mid];
            }

            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return nums[low];  //Never reaches this line
    }
};
