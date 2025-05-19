// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None

public class Problem3 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else
                right = mid;

        }

        return left;
    }
}
