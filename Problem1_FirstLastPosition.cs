// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        int first = FindFirstIndex(nums, target);
        int last = -1;
        if(first != -1) {
        last = FindLastIndex(nums, target);
        }
        return new int[]{first, last};
    }

    private int FindFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.Length - 1;
        int firstIndex = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                firstIndex = mid;
                high = mid - 1;
            }
            else if (target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return firstIndex;
    }

    private int FindLastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.Length - 1;
        int lastIndex = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                lastIndex = mid;
                low = mid + 1;
            }
            else if (target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return lastIndex;
    }
}