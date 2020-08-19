package com.Aug2020.BinarySearch;

class BinarySearchMin {
	public int findMin(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;

		int min = nums[0];

		while (start < end) {
			int mid = start + (end - start) / 2;
			

			if (nums[end] < nums[mid]) {

				end = mid - 1;

			} else {
				start = mid + 1;

			}

		}
		return nums[start];
	}
}
