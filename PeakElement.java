// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understanding the logic why BS can be used


// Your code here along with comments explaining your approach in three sentences only
 /*We start by setting low and high pointers and iterates until they converge.
 At each iteration, it compares the current element with its neighbors to determine whether it is a peak, adjusting the pointers accordingly based on the comparison result.
 If a peak is found, its index is returned; otherwise, -1 is returned if no peak exists in the array.
*/
public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;

            if ((mid == nums.length - 1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid - 1])) {
                return mid;
            } else if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
