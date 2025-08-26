// Time Complexity= O(n)
function findPeakElement(nums: number[]): number {
	let low = 0;
	let high = nums.length - 1;

	while (low <= high) {
		let mid = Math.floor((low + high) / 2);

		if (
			(mid === 0 || nums[mid] > nums[mid - 1]) &&
			(mid === nums.length - 1 || nums[mid] > nums[mid + 1])
		)
			return mid;
		else if (nums[mid + 1] > nums[mid]) {
			low = mid + 1;
		} else {
			high = mid - 1;
		}
	}
}
