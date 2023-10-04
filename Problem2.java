//Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

class Solution {

  public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      if (nums[low] < nums[high]) return nums[low];
      int mid = low + (high - low) / 2;
      if (
        (mid == 0 || nums[mid] < nums[mid - 1]) && nums[mid] < nums[mid + 1]
      ) {
        return nums[mid];
      } else if (nums[mid] < nums[high]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return nums[low];
  }
}


class Problem2 {

  public static void main(String[] args) {
    int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 16 };
    Solution sol = new Solution();
    System.out.println(sol.findMin(array));
  }
}