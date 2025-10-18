/**
 * 
 */

/**
 * @author sinha
 *
 */
// check mid is greater than its neighbors, and traverse left sorted or right sorted
// Space Complexity : O(1)
// Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
public class FindPeakElementArray {

	public int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length -1;
		
		while(low <= high) {
				int mid = low + (high - low) / 2;
				if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length-1 || nums[mid] > nums[mid + 1])) { // check mid's neighbors
					return mid;
				} else if(nums[mid + 1] > nums[mid]) { // left sorted
					low = mid + 1;
				} else {
					high = mid - 1; // right sorted
				}
			}
		
        return -1;
    }
}
class FindPeakElementArrayMain {
	public static void main(String[] args) {
		FindPeakElementArray fpea = new FindPeakElementArray();
		int[] nums = {1,2,3,1};
		
		System.out.println("Find peak element's index - " + fpea.findPeakElement(nums));
	}
}