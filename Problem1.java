// Time Complexity :O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : if array contains only two same elements


// Your code here along with comments explaining your approach
class Problem1 {

    /** Search for left and right location of target */
    public int[] searchRange(int[] nums, int target) {
        
        // Search left
        int left = binarySearchLeft(nums, 0, nums.length-1, target);
        
        // if not found
        if(left ==-1){
            return new int[]{left,left};
        }
        // Search for right
        else{
            // using previously calculated left
            int right = binarySearchRight(nums, left, nums.length-1, target);
            return new int[] {left, right};
        }
        
    }
    
    int binarySearchLeft(int[] nums,int low, int high, int target){
        
        while(low<=high){
            
            // find mid
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                // mid should be greater than low for array out of bounds
                if(mid > low && nums[mid-1] == target)
                    high = mid-1;
                else
                    return mid;
                
            }else if(nums[mid] < target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        // not found
        return -1;
    }
    
    int binarySearchRight(int[] nums, int low, int high, int target){
        
         while(low<=high){

            int mid = low + (high-low)/2;
             
            if(nums[mid] == target){
                // mid should be less than high for array out of bounds
                if(mid < high && nums[mid+1] == target)
                    low = mid+1;
                else
                    return mid;
                
            }else if(nums[mid] < target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        } 
        // not found
        return -1;
    }
}