// Time Complexity : O(Log n)
// Space Complexity : O(1)

class Solution {
    public int findMin(int[] nums) {
        
        if(nums==null || nums.length==0) return -1;
        int lo=0;
        int hi= nums.length-1;
       int n=nums.length;
        if(nums.length==1)
            return nums[0];
       
        while(lo<=hi){
            //check if the lo has teh lowest element
             if(nums[lo]<=nums[hi]){
                return nums[lo];
            }
            //find mid element 
             int mid=lo+(hi-lo)/2;
            
            //check if middle is the smallest element 
            if((mid==lo || nums[mid]<nums[mid-1])  && (mid==hi || nums[mid]<nums[mid+1] )){
                  return nums[mid];
            }
              
            if(nums[lo] <=nums[mid]){
                lo=mid+1;
            }
               else{
                   hi=mid-1;
               }
            
    
    }
            return 4374632;  
}
               }
               