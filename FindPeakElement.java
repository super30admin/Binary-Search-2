/*
* Approach:
*  1. Apply Binary Search and check mid is peak or not
* 
*  2. If not, move towards highest neighbour side,
        because highest neighbour guarantees the peak element,
         atleast at the end of array or middle in that half. 
* 
    Why we are not moving towards lowest neighbour?
        lowest neighbour cannot guarantee peak all the time,
            there might be all valleys sometimes.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(logN)
* 
* Space Complexity: O(1)
* 
*/

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if ((mid == 0 || nums[mid - 1] < nums[mid]) &&
                    (mid + 1 == nums.length || nums[mid] > nums[mid + 1]))
                return mid;

            else if (nums[mid] < nums[mid + 1])
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }
}