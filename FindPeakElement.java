
//Time Complexity :O(logN)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : No 

public class FindPeakElement {

	public int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		if (nums.length == 1)
			return 0;

		while (low <= high) {
			
			int mid = low + (high - low) / 2;
			
			if (mid == 0 && nums[mid] > nums[mid + 1] || mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
				return mid;
			}

			// check if mid is the peak element
			if (mid != 0 && mid != nums.length - 1 && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
				return mid;

			if (nums[mid] < nums[mid + 1])
				low = mid + 1;
			else
				high = mid - 1;
		}

		return -1;
	}
}
