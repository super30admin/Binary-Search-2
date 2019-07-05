
public class PeakElementInArray {
	public static Integer getPeakElement(int[] nums) {

		        
		    // iterative solution
		    int left = 0, right = nums.length - 1;
		    while (left < right) {
		        int mid = left + (right - left) / 2;
		        if (nums[mid] > nums[mid + 1])
		           right = mid;
		        else
		           left = mid + 1;
		        }
		        return left;
		    }
		    
		    // recursive solution
	
		    /* public static int getPeakElement(int[] nums) {
		        return search(nums, 0, nums.length - 1);
		    }
		    public int search(int[] nums, int left, int right) {
		        if (left == right)
		            return left;
		        int mid = (left + right) / 2;
		        if (nums[mid] > nums[mid + 1])
		            return search(nums, left, mid);
		        return search(nums, mid + 1, right);
		    } */
		
	
	public static void main(String[] args) {
		int nums[] = {4, 6, 6, 6, 7, 8, 0, 2, 3};
		System.out.println(getPeakElement(nums));
	}
}
