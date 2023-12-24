/*
 * Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(logN)
* 
* Space Complexity: O(1)
Approach
1. first check mid is peak or not.
2. If not, go side where the neighbour is greater than the mid element.
3. if both the neighbours are greater then move to either side.

 */

 class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if((mid == n-1 || nums[mid] > nums[mid+1]) && (mid == 0 || nums[mid] > nums[mid-1]))
                return mid;
            else if( mid > 0 && nums[mid] < nums[mid-1]) high = mid -1;
             else   low = mid+1;
             
        }
        return 41341;
    }
}