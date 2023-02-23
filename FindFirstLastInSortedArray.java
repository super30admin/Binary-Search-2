// Time Complexity : o(log(n))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* we do seperate binary search for finding left and right  
 * ignore right if left is -1
*/


public class FindFirstLastInSortedArray {
	public static int[] searchRange(int[] nums, int target) {
		if (null == nums || nums.length == 0)
			return new int[] { -1, -1 };
		int n = nums.length - 1;
		int low = 0;
		int high = nums.length - 1;

		int start = -1;
		int end = -1;
		// first
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == 0 || nums[mid] > nums[mid - 1]) {
					start = mid;
					break;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// last
		if (start != -1) {
			low = start;
			high = n;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (nums[mid] == target) {
					if (mid == n || nums[mid] < nums[mid + 1]) {
						end = mid;
						break;
					} else {
						low = mid + 1;
					}
				} else if (nums[mid] < target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		if (start != -1 && end != -1) {
			return new int[] { start, end };
		}

		return new int[] { -1, -1 };
	}

	public static void main(String args[]) {
		int[] dup = { 5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 10 };
		int target = 8;
		System.out.println("range->" + searchRange(dup, target));

	}
}
