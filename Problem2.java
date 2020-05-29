
public class Solution {

	public int findMin(int[] nums) {
		
		int low = 0, high = nums.length - 1;
		
		return binarySearch(nums, low, high);
	}
	
	private int binarySearch(int[] nums, int low, int high) {
		
		if(low > high) return -1;
		
		int mid = low + (high - low)/2;
		
		if(nums[low] <= nums[mid]) {
			
			if(nums[low] <= nums[high]) {
				return nums[low];
			} else {
				low = mid + 1;
				return binarySearch(nums, low, high);
			}
		} else {
			if(nums[mid] < nums[high]) {
				high = mid;
				return binarySearch(nums, low, high);
			} else {
				return nums[mid];
			}
		}
		
	}
}
