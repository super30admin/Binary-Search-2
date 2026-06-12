// Explain your approach in **three sentences only** at top of your code: binary search to find the minimum element in a rotated sorted array. Compare the middle element with the rightmost element to determine which half of the array is unsorted and contains the minimum element. Continue narrowing down the search space until the left pointer points to the minimum element, which is returned at the end.
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}