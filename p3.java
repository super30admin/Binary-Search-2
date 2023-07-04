// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// I am using binary search to find the peak element. I reject the left half or right half of the array based on the slope of mid-1, mid and mid+1
// If the slope is increasing, I go towards the right side. That way I can always find the peak element

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (peek(nums, mid)) {
                return mid;
            } else if ((nums[mid] <= nums[mid + 1] && mid == 0) ||
                    (nums[mid] >= nums[mid - 1] && nums[mid] <= nums[mid + 1]) ||

                    (nums[mid] >= nums[mid - 1] && mid == nums.length - 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private boolean peek(int[] nums, int p) {
        System.out.println(p);
        if (p == 0) {
            if (nums[p] > nums[p + 1])
                return true;
            else
                return false;
        }
        if (nums.length - 1 == p) {
            if (nums[p] > nums[p - 1])
                return true;
            else
                return false;
        }
        if (nums[p] > nums[p - 1] && nums[p] > nums[p + 1])
            return true;
        return false;
    }
}