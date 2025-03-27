/**
 * We perform binary search. We try to find the minimum element by checking if Mid is the minimum element or not.
 * If not, we check if the left half is sorted or the right half is sorted.
 * If the left half is sorted, we know that the minimum element must be in the right half. or vice versa.
 * We repeat this process until we find the minimum element.
 */

//Time complexity - O(log n)
//Space complexity - O(1)

//Leetcode - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class FindMin {
    public int findMin(int[] nums) {

        int low = 0; 
        int high = nums.length-1; 

        while(low <= high) {
            if(nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high-low) /2 ;

            if((mid == 0 || nums[mid] <= nums[mid-1]) && (mid == nums.length-1 || nums[mid] <= nums[mid+1])) {
                return nums[mid];
            }

            if(nums[low] <= nums[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
        
    }
}