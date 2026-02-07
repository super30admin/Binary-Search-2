// Binary Search O(log n) time, O(1) space
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left <= right) {
            int mid = left + (right-left) / 2;

            if (nums[left] <= nums[right]) { // we are in sorted array
                return nums[left]; // min will be at left
            }

            // checking mid < both neighbors, then its minimum
            else if ((mid > 0 && nums[mid] < nums[mid-1]) && (mid < n-1 && nums[mid] < nums[mid+1])) {
                return nums[mid];
            }

            else if (nums[left] <= nums[mid]) { // left half sorted
                left = mid + 1; // means min must be in right half so move left forward
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
