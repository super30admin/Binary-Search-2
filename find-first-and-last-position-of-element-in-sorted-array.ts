// Time complexity: O(n) , where n is size of input array
function searchRange(nums: number[], target: number): number[] {
	// null,empty array check
	if (!nums || nums.length === 0) return [-1, -1];

	let n = nums.length - 1;

	// target out of bounds check
	if (nums[0] > target || nums[n] < target) return [-1, -1];

	let first = binarySearchFirstOccurence(nums, 0, n, target);
	if (first === -1) return [-1, -1];
	let second = binarySearchSecondOccurence(nums, first, n, target);
	if (second === -1) return [first, first];
	else return [first, second];
}

function binarySearchFirstOccurence(
	nums: number[],
	low: number,
	high: number,
	target: number
): number {
	while (low <= high) {
		let mid = Math.floor((low + high) / 2);

		if (nums[mid] === target) {
			// find first occurence
			// if previous element is not target, we found the first occurence
			if (mid === 0 || nums[mid - 1] !== target) {
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

function binarySearchSecondOccurence(
	nums: number[],
	low: number,
	high: number,
	target: number
): number {
	while (low <= high) {
		let mid = Math.floor((low + high) / 2);

		if (nums[mid] === target) {
			// find last occurence
			// if next element is not target, we found the last occurence
			if (mid === nums.length - 1 || nums[mid + 1] !== target) {
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
