
public class findPeak {

	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
				return mid;
//			else if (mid > 0 && nums[mid] > nums[mid - 1]) {
//				low = mid + 1;
//			} else
//				high = mid - 1;
			
			else if (mid > 0 && nums[mid-1] > nums[mid]) {
				high = mid - 1;
			} else
				low = mid + 1;
		}

		return -1;

	}

	public static void main(String[] args) {
		findPeak peak = new findPeak();
		int[] nums = { 1, 2 };
		System.out.println(peak.findPeakElement(nums));
	}
}
