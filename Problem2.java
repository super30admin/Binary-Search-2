// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None

public class Problem2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // If the array is not rotated
        if (nums[left] <= nums[right]) return nums[left];


        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Min must be to the right of mid
                left = mid + 1;
            } else {
                // Min is at mid or to the left of mid
                right = mid;
            }
        }

        return nums[left];
    }
}