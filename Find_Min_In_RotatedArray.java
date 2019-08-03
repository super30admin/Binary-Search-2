/* Author: Ankita Patil
 * Description: 153. Find Minimum in Rotated Sorted Array
 */

import java.util.*;
import java.io.*;

public class Find_Min_In_RotatedArray {

	public static void main(String[] args) {
		int[] nums= {4,5,6,7,1,2};
	
		System.out.println("Minimum value in an Array : " + findMinVal(nums) );
	}
	
	public static int findMinVal(int[] nums) {
		 int low = 0;
		 int high = nums.length-1;
			//Check if array is null
		if(nums == null) return -1;
			//Run binary search on the array
		while(low <= high) {
			if(low == high) return nums[low];
				
			int mid = low + (high -low)/2;
			if(nums[mid] > nums[high]) low = mid+1;
			if(nums[mid] < nums[high]) high = mid;
		}
			
		return -1;
	}

}
