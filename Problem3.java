//Problem 3: (https://leetcode.com/problems/find-peak-element/)
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

class Solution {

  public int findPeakElement(int[] nums) {
    int n = nums.length - 1;
    int low = 0;
    int high = n;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (
        (mid == 0 || nums[mid - 1] < nums[mid]) &&
        (mid == n || nums[mid + 1] < nums[mid])
      ) {
        return mid;
      } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}

class Problem3 {

  public static void main(String[] args) {
    int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 16 };
    Solution sol = new Solution();
    System.out.println(sol.findPeakElement(array));
  }
}
