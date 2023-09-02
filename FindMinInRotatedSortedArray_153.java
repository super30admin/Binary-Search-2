// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* To check if the element is minimum, we have to check if it is smaller that previous and next element
 Also, we observed that min element is always in the unsorted part of the array.
 */

public class FindMinInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
    int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high - low) / 2;
            if((mid ==0 || nums[mid] < nums[mid-1]) && (mid== high || nums[mid] < nums[mid+1])) 
            return nums[mid];
            if(nums[low] <= nums[mid]) {
                //check in upper half
                low = mid+1; 
            } else {
                //check in lower half
                high = mid-1;
            }
        } return 0;
        
    }

}
