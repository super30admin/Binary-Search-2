//log(n) time : 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.

class Solution {
     public  int[] searchRange(int[] nums, int target) {
	        int left =0;
	        int right = nums.length-1;
	        int pos[] ={-1,-1};   //initial positions
	        
	        while(left<=right)
	        {
	            int mid = left+(right-left)/2;
	            
	        if (target == nums[mid])
	         {
	            int start = mid;
	            int end = mid;
	            pos[0] = start;
	            pos[1] = end;
	            
	             while(start>=left&&target==nums[start] ||end<=right&& target ==nums[end]) //finding the starting and ending index of target
	             {  start--;
	                end++;
	              
	                 if(start>=left&&target==nums[start])
	                     pos[0] = start;
	                   
	                 if(end<=right&&target==nums[end])
	                      pos[1] = end;
	             }
	            
	            return  pos;    //return[start,end]
	        }
	             else if (target<=nums[mid])
	                 right = mid-1;
	            else left = mid+1;
	        }
	            return pos;
	    }
}
