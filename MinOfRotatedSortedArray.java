/**
 * Assume no dups exist
 * Complexity: log n
 *
 */
public class MinOfRotatedSortedArray {
	public static int findMin(int[] nums) {
		 int low = 0, high = nums.length-1, mid;
			while(low < high) {
	            if(nums[low] == nums[high]) {
					return nums[low];
				}
				mid = low+(high-low)/2;
				if((mid == 0 || nums[mid] < nums[mid-1]) && nums[mid] < nums[mid+1]) {
					return nums[mid];
				} else {
					//TODO Why can't it nums[low] compared with nums[mid] here?
					if(nums[high] < nums[mid]) {
						low = mid+1;
					} else {
						high = mid-1;
					}
				}
			}
			return nums[low];
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 1};
		System.out.println(findMin(nums));
	}

}
