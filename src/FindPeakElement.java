
public class FindPeakElement {

	//TIME COMPLEXITY O(n)
	//Space complexity O(1)
	public int findPeakElement(int[] nums) {

		//let use binary search to find a peak
		//1-find low, high
		int low = 0, mid = 0, high = nums.length - 1;
		while (low < high) {
			//2-find mid
			mid = low + (high - low) / 2;
			// check if element is first element or the previous is less than nums[mid] and it is last element or nums[mid]> next one
			// if above conditions are met we found a peek and return index mid
			if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
				return mid;
			} else if (nums[mid] < nums[mid + 1]) {// check if we are in the start of slope of a peek so that we move right to reach peak
				low = mid + 1;
			} else {// we going down in the hill so we move back to reach peak
				high = mid - 1;
			}

		}
		return low;

	}

	public static void main(String[] args) {

		FindPeakElement findPeak= new FindPeakElement();
		System.out.println(findPeak.findPeakElement(new int[] {1,2,1,3,5,6,4}));
		System.out.println(findPeak.findPeakElement(new int[] {1,2,3,1}));
		
	}
}
