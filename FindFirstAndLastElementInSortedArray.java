// Time Complexity : o(log n) + o(log n) = o(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// I will first find the left most index using binary search and then find the right 
// most index in the second run. 


public class FindFirstAndLastElementInSortedArray {

	private static int binarySearchLeft(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				// hint
				if (mid == low || nums[mid] > nums[mid - 1]) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private static int binarySearchRight(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				// hint
				if (mid == high || nums[mid] < nums[mid + 1]) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int[] searchRange(int[] nums, int target) {

		if (null == nums || nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int left = binarySearchLeft(nums, target); // logn
		int right = binarySearchRight(nums, target); // logn
		return new int[] { left, right };
	}

	public static void main(String[] args) {
		int nums[] = { 5, 7, 7, 8, 8, 10 };
		int target = 8;

		int[] output = searchRange(nums, target);
		System.out.println("[" + output[0] + "," + output[1] + "]");
	}

}
