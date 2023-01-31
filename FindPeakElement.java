/**
 * Author: Shubhangi
 * TC: O(logn)
 * SC: O(1)
 */
import java.util.Arrays;

class Solution {

    public static void main(String args[]) {
		int nums[]  = {1,2,1,3,5,6,4};
		Solution obj = new Solution();
		int ans = obj.findPeakElement(nums);
		System.out.println(ans);
	}
    public int findPeakElement(int[] nums) {
       if(nums.length == 0) return -1;
	   int start = 0, end = nums.length-1;
	   while(start <= end){
		   int mid = start + (end - start)/2;
		   if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
			   return mid;
		   }
		  if(mid > 0 && nums[mid] < nums[mid-1]){
			   end = mid -1;
		   } else { 
			   start = mid +1;
		   }
	   }
	   return -1;
    }
}