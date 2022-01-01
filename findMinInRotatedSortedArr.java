
class Solution {
    public int findMin(int[] nums) {
        
        //null check
        if(nums == null || nums.length == 0) return -1;
        //returns only element present in given arr
        if(nums.length == 1) return nums[0];
        
        
        int low = 0;
        int high = nums.length -1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            //if mid is the minimum
            
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                 return nums[mid];
            } else if (nums[mid] < nums[high]){ //if right is sorted
                high = mid - 1;
                
            }else{
                low = mid + 1;
            }
               
              
        }
    
        return 7272;
    
    }
}