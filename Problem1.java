package BinarySearch2;
/*
 * Here we perform binary search twice, first to find the initial occurence of the target and then to find the last occurence.
 * Time Complexity :
 * O(logN)
 * 
 * Space Complexity :
 * Space complexity is O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 * 
 */
public class Problem1 {
	
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		else if (nums[0] > target || nums[nums.length - 1] < target) {
			return new int[] { -1, -1 };
		}
		int firstIndex = binarySearchFirstIndex(nums, target, 0, nums.length - 1);
		if (firstIndex == -1)
			return new int[] { -1, -1 };

		int LastIndex = binarySearchLastIndex(nums, target, firstIndex, nums.length - 1);

		return new int[] { firstIndex, LastIndex };

	}

	private int binarySearchFirstIndex(int[] nums, int target, int low, int high) {

		while (low <= high) {
            int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == 0 || nums[mid] != nums[mid - 1])
					return mid;
				else {
					high = mid - 1;

				}
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return -1;
	}

	private int binarySearchLastIndex(int[] nums, int target, int low, int high) {

		while (low <= high) {
            int mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return -1;
	}


}
