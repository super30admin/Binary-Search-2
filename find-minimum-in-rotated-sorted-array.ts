// Time Complexity - O(n), where n = size of the input array
function findMin(nums: number[]): number {
	let low = 0;
	let high = nums.length - 1;

	while (low <= high) {
		// array is already sorted
		if (nums[low] < nums[high]) return nums[low];

		let mid = Math.floor((low + high) / 2);
		// check if mid is the lowest element in rotated array
		if (
			(mid === 0 || nums[mid] < nums[mid - 1]) &&
			(mid === nums.length - 1 || nums[mid] < nums[mid + 1])
		) {
			return nums[mid];
		} else if (nums[low] <= nums[mid]) {
			// left side is sorted
			low = mid + 1;
		} else {
			high = mid - 1;
		}
	}
}
