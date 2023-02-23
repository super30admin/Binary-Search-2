//Time Complexity : o(log(n))

//Space Complexity : o(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

//Your code here along with comments explaining your approach
/* To find the peak element, find mid. 
 * return if mid is greater than both of its neighbors
 * else go to highest neighbor until we find the peak
 * if two neighbor are great choose any
 * and find peak
*/

public class FindPeakElement {
	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return Integer.MIN_VALUE;

		int n = nums.length;

		int start = 0, end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1]))
				return mid;
			else if (mid > 0 && nums[mid] < nums[mid - 1])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String args[]) {
		int[] dup = { 5, 6, 8, 9, 10 };
		System.out.println("val->" + findPeakElement(dup));

	}
}
