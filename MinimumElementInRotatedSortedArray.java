
public class MinimumElementInRotatedSortedArray {


	
	public static int minElement(int[] nums) {
		
	    int left = 0, right = nums.length - 1;
	 // base condition
	    if(nums == null || nums.length == 0) return -1;
	    
	    while (left < right) {
	        int mid = left + (right -  left) / 2;
	        
	        // if nums = [ 4, 6, 7, 8, 0, 2, 3]
	        //                      !        !
	        if (nums[mid] > nums[right]) {
	        	// if nums = [ 4, 6, 7, 8, 0, 2, 3]
		        //                         !     !
	        	left = mid + 1;
	        }
	     // if nums = [ 4, 6, 7, 0, 1, 2, 3]
	        //                   !        !
	        else {
	        	// if nums = [ 4, 6, 7, 0, 1, 2, 3]
		        //             !(left)  ! (right)
	        	right = mid;
	        }
	    }
		return nums[left];
 }
	
	
//	public static int minElement (int[] nums) {
//		
//		if(nums == null || nums.length == 0) return -1;
//		int left = 0, right = nums.length - 1;
//		
//		while (left < right) {
//			int mid = left + (right - left) / 2;
//			
//			if(nums[mid] < nums[left]) {
//				right = mid - 1;
//			}
//			else left = mid;
//		}
//		return nums[right];
//	}
	
	public static void main(String[] args) {
		int nums[] = {4, 6, 7, 8, 0, 2, 3};
		System.out.println(minElement(nums));
	}
}
