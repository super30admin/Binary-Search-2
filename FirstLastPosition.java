// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Create 2 helper functions, one for finding first occurance and other for last occurance. In each function, use binary function to find indexes, like in the upper bound and lower bound algorithms.


public class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = getFirstPosition(nums, target);
        result[1] = getLastPosition(nums, target);
        return result;
    }

    private int getFirstPosition(int[] nums, int target) {
        int index = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                index = mid;    //don't stop binary search since we need to find first occurance
            }
            if(nums[mid] >= target) {   //target is in left half
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    private int getLastPosition(int[] nums, int target) {
        int index = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FirstLastPosition flp = new FirstLastPosition();

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = flp.searchRange(nums1, target1);
        System.out.println("Target: " + target1 + " First position: " + result1[0] + ", Last position: " + result1[1]);

        int target2 = 6;
        int[] result2 = flp.searchRange(nums1, target2);
        System.out.println("Target: " + target2 + " First position: " + result2[0] + ", Last position: " + result2[1]);

        int target3 = 5;
        int[] result3 = flp.searchRange(nums1, target3);
        System.out.println("Target: " + target3 + " First position: " + result3[0] + ", Last position: " + result3[1]);
    }
}
