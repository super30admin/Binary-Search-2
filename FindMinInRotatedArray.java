class Solution {
    /*
        Time Complexity : O(log n)
        Space complexity : O(1)

        Solution : To find the minimum element in a rotated array, we apply binary search to find the
        element where the previous element is smaller since this is the element at which 
        the array was rotated and will be the smallest. Or if we find part of array where the low 
        index has element smaller than element at the high index which means we are in the 
        sorted part of the array.
    */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low)/2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}