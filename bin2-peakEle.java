// TC:SC: O(log n)
class Solution {
    public int findPeakElement(int[] nums) {
        //null case
        if(nums==null||nums.length==0) return -1;
        int n=nums.length;
        if(n==1) return 0;
        
        if(nums[0]> nums[1] ) return 0;
        if(nums[n-1]> nums[n-2]) return n-1;
        
        int low=1;
        int high=n-2;
        
        while(low<=high){
         
            int mid= low+ (high-low)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            
            else if(nums[mid-1]>=nums[mid+1])
                high= mid-1;
            else
                low= mid+1;
        }
        return -1;
    }
}
