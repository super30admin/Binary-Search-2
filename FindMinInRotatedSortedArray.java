/*
* Approach:
*  1. If array is sorted, return the first element
* 
*  2. If not search for sorted half, 
        move towards unsorted half to find min element
* 
*  3. Handle the case of sorted half part instead loop,
        so when we have sorted half after reducing search space, 
            we can return first element.
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
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            if(nums[low]<=nums[high])
                return nums[low];

            int mid = low + ((high - low) / 2);

            if ((mid == 0 || nums[mid - 1] > nums[mid]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];

            // left part is sorted
            else if (nums[low] <= nums[mid]) {
                // move towards right
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
