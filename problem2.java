//time complexity-O(logn)
//space complexity-O(1)
//passed all test cases on leetcode
// the approach is here that we find the sorted part of the two divided parts and save the minimum of the sorted array in the min variable and now search the unsorted array for a more lesser value.
class Solution {
    public int findMin(int[] nums) {
        int min = 5001;
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= nums[low]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}