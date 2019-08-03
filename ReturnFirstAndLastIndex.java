/*Author: Ankita Patil
 * Description: 34. Find First and Last Position of Element in Sorted Array
 */

import java.util.*;
import java.io.*;


public class ReturnFirstAndLastIndex {
	
	public static void main(String[] args) {
		int[] nums= {5,7,7,8,8,10};
		int target = 8;
		int[] result = new int[2];
		System.out.println("First and last index are as follows: ");
		result = findIndex(nums,target);
		System.out.println(Arrays.toString(result));
	}

	public static int[] findIndex(int[] nums, int target) {
		  int low = 0;
	        int high = nums.length -1;
	        int startIndex = -1;
	        // Apply Binary search to find target and return the mid value 
	        while(low <= high){
	           int mid = low+(high - low)/2;
	            
	            if(nums[mid] == target){
	                startIndex = mid;
	                break;
	            }
	            //If the taget is lesser than the mid, discard the right sub-array
	            if(nums[mid] > target){
	                high = mid-1;
	                
	            }else// //If the taget is greater than the mid, discard the left sub-array
	            {
	                low = mid+1;
	            }
	        }
	        //check if target value found or not
	        if(startIndex !=-1){
	            // Move low pointer to lower index untill it matches the target value
	            for(low = startIndex ;low > 0 && nums[low-1] == target ; low--);
	            // Move high pointer to higher index untill it matches the target value
	            for(high = startIndex; high < nums.length-1 && nums[high+1] ==target;high++);
	            //Finally return the low and high indexes
	            return new int[]{low,high};
	        }
	      
	       return new int[]{-1,-1};    
	        
	    }
}

