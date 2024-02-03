//Time Complexity - O(log n)
//Space Complexity - O(1)
//Ran in Leetcode - Yes

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int middle = 0;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			middle = low + (high - low) / 2;
			if ((middle == 0 || nums[middle] > nums[middle - 1])
					&& (middle == nums.length - 1 || nums[middle] > nums[middle + 1]))
				return middle;
			else if (nums[middle + 1] > nums[middle])
				low = middle+1;  
			else
				high = middle;

		}
		return -1;
	}
