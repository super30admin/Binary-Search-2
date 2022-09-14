// Time Compexity : O(log n)
// Space Complexity : O(1)
// successfully executed on Leetcode
class Solution {
    public int findPeakElement(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int n =nums.length;
       // int nums[-1] = 
    
        if(nums==null || nums.length==0)
            return -1;
        
        while(lo<=hi){
            int mid= lo+(hi-lo)/2;
            
            // we are moving in the direction of increasing elements because it will
            // always have a peak element
            
            if((mid==lo ||nums[mid]>nums[mid-1]) && (mid==hi || nums[mid]>nums[mid+1]))
                return mid;
            
           
            if(mid==n-1 || nums[mid]<nums[mid+1])
                lo=mid+1;
            
            else
                hi=mid-1;
            
        }
    
            return 7654321;
    }
}