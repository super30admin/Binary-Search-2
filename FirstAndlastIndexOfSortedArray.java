public class FirstAndlastIndexOfSortedArray {

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0 || nums == null) {
			return new int[] { -1, -1 };
		}
		int left = binarySearchLeft(nums, target);
		int right = binarySearchRight(nums, target);
		return new int[] { left, right };
	}

	public int binarySearchLeft(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == 0 || nums[mid] > nums[mid - 1]) {
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

	public int binarySearchRight(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == nums.length-1 || nums[mid] < nums[mid + 1]) {
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
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		FirstAndlastIndexOfSortedArray firstAndlastIndexOfSortedArray = new FirstAndlastIndexOfSortedArray();
		firstAndlastIndexOfSortedArray.searchRange(nums, target);
		firstAndlastIndexOfSortedArray.searchRange(nums, target);
	}

}
