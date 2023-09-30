// Time Complexity : O(log n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

public class FindPeakIndex {
	
	public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high-low)/2;
            //If value at mid is greater than the neighbors, return index of mid
            if((mid ==0 || nums[mid] > nums[mid-1]) 
                && (mid == n-1 || (nums[mid] > nums[mid+1]))){
                return mid;
            }
            //If value at mid is less than right neighbor, move towards right
            else if(mid < n && nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            //value at mid is less than left neighbor, move towards left
            else{
                high = mid -1;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		FindPeakIndex obj = new FindPeakIndex();
		int[] nums = {1,2,3,1};
		
		int peak_index = obj.findPeakElement(nums);
		System.out.println("Peak is at index : " + peak_index);

	}

}
