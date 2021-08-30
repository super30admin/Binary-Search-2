/*LeetCode run - Yes
 * Time Complexity - O(lg n)
 * Space Complexity - O(n)
 * */
import java.util.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int [] returnValues = new int[2];
        
        returnValues[0] = findFirstOccurrence(nums,target);
        returnValues[1] = findLastOccurrence(nums,target);
        
        return returnValues;
    }
    
    
    public int findFirstOccurrence(int [] nums, int target)
    {
        int low =0;
    	int high = nums.length-1;
    	int mid = low + (high-low)/2;
        
        
    	while(low <= high){
            mid = low + (high-low)/2;
            
            
            //first occurrence
            if (nums[mid] == target)
            {
                if (mid == 0 || nums[mid-1] != target){
                    //found first occurrence
                    return mid;
                    
                }
                else{
                    high = mid - 1 ;
                }
            }
            else if (nums[mid]< target)
            {
                low = mid+1;
            }
            else 
            {
                high=mid-1;
            }
        }
        
        return -1;
        
    }
    
    public int findLastOccurrence(int [] nums, int target)
    {
        int low =0;
    	int high = nums.length-1;
    	int mid = low + (high-low)/2;
        
        
    	while(low <= high){
            mid = low + (high-low)/2;
            
            //last occurrence
            if (nums[mid] == target)
            {
                if (mid == nums.length-1 || nums[mid+1]!=target){
                    //found last occurrence
                    return mid;
                    
                }
                else{
                    low = mid + 1 ;
                }
            }
            else if (nums[mid]< target)
            {
                low = mid+1;
            }
            else 
            {
                high=mid-1;
            }
        }
        
        return -1;
        
    }
    
    /*public static void main(String args[]) 
    {
    	
    	Solution sol = new Solution();
    	int[] arr = new int[] {1,2,3,10};
    	
    	System.out.println(Arrays.toString(sol.searchRange(arr,10)));
    	
    }*/
}