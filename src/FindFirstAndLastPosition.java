
public class FindFirstAndLastPosition {

	
	//I need to do 2 modified binary searches to find first and last 
	// time complexity is O(log n + logn)=> O(log n)
	// Space complexity is O(1);
	public int[] searchRange(int[] nums, int target) {
		// 1. call left and right BS
		int first= findFirst(nums,target);
		int last = findLast(nums, target);
		 //2 . return value
		return new int[] {first, last};
	}
	
	// time complexity is O(n);
	// space complexity is O(n);
	public int findFirst(int[] nums, int target) {
		int low=0, high = nums.length-1, mid =0;
		while (low <=high) {
			mid = low + (high-low)/2; // to avoid integer overflow;
			if (nums[mid]==target) {
				if (mid==0 || nums[mid-1]!=target) {
					return mid;
				}
				high=mid-1;
			}else if (nums[mid]>target) {
				high=mid-1;
			}else {
				low = mid +1;
			}
		}
		return -1;
	}
	

	// time complexity is O(n);
	// space complexity is O(n);
	public int findLast(int[] nums, int target) {
		int low=0, high = nums.length-1, mid =0;
		while (low <=high) {
			mid = low + (high-low)/2; // to avoid integer overflow;
			if (nums[mid]==target) {
				if (mid==nums.length-1 || nums[mid+1]!=target) {
					return mid;
				}
				low = mid+1;
			}else if (nums[mid]>target) {
				high=mid-1;
			}else {
				low = mid +1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		FindFirstAndLastPosition findRange= new FindFirstAndLastPosition();
		int[] result= findRange.searchRange(new int[] {5,7,7,8,8, 10}, 8);
		for (int val:result){
			System.out.print(val+"*");
		}
		System.out.println();
		result=findRange.searchRange(new int[] {5,7,7,8,8, 10}, 10);
		for (int val:result){
			System.out.print(val+"*");
		}
		System.out.println();
		result=findRange.searchRange(new int[] {5,7,7,8,8, 10}, 12);
		for (int val:result){
			System.out.print(val+"*");
		}
		
		
	}
}
