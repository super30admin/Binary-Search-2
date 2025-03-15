// Time Complexity: O(log N), where N is the number of elements in the array.
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Use binary search to locate the target in the sorted array.
// 2. If the target is found, update the min and max indices in the array `a`.
// 3. Recursively search in the left and right halves to find the first and last occurrences of the target.

class Solution {
    public void binary(int[] nums, int l, int r, int target, int[] a) {  
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                a[0] = Math.min(a[0], mid);
                a[1] = Math.max(a[1], mid);
                binary(nums, l, mid - 1, target, a);
                binary(nums, mid + 1, r, target, a);
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] a = {Integer.MAX_VALUE, -1};
        binary(nums, 0, nums.length - 1, target, a);
        if (a[0] == Integer.MAX_VALUE) {
            a[0] = -1;
        }
        return a;
    }
}