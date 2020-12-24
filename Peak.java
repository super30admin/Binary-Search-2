class Peak {
     public int findPeakElement(int[] nums) {
        
        int high = nums.length;
        int low = 0;
        return findpeak(high,low,nums);
    
     }
        
        
     public int findpeak( int high, int low, int[] nums)
        {
           int mid= low+ (high-low)/2;
           
            if(nums[mid]>=nums[mid-1] && nums[mid]>=nums[mid+1]) return mid;
            else if (nums[mid-1]>nums[mid]) return findpeak(mid-1, low, nums);
           else return findpeak(high, mid +1, nums);
        }
        
    
}