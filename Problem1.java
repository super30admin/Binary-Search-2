// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * First found the first position of the target, if we found the target, go left more. 
 * If first position not found, early return
 * Find the second position of the target by going right and stop if the next number is bigger
 */


public class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int firstPos = searchFirstPosition(nums, low, high, target);
        if(firstPos == -1) {
            return new int[]{-1,-1};
        }

        int secondPos = searchSecondPosition(nums, low, high, target);
        return new int[]{firstPos, secondPos};
    }

    private int searchFirstPosition(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid-1] < nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int searchSecondPosition(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid+1] > nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem1 oProblem1 = new Problem1();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(oProblem1.searchRange(nums, target)[0]);
        System.out.println(oProblem1.searchRange(nums, target)[1]);
    }
}