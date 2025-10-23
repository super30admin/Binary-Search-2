class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if(((mid == 0) || (nums[mid - 1] > nums[mid])) && ((mid == n-1) || (nums[mid + 1] > nums[mid]))) {
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return 5768;
    }
}