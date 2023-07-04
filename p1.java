// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// Using binary search here to find the range. For left index, if the element is found and if there is a similar element on the left, then 
// reject the right half and move towards left half until we find the element whose left element is different
// After getting left index, similarly find right index

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int h = nums.length - 1;
        if (h == -1)
            return new int[] { -1, -1 };
        if (nums[0] > target)
            return new int[] { -1, -1 };
        if (nums[h] < target)
            return new int[] { -1, -1 };
        int l = 0;
        l = binary(nums, l, h, target, true);
        if (l == -1)
            return new int[] { -1, -1 };
        h = binary(nums, l, h, target, false);
        return new int[] { l, h };
    }

    private int binary(int[] nums, int l, int h, int target, boolean leftIndex) {
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                if (leftIndex) {
                    if (mid != l && nums[mid] == nums[mid - 1]) {
                        h = mid - 1;
                    } else
                        return mid;
                } else {
                    if (mid != h && nums[mid] == nums[mid + 1]) {
                        l = mid + 1;
                    } else
                        return mid;
                }
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return -1;
    }
}