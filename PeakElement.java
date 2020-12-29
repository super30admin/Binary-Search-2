
//Time Complexity: O(Logn)
//Space Complexity: O(1)
public class PeakElement {
	public int findPeakElement(int[] nums) {
		  if (nums == null && nums.length == 0) {
	            return -1;
	        }
		  int start = 0, end = nums.length-1;
		  while (start <= end) {
	            int mid = start + (end-start)/2;
	            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
	                return mid;
	            }
	            else if (nums[mid] < nums[mid+1]) {
	                start = mid + 1;
	            } 
	            else {
	                end = mid - 1;
	            }
	        }
	        return -1;
	  
  }
}
	

