
public class FindPeak {
	static int findPeakIndex(int[] nums) {
		 int lo = 0, hi = nums.length-1;
			while(lo<=hi) {
				int mid = lo+(hi-lo)/2;
				//Edge case: 
	            // If index is 0, prev ele can't be accessed
	            //  If index is the last ele, next ele can't be accessed
				if((mid==0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
					return mid;
				} else {
					//Edge case: If right ele is greater, ignore left part of the array
					if(mid < nums.length-1 && nums[mid] < nums[mid+1]) {
						lo = mid+1;
					} else {
						hi = mid-1;
					}
				}
			}
			return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1};
		System.out.println(findPeakIndex(nums));
	}

}
