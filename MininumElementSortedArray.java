// Time Complexity : Olog(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * Applied binary search, if mid < mid + 1 and mid < mid -1 then its minimum, 
 * along with this chechked if mid is at the extreme end of array 
 * Else checked if mid > low to determine if left sub array is sorted if yes then  discard the sorted array and continue
 */

// Java code to implement the approach

class MininumElementSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while(low <= high) {

            if (nums[low] <= nums[high]) {
                 return nums[low];
            }
            int mid = low + (high - low) / 2;
            
            if((mid == 0 || nums[mid] < nums[mid-1]) && 
                nums[mid] < nums[mid+1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 3333;
    }
}