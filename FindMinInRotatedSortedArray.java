// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
. We first handle the edge case where the array contains only one element by returning that element.
Then, we check if the array is already sorted without rotation, returning the first element if it is.
Using binary search, it iterates through the array to find the point where the rotation occurs, identifying the minimum element. If no rotation is detected, it returns -1.
 */
public class FindMinInRotatedSortedArray {

    public static int findMininRotSort(int[] nums) {
        if (nums.length == 1) return nums[0];
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[lo]) {
            return nums[lo];
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,1};
        System.out.println(findMininRotSort(nums));
    }
}
