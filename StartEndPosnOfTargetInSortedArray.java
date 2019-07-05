
public class StartEndPosnOfTargetInSortedArray {

	 public static int[] search(int[] nums, int target) {
		int[] solution = new int[2];
		solution[0] = firstIndex(nums, target);
		solution[1] = lastIndex(nums, target);
		
		return solution;
	}
	
	
	public static int firstIndex(int[] nums, int target) {
		
		int left = 0, right = nums.length - 1, index = -1;
		
		
		if(nums.length == 0 || nums == null) {
			return -1;
		}
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(target <= nums[mid]) {
				right = mid - 1;
			} 
			else left = mid + 1;
			if(target == nums[mid]) {
				index =  mid;
			} 
		}
		return index;
	}
	
public static int lastIndex(int[] nums, int target) {
		
		int left = 0, right = nums.length - 1, index = -1;
		
		
		if(nums.length == 0 || nums == null) {
			return -1;
		}
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(nums[mid] <= target) {
				left = mid + 1;
			} 
			else right = mid - 1;
			if(target == nums[mid]) {
				index = mid;
			} 
		}
		return index;
	} 
	

public static void main(String[] args) {
	int nums[] = {4, 6, 6, 6, 7, 8, 0, 2, 3};
	System.out.println(search(nums, 6));
} 

}
