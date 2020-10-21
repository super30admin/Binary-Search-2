// Time Complexity : o(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach - explained in the code

public class FindMinInRotatedSorted {

	public static void main(String[] args) {

		int nums[] = { 4, 5, 6, 7, 1,2};

		System.out.println(findMin(nums));

	}

	public static int findMin(int nums[]) {

		if (null == nums || nums.length == 0) {
			return -1;
		}

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			// if sorted itself
			if (nums[low] < nums[high]) {
				return nums[low];
			}

			int mid = low + (high - low) / 2;
			if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
				// left side and right side is greater than mid then mid is the min element
				return nums[mid];
			}
			if (nums[mid] > nums[high]) {
				//right side contains min element
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

}
