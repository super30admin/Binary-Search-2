/**Time complexity O(log n)
 * space complexity O(1)
 * Did this code successfully run on Leetcode : yes
 * Did you face any problem while coding this : no
 */

/**
 * if nums[mid]<nums[mid+1] then we are in increasing slope and the peak element is on the right side.
 * if nums[mid]>nums[mid+1] then we are in decreasing slope and the peak element is on the left side.
 * We can use binary search to find the peak element.
 */

class findPeakElement {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
     if(nums.length>1)
     {
        while(start<end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]<nums[mid+1])
            {
               start=mid+1; 
            }
            if(nums[mid]>nums[mid+1])
            {
                end=mid;
            }
           
        }
        return start;
     }
     else
     {
     return 0;
     }
        
        
    }

}