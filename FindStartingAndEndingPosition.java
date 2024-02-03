//Time Complexity - O(log(n))
//Space Complexity - O(1)
//Ran in Leetcode - Yes

import java.util.Arrays;

public class FindStartingAndEndingPosition {
	private int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		int length = nums.length - 1;
		if (target < nums[0] || target > nums[length])
			return new int[] { -1, -1 };

		int firstIndex = binarySearchFirst(nums, 0, length, target);
		if (firstIndex == -1)
			return new int[] { -1, -1 };
		int secondIndex = binarySearchSecond(nums, firstIndex, length, target);
		return new int[] { firstIndex, secondIndex };
	}

	private int binarySearchFirst(int[] nums, int i, int length, int target) {
		int middle = 0;
		int low = i;
		int high = length;
		while (low <= high) {
			middle = low + (high - low) / 2;
			if (nums[middle] == target) {
				if (middle == 0 || nums[middle] != nums[middle - 1])
					return middle;
				else
					high = middle - 1;
			} else if (nums[middle] < target) {
				low = middle + 1;
			} else
				high = middle - 1;
		}
		return -1;
	}

	private int binarySearchSecond(int[] nums, int firstIndex, int length, int target) {
		int middle = 0;
		int low = firstIndex;
		int high = length;
		while (low <= high) {
			middle = low + (high - low) / 2;
			if (nums[middle] == target) {
				if (middle == length || nums[middle] != nums[middle + 1])
					return middle;
				else
					low = middle + 1;
			} else if (nums[middle] < target) {
				low = middle + 1;
			} else
				high = middle - 1;
		}
		return -1;
	}


}
