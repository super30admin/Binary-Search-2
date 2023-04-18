// Time Complexity :O(log(n))
// Space Complexity :O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if((mid == low || (nums[mid-1] < nums[mid])) && (mid == high || (nums[mid +1] < nums[mid]))) {
                return mid;
            }
            if (nums[mid] < nums[mid +1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return 123123;
    }
}
