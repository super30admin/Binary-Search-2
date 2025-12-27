/*
Approach:
Binary search checks whether the current mid is a peak.
If not, it moves right if nums[mid + 1] > nums[mid], otherwise left.
The loop continues until a peak is found and returned.
Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
Space Complexity:
  O(1)
 */


public class PeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid  = low + (high-low)/2;
            if ( (mid == 0 || nums[mid] > nums[mid -1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1] > nums[mid]){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}
