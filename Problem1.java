package Q_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Problem1 {


	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length ==0) {
			return new int[] {-1,-1};
			//	    	 return new int[] {-1,-1};
		}   

		int left = 0;
		int right = nums.length - 1;

		int start =-1;
		int end = -1;
		
		start = searchBinaryLeft(nums, target);
		end = searchBinaryRight(nums, target);
//		System.out.println(start);
//		System.out.println(end);
		
		//	 return new int[] {-1,-1};
		return new int[] {start,end};
	}
	
	
	public int searchBinaryLeft(int[] nums, int target) {
		if(nums == null || nums.length ==0) {
			return -1;
		}
		
		int left =0;
		int right = nums.length-1;
		
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(nums[mid] == target) {
				if( mid == 0  || nums[mid] >  nums[mid - 1] ) {
					return mid;
				}else {
					right = mid -1;
				}
			}else if(target < nums[mid]){
				right = mid-1;
			}else {
				left = mid + 1;
			}
			
		}
		
		return -1;
	}
	
	public int searchBinaryRight(int[] nums, int target) {
		if(nums == null || nums.length ==0) {
			return -1;
		}
		
		int left =0;
		int right = nums.length-1;
		
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(nums[mid] == target ) {
				if( mid == nums.length -1 ||nums[mid] < nums[mid+1]) {
					return mid;
				}else {
					left = mid +1;
				}
			}else if(target > nums[mid]) {
				left = mid+1;
			}else {
//				target < nums[mid];
				right = mid-1;
			}
			
			
		}
		
		return -1;
	}
	
	

	public int searchRangeOne(int[] nums, int target) {
		if(nums == null || nums.length ==0) {
			return -1;
			//		   	 return new int[] {-1,-1};
		}   

		int left = 0;
		int right = nums.length - 1;

		while(left < right) {
			int mid = left + (right-left)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(target < nums[mid]){
				right = mid;
			}else if(target > nums[mid]) {
				left = mid +1;
			}
		}

		//return new int[] {-1,-1};
		return -1;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {5,7,7,8,8,10};
		int[] nums = {1};
//		int[] nums = {5,6,7,8,9,10};
		int target = 1;
		Solution s = new Solution();
		int[] ans = s.searchRange(nums, target);
		System.out.println(ans[0] + " " + ans[1]);

	}

}

//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]




// find one element using binary search




//public static void main(String[] args) {
//	// TODO Auto-generated method stub
////	int[] nums = {5,7,7,8,8,10};
//	int[] nums = {5,6,7,8,9,10};
//	int target = 0;
//	Solution s = new Solution();
//	System.out.println(s.searchRange(nums, target));
//
//}

