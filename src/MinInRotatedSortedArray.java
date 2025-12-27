/*
Use binary search to find the pivot point, where the rotation occurred.
If the subarray from low to high is sorted, return nums[low].
Otherwise, check whether the left or right half is sorted and adjust the search accordingly.
Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
Space Complexity:
  O(1)
 */

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n-1;
        while (low <= high){
            if(nums[low]<=nums[high]) // this also means the array is already sorted
            {
                return nums[low];
            }
            int mid = low +(high-low)/2;
            // checking if the mid is less than its neighbors
            if ((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])){
                return nums[mid];
            }
            //left side is sorted
            else if(nums[low] <  nums[mid]){
                low = mid+1;
            }
            //right side is sorted
            else {
                high = mid-1;
            }
        }
        return  Integer.MIN_VALUE;
    }
}
