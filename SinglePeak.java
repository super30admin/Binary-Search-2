// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// I am using binary search to find peak, 
// 1. if mid element is greater than its left and right side then thats one of the 
// peak
// 2. if left side is greater than mid then look for peak in the left half
// 3. else look for peak in right part

public class SinglePeak {
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,1};
		int arr2[] = {1,2,3,4,5,6};
		int arr3[] = {1,2,1,3,5,6,4};
		
		System.out.println(findPeakElement(arr));
		System.out.println(findPeakElement(arr2));
		System.out.println(findPeakElement(arr3));
	}
	
	public static int findPeakElement(int[] nums) {
		
		if(null == nums || nums.length == 0) {
			return -1;
		}
		
		int low =0, high = nums.length - 1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])) {
				return mid;
			} else if(mid > 0 && nums[mid] < nums[mid-1]) {
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
