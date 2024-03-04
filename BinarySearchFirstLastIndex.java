// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
We use a helper function, findRange, to find the first and last occurrence of the target in the array. If the target is not found, it returns [-1, -1].
The findRange function utilizes binary search to efficiently locate the target, adjusting pointers based on whether it's searching for the first or last occurrence of the target in the array.
 */
public class BinarySearchFirstLastIndex {

    public static int[] searchRange(int[] nums, int target) {
        int fi = findRange(nums, target, true);
        if (fi == -1) return new int[]{-1, -1};
        int li = findRange(nums, target, false);
        return new int[]{fi, li};
    }

    private static int findRange(int[] nums, int target, boolean isFirstIndex) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                if (isFirstIndex) {
                    if (mid == lo || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        hi = mid - 1;
                    }
                } else {
                    if (mid == hi || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        lo = mid + 1;
                    }
                }
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,7,7,7,8,10};
        int[] res = searchRange(nums, 7);
        System.out.println(res[0] + " " + res[1]);
    }
}
