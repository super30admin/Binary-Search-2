// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:

* Handed with two binary search

1. One binary search handles to track the minimum index
2. second binary search handles to track the maximum index
 */
public class FirstAndLastPosition {
    private int findFirstIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                if(mid > 0 && nums[mid - 1] == target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private int findLastIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                if(mid < high && nums[mid + 1] == target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        int firstIndex;
        int lastIndex;

        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        if(nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }

        firstIndex = findFirstIndex(nums, target);

        if(firstIndex == -1) {
            return new int[]{-1, -1};
        }

        lastIndex = findLastIndex(nums, target);

        return new int[]{firstIndex, lastIndex};
    }
}
