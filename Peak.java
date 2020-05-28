class Solution {
    public int findPeakElement(int[] nums) {
        //1.define low and high
        //2. start zBs
        //3.is this a peak?
        //4. take app. action
        
        
        //1.
        
        int low = 0;
        int high = nums.length-1;
        //2.
        
        while(low<=high){
            
            
            int mid = low +(high-low)/2;
            //3.
            if((mid==0||nums[mid-1]<nums[mid])&&(mid ==nums.length-1||nums[mid+1]<nums[mid])){
                return mid;
                
            }else if(mid!=0&&nums[mid-1]>nums[mid]){
                high = mid -1;
                
                
            }else{
                low = mid+1;
            }
            
            
            
            
        }
        return -1;
        
    }
}

//Time Complexity: O(log n)
//Space Complexity O(1)