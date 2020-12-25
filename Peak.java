// time complexity: O(logn) 
// space comp: O(1);
//leetcode: yes



class Peak {
     public int findPeakElement(int[] nums) {
        
        int high = nums.length;
        int low = 0;
        return findpeak(high,low,nums);    // main output function call
    
     }
        
        
     public int findpeak( int high, int low, int[] nums)
        {
           int mid= low+ (high-low)/2;
           
            if(nums[mid]>=nums[mid-1] && nums[mid]>=nums[mid+1]) return mid;      // hits the peak
            else if (nums[mid-1]>nums[mid]) return findpeak(mid-1, low, nums);    // goes left half
           else return findpeak(high, mid +1, nums);                              // goest right half
        }
        
    
}