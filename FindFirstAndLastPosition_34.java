// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I was struggling to get the if condition on line 28 
// and 41

// Your code here along with comments explaining your approach
/* To get the first position, start with middle element, then check for previous element, 
if previous element is also equal to target, we have to search in lower half low = mid-1
if not equal to target, return mid as mid is the first position.
To get the last position, start from first position as low. Check if mid element is equal to target, 
if yes, check for mid+1 element, if that is also equal to target, check in upper half. else return mid */

public class FindFirstAndLastPosition_34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
         int first = getFirstPosition(nums, target);
        if(first == -1) return new int [] {-1, -1};
        int last = getLastPosition(nums, target, first);
        return new int[] {first, last};
    }

    private int getFirstPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid != 0 && nums[mid-1] == target) high = mid-1;
                else return mid;
            } else if (nums[mid] > target) {
                high = mid -1;
            } else low = mid+1;
        } return -1;
    }

    private int getLastPosition(int[] nums, int target, int low) {
        int high = nums.length -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid != high && nums[mid+1] == target) low = mid + 1;
                else return mid;
            } else {
                high = mid -1;
            }
        } return -1;
    }
}
