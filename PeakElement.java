// Time Complexity : Olog(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * Applied binary search, if mid > mid + 1 and mid > mid -1 then its Peak,
 * Along with this chechked if mid is at the extreme end of array 
 * Else checked if mid < mid + 1 to determine if right sub array has the peak if yes then  discard the left array and continue
 * OR vise versa
 */

// Java code to implement the approach

class PeakElement {
    public int findPeakElement(int[] nums) {
        int n  = nums.length;
        if (n == 1) {
            return 0;
        }

        int l = 0, r = n -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;

            if ( (mid == 0 || nums[mid] > nums[mid -1]) &&
            (mid == n -1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if(nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }

        return 3333;
    }
}