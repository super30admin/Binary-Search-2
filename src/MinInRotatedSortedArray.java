/**
 * 
 */

/**
 * @author sinha
 *
 */
// check mid is smaller than its neighbors, and traverse left sorted or right sorted
// Space Complexity : O(1)
// Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
public class MinInRotatedSortedArray {

	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length -1;
		
		while(low <= high) {
			if(nums[low] <= nums[high]) { // for single element array or 2 element sorted array
				return nums[low];
			} 
				int mid = low + (high - low) / 2;
				if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length-1 || nums[mid] < nums[mid + 1])) { // check mid's neighbors
					return nums[mid];
				} else if(nums[low] <= nums[mid]) { // left sorted
					low = mid + 1;
				} else {
					high = mid - 1; // right sorted
				}
			}
		
        return -1;
    }
}

class MinInRotatedSortedArrayMain {
	public static void main(String[] args) {
		MinInRotatedSortedArray mirsa = new MinInRotatedSortedArray();
		int[] nums = {4,5,6,7,0,1,2};
		
		System.out.println("min in rotated sorted array - " + mirsa.findMin(nums));
	}
}
