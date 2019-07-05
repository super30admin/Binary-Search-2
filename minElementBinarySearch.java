//Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.

class Solution {
    public int findMin(int[] nums) {
        int right = nums.length-1;
        int left = 0;
        
        if(nums[left]<=nums[right])   //No rotation in sorted array
            return nums[0];
        
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            
             if(nums[mid+1]<nums[mid])    //check if crossing position
                return nums[mid+1];
            
            if(nums[mid-1]>nums[mid]) //check if crossing position
                return nums[mid];
            
            if(nums[left]<=nums[mid]) //keep searching [3,4,5,1,2]
                left = mid+1;
            else right = mid-1;
            
           
            
        }
     return -1; 
    }
}
